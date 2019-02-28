package drawers;

import java.awt.Graphics2D;

/**
 * Drawer for the shapes
 */
public class Drawer<ShapeType> {
    ShapeType shape;

    public Drawer(ShapeType shape) {
        this.shape = shape;
    }

    public ShapeType getShape() {
        return shape;
    }

    public void setShape(ShapeType shape) {
        this.shape = shape;
    }

    /**
     * Draws the shapes
     *
     * @param graphics2D graphics
     */
    public void draw(Graphics2D graphics2D) throws Exception {
        throw new Exception("Method draw NotImplemented in class: " + Drawer.class);
    }
}
