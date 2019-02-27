package shapes;

import shapes.base.PointShape;
import shapes.base.PolygonShape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TriangleShape extends PolygonShape {
    public static List<String> propertyNames = new ArrayList<>();
    static {
        propertyNames.add("Radius");
        propertyNames.add("Center x");
        propertyNames.add("Center y");
    }

    public TriangleShape(double radius, PointShape center) {
        super(center, radius, 3);
    }

    public TriangleShape(PointShape a, PointShape b, PointShape c) {
        super(Arrays.asList(a, b, c));
    }

    @Override
    public String toString() {
        return "TriangleShape{" +
                "points=" + getPoints() +
                "}";
    }

    /**
     * Construct new TriangleShape instance which is built from properties
     * @param propertiesValues properties for triangle
     * @return new TriangleShape instance
     */
    public static TriangleShape constructShape(Map<String, Integer> propertiesValues) {
        return new TriangleShape(propertiesValues.get("Radius"), new PointShape(propertiesValues.get("Center x"), propertiesValues.get("Center y")));
    }
}
