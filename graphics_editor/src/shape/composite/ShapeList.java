package shape.composite;

import drawing.shape.ShapeDrawer;
import drawing.shape.composite.ShapeListDrawer;
import shape.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite for shapes
 */
public class ShapeList implements Shape {
    private List<Shape> shapeList;
    private ShapeDrawer shapeDrawer;

    public ShapeList() {
        this(new ArrayList<>());
    }

    public ShapeList(List<Shape> shapeList) {
        this.shapeList = shapeList;
        shapeDrawer = new ShapeListDrawer(this);
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public void setShapeList(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public void add(Shape shape) {
        shapeList.add(shape);
    }

    @Override
    public ShapeDrawer getShapeDrawer() {
        return shapeDrawer;
    }
}
