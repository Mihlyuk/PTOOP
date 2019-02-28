package graphics_editor.drawers;

import graphics_editor.shapes.base.PointShape;
import graphics_editor.shapes.base.PolygonShape;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;

/**
 * Drawer for polygons
 */
public class PolygonDrawer extends Drawer<PolygonShape> {

    public PolygonDrawer(PolygonShape shape) {
        super(shape);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        List<PointShape> points = shape.getPoints();
        if (points.isEmpty()) return;

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
