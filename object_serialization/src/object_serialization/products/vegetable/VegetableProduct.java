package object_serialization.products.vegetable;

import object_serialization.products.AbstractProduct;

/**
 * Base vegetable class
 */
public abstract class VegetableProduct extends AbstractProduct {

    public VegetableProduct() {
        super();
    }

    public VegetableProduct(int weight, String name, int cost) {
        super(weight, name, cost);
    }

    public boolean isSuitableForVegans() {
        return true;
    }
}
