package drawing;

import shapes.base.PointShape;
import shapes.base.PolygonShape;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;

/**
 * Drawer for polygons
 */
public class PolygonDrawer implements Drawer {
    private PolygonShape polygon2D;

    public PolygonDrawer(PolygonShape polygon2D) {
        this.polygon2D = polygon2D;
    }

    public PolygonShape getPolygon2D() {
        return polygon2D;
    }

    public void setPolygon2D(PolygonShape polygon2D) {
        this.polygon2D = polygon2D;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        List<PointShape> points = polygon2D.getPoints();

        if (points.isEmpty()) {
            return;
        }

        Path2D path = new Path2D.Double();
        PointShape firstPoint = points.get(0);
        path.moveTo(firstPoint.getX(), firstPoint.getY());
        for (int i = 1; i < points.size(); i++) {
            PointShape point2D = points.get(i);
            path.lineTo(point2D.getX(), point2D.getY());
        }

        path.closePath();
        graphics2D.draw(path);
    }
}
