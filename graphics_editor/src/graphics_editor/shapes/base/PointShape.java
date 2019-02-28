package graphics_editor.shapes.base;

public class PointShape {
    private double x;
    private double y;

    public PointShape() {
        this(0, 0);
    }

    public PointShape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
