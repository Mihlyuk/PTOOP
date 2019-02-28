package graphics_editor.shapes;

import graphics_editor.drawers.LineDrawer;
import graphics_editor.drawers.Drawer;
import graphics_editor.shapes.base.PointShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
