package shapes.base;

import drawing.PolygonDrawer;
import drawing.Drawer;
import shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * The basic class for Heptagon, PolygonShape, TriangleShape
 */
public class PolygonShape implements Shape {
    private List<PointShape> points;
    private Drawer shapeDrawer;

    public PolygonShape(PointShape center, double r, int n) {
        this();
        if (r < 0) {
            throw new IllegalArgumentException("Radius should be positive.");
        }
        if (n < 3) {
            throw new IllegalArgumentException("The amount of angles should be more than 2.");
        }
        fillPoints(center, r, n);
    }

    /**
     * Fills point for equilateral polygon
     *
     * @param center center
     * @param r      radius
     * @param n      number of angles
     */
    private void fillPoints(PointShape center, double r, int n) {
        double angle = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            PointShape point2D = new PointShape();
            double x = center.getX() + r * Math.cos(angle * i);
            double y = center.getY() - r * Math.sin(angle * i);
            point2D.setX(x);
            point2D.setY(y);
            points.add(point2D);
        }
    }

    public PolygonShape() {
        this(new ArrayList<>());
    }

    public PolygonShape(List<PointShape> points) {
        this.points = points;
        shapeDrawer = new PolygonDrawer(this);
    }

    public List<PointShape> getPoints() {
        return points;
    }

    protected void setPoints(List<PointShape> points) {
        this.points = points;
    }

    @Override
    public Drawer getShapeDrawer() {
        return shapeDrawer;
    }

    @Override
    public String toString() {
        return "PolygonShape{" +
                "points=" + points +
                '}';
    }
}
