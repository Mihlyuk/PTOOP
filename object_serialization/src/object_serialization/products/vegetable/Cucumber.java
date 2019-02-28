package object_serialization.products.vegetable;

import object_serialization.products.ProductItem;

@ProductItem
public class Cucumber extends VegetableProduct {
    public static float TAX_FACTOR = 0.2f;

    public Cucumber() {
        super();
    }

    public Cucumber(int weight, String name, int cost) {
        super(weight, name, cost);
    }

    @Override
    public float getTax() {
        return cost * TAX_FACTOR / 1.15f;
    }
}
