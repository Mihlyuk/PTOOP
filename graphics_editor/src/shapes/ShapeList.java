package shapes;

import drawing.Drawer;
import drawing.ShapeListDrawer;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite for shapes
 */
public class ShapeList {
    private List<Shape> shapeList;
    private Drawer shapeDrawer;

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

    public Drawer getShapeDrawer() {
        return shapeDrawer;
    }
}
