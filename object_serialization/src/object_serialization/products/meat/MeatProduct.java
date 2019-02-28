package object_serialization.products.meat;

import object_serialization.products.AbstractProduct;

/**
 * Base meat class
 */
public abstract class MeatProduct extends AbstractProduct {

    public MeatProduct() {
        super();
    }

    public MeatProduct(int weight, String name, int cost) {
        super(weight, name, cost);
    }

    public boolean isSuitableForVegans() {
        return false;
    }
}
