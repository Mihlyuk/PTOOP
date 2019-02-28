package graphics_editor.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import graphics_editor.shapes.Shape;
import utils.ClassSearcher;

public class MainFrame extends JFrame {
    private ShapeDrawingPanel shapeDrawPanel;
    private JPanel toolsPanel;

    public MainFrame(String title) throws HeadlessException {
        setTitle(title);
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize shape drawers panel
        shapeDrawPanel = new ShapeDrawingPanel();
        add(shapeDrawPanel, BorderLayout.CENTER);

        // Initialize tools panel
        toolsPanel = new JPanel();
        toolsPanel.setBorder(BorderFactory.createEtchedBorder());
        toolsPanel.setPreferredSize(new Dimension(200, 500));
        add(toolsPanel, BorderLayout.EAST);

        updateToolsPanel();
    }

    private void updateToolsPanel() {
        List<Class> shapeClasses = getShapeClasses();

        for (Class shapeClass : shapeClasses) {
            JButton jButton = new JButton(shapeClass.getSimpleName());
            jButton.setPreferredSize(new Dimension(150, 30));
            jButton.addActionListener(buttonActionListener(shapeClass));
            toolsPanel.add(jButton);
        }
    }

    /**
     * Listener for each button which creates shapes
     *
     * @param shapeClass shapes class for creating
     * @return new button listener
     */
    private ActionListener buttonActionListener(Class shapeClass) {
        ActionListener actionListener = e -> {
            List<String> shapePropertiesNames;

            try {
                shapePropertiesNames = getShapePropertyNames(shapeClass);
            } catch (IllegalAccessException | NoSuchFieldException e1) {
                JOptionPane.showMessageDialog(this, "Shape inheritor should have 'propertyNames' field.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Map<String, JSpinner> shapeFields = new HashMap<>();
            buildShapeFieldsDialog(shapeFields, shapePropertiesNames);

            try {
                Shape newShape = buildNewShape(shapeClass, shapeFields);
                shapeDrawPanel.addShape(newShape);
                shapeDrawPanel.repaint();
            } catch (NoSuchMethodException e1) {
                JOptionPane.showMessageDialog(this, "Shape inheritor should have 'constructShape' method.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalAccessException e1) {
                JOptionPane.showMessageDialog(this, "'constructShape' method should be public static.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (InvocationTargetException e1) {
                JOptionPane.showMessageDialog(this, e1, "Error", JOptionPane.ERROR_MESSAGE);
            }
        };
        return actionListener;
    }

    /**
     * Builds shapes fields dialog and fills fields for the shapes
     *
     * @param shapeFields          fields map with name
     * @param shapePropertiesNames list of properties names
     */
    private void buildShapeFieldsDialog(Map<String, JSpinner> shapeFields, List<String> shapePropertiesNames) {
        List<Component> windowFields = new ArrayList<>();

        for (String propertyName : shapePropertiesNames) {
            JLabel fieldLabel = new JLabel(propertyName);
            JSpinner numberSpinner = new JSpinner(new SpinnerNumberModel());
            shapeFields.put(propertyName, numberSpinner);
            windowFields.add(fieldLabel);
            windowFields.add(numberSpinner);
        }

        JOptionPane.showConfirmDialog(this, windowFields.toArray(), "Input values.", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Builds new Shape
     *
     * @param shapeClass  shapes class for creating
     * @param shapeFields fields with values for creating new shapes
     * @return new Shape
     * @throws NoSuchMethodException     throws if constructShape is not presented
     * @throws InvocationTargetException throws if constructShape throws new Exceptions
     * @throws IllegalAccessException    throws if constructShape has no access
     */
    private Shape buildNewShape(Class shapeClass, Map<String, JSpinner> shapeFields) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method constructShapeMethod = shapeClass.getMethod("constructShape", Map.class);
        Map<String, Integer> shapeProperties = new HashMap<>();
        for (Map.Entry<String, JSpinner> shapeField : shapeFields.entrySet()) {
            shapeProperties.put(shapeField.getKey(), (Integer) shapeField.getValue().getValue());
        }
        return (Shape) constructShapeMethod.invoke(null, shapeProperties);
    }

    /**
     * Retrieves property names for Shape class
     *
     * @param shapeName shapes class
     * @return property names
     * @throws NoSuchFieldException   throws if propertyNames is not presented
     * @throws IllegalAccessException throws if propertyNames has no access
     */
    private List<String> getShapePropertyNames(Class shapeName) throws NoSuchFieldException, IllegalAccessException {
        Field field = shapeName.getField("propertyNames");
        List<String> propertyNames = (List<String>) field.get(null);
        return propertyNames;
    }

    /**
     * Retrieves shapes classes from the shapes package
     *
     * @return shapes classes
     */
    private List<Class> getShapeClasses() {
        List<Class> shapeClasses = new ArrayList<>();
        String shapesPackageName = "graphics_editor.shapes";

        try {
            shapeClasses = ClassSearcher.getClassesFromPackage(shapesPackageName, Shape.class);
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(MainFrame.this, "The error while trying to extract classes from '" + shapesPackageName + "' package", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return shapeClasses;
    }
}
