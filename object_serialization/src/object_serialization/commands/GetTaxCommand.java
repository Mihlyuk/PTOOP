package object_serialization.commands;

import object_serialization.products.Product;
import object_serialization.view.ProductMenu;

/**
 * Gets tax from product
 */
@CommandItem
public class GetTaxCommand extends AbstractCommand {

    public GetTaxCommand(ProductMenu productMenu) {
        super(productMenu);
    }

    @Override
    public String getCommandName() {
        return "Get tax";
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
            if (productIndex != null && productIndex.compareTo(products.size()) < 0) {
                Product product = products.get(productIndex);
                System.out.println(product.getTax());
                break;
            }
        }
    }
}
