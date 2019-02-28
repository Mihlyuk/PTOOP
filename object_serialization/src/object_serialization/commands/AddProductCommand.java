package object_serialization.commands;

import object_serialization.products.Product;
import object_serialization.view.ProductMenu;

/**
 * Command to add products
 */
@CommandItem
public class AddProductCommand extends AbstractCommand {

    public AddProductCommand(ProductMenu productMenu) {
        super(productMenu);
    }

    @Override
    public String getCommandName() {
        return "Add product";
    }

    @Override
    public void run() {
        if (productNames.isEmpty()) {
            System.out.println();
            return;
        }

        while (true) {
            for (int i = 0; i < productNames.size(); i++) {
                System.out.println(String.format("%d: %s", i, productNames.get(i).getSimpleName()));
            }

            Integer productItemIndex = readInteger();
            if (isValidProductIndex(productItemIndex)) {
                Class productClass = productNames.get(productItemIndex);
                try {
                    Product newProduct = (Product) productClass.newInstance();
                    products.add(newProduct);
                    break;
                } catch (InstantiationException e) {
                    System.err.println("Cannot instantiate object for " + productClass.getSimpleName());
                } catch (IllegalAccessException e) {
                    System.err.println(productClass.getSimpleName() + " has no access for creation");
                }
            } else {
                System.out.println("Please, input number: 0-" + (productNames.size()));
            }
        }
    }

    private boolean isValidProductIndex(Integer productIndex) {
        return productIndex != null && productIndex.compareTo(productNames.size()) < 0;
    }
}
