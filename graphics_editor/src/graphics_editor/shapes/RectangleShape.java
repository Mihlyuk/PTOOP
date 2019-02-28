package graphics_editor.shapes;

import graphics_editor.shapes.base.PointShape;
import graphics_editor.shapes.base.PolygonShape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RectangleShape extends PolygonShape {
    public static List<String> propertyNames = new ArrayList<>();
    static {
        propertyNames.add("Left top x");
        propertyNames.add("Left top y");
        propertyNames.add("Right bottom x");
        propertyNames.add("Right bottom y");
    }

    public RectangleShape(PointShape a, PointShape c) {
        super();
        if (c.getY() < a.getY()) {
            throw new IllegalArgumentException("c.x should be more than a.x.");
        }
        if (c.getX() < a.getX()) {
            throw new IllegalArgumentException("c.y should be more than a.y.");
        }
        fillPoints(a, c);
    }

    /**
     * Fill right top and left bottom points for the rectangle
     * @param a left top point
     * @param c right bottom point
     */
    public void fillPoints(PointShape a, PointShape c) {
        double height = c.getY() - a.getY();
        PointShape b = new PointShape();
        PointShape d = new PointShape();
        b.setX(a.getX());
        b.setY(a.getY() + height);
        d.setX(c.getX());
        d.setY(c.getY() - height);
        setPoints(Arrays.asList(a, b, c, d));
    }

    /**
     * Construct new RectangleShape instance which is built from properties
     * @param propertiesValues properties for rectangle
     * @return new RectangleShape instance
     */
    public static RectangleShape constructShape(Map<String, Integer> propertiesValues) {
        return new RectangleShape(new PointShape(propertiesValues.get("Left top x"), propertiesValues.get("Left top y")),
                new PointShape(propertiesValues.get("Right bottom x"), propertiesValues.get("Right bottom y")));
    }
}
