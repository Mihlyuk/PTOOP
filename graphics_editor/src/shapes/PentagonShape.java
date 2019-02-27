package shapes;

import shapes.base.PointShape;
import shapes.base.PolygonShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PentagonShape extends PolygonShape {
    public static List<String> propertyNames = new ArrayList<>();
    static {
        propertyNames.add("Radius");
        propertyNames.add("Center x");
        propertyNames.add("Center y");
    }

    public PentagonShape(double R, PointShape center) {
        super(center, R, 5);
    }

    @Override
    public String toString() {
        return "PentagonShape{" +
                "points=" + getPoints() +
                "}";
    }

    /**
     * Construct new PentagonShape instance which is built from properties
     * @param propertiesValues properties for pentagon
     * @return new PentagonShape instance
     */
    public static PentagonShape constructShape(Map<String, Integer> propertiesValues) {
        return new PentagonShape(propertiesValues.get("Radius"), new PointShape(propertiesValues.get("Center x"), propertiesValues.get("Center y")));
    }
}
