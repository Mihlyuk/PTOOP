package object_serialization.products.meat;

import object_serialization.products.ProductItem;

@ProductItem
public class Sausage extends MeatProduct {
    public static float TAX_FACTOR = 0.2f;

    public Sausage() {
        super();
    }

    public Sausage(int weight, String name, int cost) {
        super(weight, name, cost);
    }

    @Override
    public float getTax() {
        return cost * TAX_FACTOR;
    }
}
