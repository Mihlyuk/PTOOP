package object_serialization.commands;

import object_serialization.view.ProductMenu;
import object_serialization.products.Product;

import java.util.List;

/**
 * Removes product by index
 */
@CommandItem
public class RemoveProductCommand extends AbstractCommand {

    public RemoveProductCommand(ProductMenu productMenu) {
        super(productMenu);
    }

    @Override
    public String getCommandName() {
        return "Remove product";
    }

    @Override
    public void run() {
        if (products.isEmpty()) {
            System.out.println("Product list is empty.");
            return;
        }

        while (true) {
            System.out.println("Please, input index of product: ");

            Integer productIndex = readInteger();
            if (isValidProductIndex(productIndex)) {
                products.remove(productIndex.intValue());
                break;
            } else {
                System.out.println("Please, input number: 0-" + (products.size()));
            }
        }
    }

    private boolean isValidProductIndex(Integer productIndex) {
        return productIndex != null && productIndex.compareTo(products.size()) < 0;
    }
}
