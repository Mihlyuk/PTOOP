package views;

import shapes.ShapeList;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Panel for drawing shapes
 */
public class ShapeDrawingPanel extends JPanel {
    private ShapeList shapeList;

    ShapeDrawingPanel(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        shapeList.getShapeDrawer().draw(g2d);
    }
}
