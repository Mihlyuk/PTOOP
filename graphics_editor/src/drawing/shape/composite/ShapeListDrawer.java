package drawing.shape.composite;

import drawing.shape.ShapeDrawer;
import shape.Shape;
import shape.composite.ShapeList;

import java.awt.*;
import java.util.List;

/**
 * Drawer for shape composite
 */
public class ShapeListDrawer implements ShapeDrawer {
    private ShapeList shapeList;

    public ShapeListDrawer(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    public ShapeList getShapeList() {
        return shapeList;
    }

    public void setShapeList(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        List<Shape> shapes = shapeList.getShapeList();
        for (Shape shape : shapes) {
            shape.getShapeDrawer().draw(graphics2D);
        }
    }
}
