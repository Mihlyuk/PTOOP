package drawing;

import shapes.LineShape;

import java.awt.*;

/**
 * Drawer for LineShape
 */
public class Line2DDrawer implements Drawer {
    private LineShape line2D;

    public Line2DDrawer(LineShape line2D) {
        this.line2D = line2D;
    }

    public LineShape getLine2D() {
        return line2D;
    }

    public void setLine2D(LineShape line2D) {
        this.line2D = line2D;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.draw(new java.awt.geom.Line2D.Double(line2D.getP1().getX(), line2D.getP1().getY(), line2D.getP2().getX(), line2D.getP2().getY()));
    }
}
