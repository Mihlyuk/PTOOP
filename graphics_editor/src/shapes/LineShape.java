package shapes;

import drawers.LineDrawer;
import drawers.Drawer;
import shapes.base.PointShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LineShape implements Shape {
    private PointShape p1;
    private PointShape p2;
    private Drawer shapeDrawer;

    public static List<String> propertyNames = new ArrayList<>();
    static {
        propertyNames.add("PointShape A x");
        propertyNames.add("PointShape A y");
        propertyNames.add("PointShape B x");
        propertyNames.add("PointShape B y");
    }

    public LineShape() {
        this(new PointShape(), new PointShape());
    }

    public LineShape(PointShape p1, PointShape p2) {
        this.p1 = p1;
        this.p2 = p2;
        shapeDrawer = new LineDrawer(this);
    }

    public PointShape getP1() {
        return p1;
    }

    public void setP1(PointShape p1) {
        this.p1 = p1;
    }

    public PointShape getP2() {
        return p2;
    }

    public void setP2(PointShape p2) {
        this.p2 = p2;
    }

    @Override
    public Drawer getShapeDrawer() {
        return shapeDrawer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineShape line2D = (LineShape) o;
        return Objects.equals(p1, line2D.p1) &&
                Objects.equals(p2, line2D.p2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(p1, p2);
    }

    @Override
    public String toString() {
        return "LineShape{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

    /**
     * Construct new LineShape instance which is built from properties
     * @param propertiesValues properties for line
     * @return new LineShape instance
     */
    public static LineShape constructShape(Map<String, Integer> propertiesValues) {
        return new LineShape(new PointShape(propertiesValues.get("PointShape A x"), propertiesValues.get("PointShape A y")),
                new PointShape(propertiesValues.get("PointShape B x"), propertiesValues.get("PointShape B y")));
    }
}
