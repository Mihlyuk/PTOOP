package graphics_editor.shapes;

import graphics_editor.shapes.base.PointShape;
import graphics_editor.shapes.base.PolygonShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HeptagonShape extends PolygonShape {
    public static List<String> propertyNames = new ArrayList<>();

    static {
        propertyNames.add("Radius");
        propertyNames.add("Center x");
        propertyNames.add("Center y");
    }

    public HeptagonShape(double R, PointShape center) {
        super(center, R, 7);
    }

    /**
     * Construct new HeptagonShape instance which is built from properties
     *
     * @param propertiesValues properties for heptagon
     * @return new HeptagonShape instance
     */
    public static HeptagonShape constructShape(Map<String, Integer> propertiesValues) {
        return new HeptagonShape(propertiesValues.get("Radius"), new PointShape(propertiesValues.get("Center x"), propertiesValues.get("Center y")));
    }
}
