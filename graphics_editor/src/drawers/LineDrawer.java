package drawers;

import shapes.LineShape;

import java.awt.*;

/**
 * Drawer for LineShape
 */
public class LineDrawer extends Drawer<LineShape> {

    public LineDrawer(LineShape shape) {
        super(shape);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.draw(new java.awt.geom.Line2D.Double(
                shape.getP1().getX(), shape.getP1().getY(),
                shape.getP2().getX(), shape.getP2().getY()));
    }
}
