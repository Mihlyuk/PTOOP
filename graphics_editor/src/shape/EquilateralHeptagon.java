package shape;

import util.Point2D;
import util.Polygon2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EquilateralHeptagon extends Polygon2D {
    public static List<String> propertyNames = new ArrayList<>();
    static {
        propertyNames.add("Radius");
        propertyNames.add("Center x");
        propertyNames.add("Center y");
    }

    public EquilateralHeptagon(double R, Point2D center) {
        super(center, R, 7);
    }

    @Override
    public String toString() {
        return "EquilateralHeptagon{" +
                "points=" + getPoints() +
                "}";
    }

    /**
     * Construct new EquilateralHeptagon instance which is built from properties
     * @param propertiesValues properties for heptagon
     * @return new EquilateralHeptagon instance
     */
    public static EquilateralHeptagon constructShape(Map<String, Integer> propertiesValues) {
        return new EquilateralHeptagon(propertiesValues.get("Radius"), new Point2D(propertiesValues.get("Center x"), propertiesValues.get("Center y")));
    }
}
