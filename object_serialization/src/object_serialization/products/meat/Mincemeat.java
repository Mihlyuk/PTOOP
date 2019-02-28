package object_serialization.products.meat;

import object_serialization.products.ProductItem;

@ProductItem
public class Mincemeat extends MeatProduct {
    public static float TAX_FACTOR = 0.2f;

    public Mincemeat() {
        super();
    }

    public Mincemeat(int weight, String name, int cost) {
        super(weight, name, cost);
    }

    public float getTax() {
        return cost * TAX_FACTOR + 5;
    }
}
