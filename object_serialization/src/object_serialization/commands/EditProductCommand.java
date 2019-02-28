package object_serialization.commands;

import object_serialization.view.ProductMenu;
import object_serialization.products.Product;

import java.io.IOException;

/**
 * Adds the ability to change product information.
 */
@CommandItem
public class EditProductCommand extends AbstractCommand {

    public EditProductCommand(ProductMenu productMenu) {
        super(productMenu);
    }

    @Override
    public String getCommandName() {
        return "Edit product";
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
                try {
                    editProduct(productIndex);
                    break;
                } catch (IOException | NumberFormatException e) {
                    System.err.println("Please input correct values: Cost - Integer, Name - String, Weight - Integer.");
                }
            }
        }
    }

    /**
     * Edits parameters for product
     *
     * @param productIndex index of product
     * @throws IOException           invalid parameter value
     * @throws NumberFormatException invalid parameter value
     */
    private void editProduct(int productIndex) throws IOException, NumberFormatException {
        System.out.println("Input cost:");
        int cost = readInteger();

        System.out.println("Input name:");
        String name = readString();

        System.out.println("Input weight:");
        int weight = readInteger();

        Product product = products.get(productIndex);
        product.setCost(cost);
        product.setName(name);
        product.setWeight(weight);
    }

    private boolean isValidProductIndex(Integer productIndex) {
        return productIndex != null && productIndex.compareTo(products.size()) < 0;
    }
}
