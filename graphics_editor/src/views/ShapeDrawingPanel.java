package views;

import shapes.Shape;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Panel for drawing shapes
 */
public class ShapeDrawingPanel extends JPanel {
    private Shape shape;

    ShapeDrawingPanel() {
        this.shape = null;
    }

    ShapeDrawingPanel(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (shape == null) return;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        shape.getShapeDrawer().draw(g2d);
    }
}
