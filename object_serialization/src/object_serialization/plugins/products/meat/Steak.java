package object_serialization.plugins.products.meat;

import object_serialization.products.ProductItem;
import object_serialization.products.meat.MeatProduct;

/**
 * Steak product
 */
@ProductItem
public class Steak extends MeatProduct {
    public static float TAX_FACTOR = 0.228f;

    public Steak() {
        super();
    }

    public Steak(int weight, String name, int cost) {
        super(weight, name, cost);
    }

    @Override
    public float getTax() {
        return (float) ((cost * TAX_FACTOR) * Math.exp(TAX_FACTOR) / Math.PI);
    }
}
