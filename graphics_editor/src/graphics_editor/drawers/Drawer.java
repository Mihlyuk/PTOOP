package graphics_editor.drawers;

import java.awt.Graphics2D;

/**
 * Drawer for the shapes
 */
public abstract class Drawer<ShapeType> {
    ShapeType shape;

    Drawer(ShapeType shape) {
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
    public abstract void draw(Graphics2D graphics2D);
}
