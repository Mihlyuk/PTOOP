package shapes;

import drawing.CircleDrawer;
import drawing.Drawer;
import shapes.base.PointShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CircleShape implements Shape {
    private double r;
    private PointShape center;
    private Drawer shapeDrawer;
    public static List<String> propertyNames = new ArrayList<>();

    static {
        propertyNames.add("Radius");
        propertyNames.add("Center x");
        propertyNames.add("Center y");
    }

    public CircleShape() {
        this(1, new PointShape());
    }

    public CircleShape(double r, PointShape center) {
        if (r < 0) {
            throw new IllegalArgumentException("Radius should be positive.");
        }
        this.r = r;
        this.center = center;
        shapeDrawer = new CircleDrawer(this);
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public PointShape getCenter() {
        return center;
    }

    public void setCenter(PointShape center) {
        this.center = center;
    }

    @Override
    public Drawer getShapeDrawer() {
        return shapeDrawer;
    }

    /**
     * Construct new CircleShape instance which is built from properties
     *
     * @param propertiesValues properties for circle
     * @return new CircleShape instance
     */
    public static CircleShape constructShape(Map<String, Integer> propertiesValues) {
        return new CircleShape(propertiesValues.get("Radius"), new PointShape(propertiesValues.get("Center x"), propertiesValues.get("Center y")));
    }
}
