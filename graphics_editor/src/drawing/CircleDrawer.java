package drawing;

import shapes.CircleShape;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Drawer for circle
 */
public class CircleDrawer implements Drawer {
    private CircleShape circle;

    public CircleDrawer(CircleShape circle) {
        this.circle = circle;
    }

    public CircleShape getCircle() {
        return circle;
    }

    public void setCircle(CircleShape circle) {
        this.circle = circle;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.draw(new Ellipse2D.Double(circle.getCenter().getX(), circle.getCenter().getY(), circle.getR(), circle.getR()));
    }
}
