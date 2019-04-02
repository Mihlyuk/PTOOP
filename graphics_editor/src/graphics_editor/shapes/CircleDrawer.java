package graphics_editor.shapes;

import graphics_editor.drawers.CircleShape;
import graphics_editor.drawers.Drawer;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * Drawer for circle
 */
public class CircleDrawer extends Drawer<CircleShape> {

    public CircleDrawer(CircleShape shape) {
        super(shape);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.draw(new Ellipse2D.Double(
                shape.getCenter().getX(), shape.getCenter().getY(),
                shape.getR(), shape.getR()));
    }
}
