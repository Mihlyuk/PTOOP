package drawers;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import shapes.CircleShape;

/**
 * Drawer for circle
 */
public class CircleDrawer extends Drawer<CircleShape> {

    public CircleDrawer(CircleShape shape) {
        super(shape);
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.draw(new Ellipse2D.Double(
                shape.getCenter().getX(), shape.getCenter().getY(),
                shape.getR(), shape.getR()));
    }
}
