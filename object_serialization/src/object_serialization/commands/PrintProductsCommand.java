package object_serialization.commands;

import object_serialization.view.ProductMenu;
import object_serialization.products.Product;

import java.util.List;

@CommandItem
public class PrintProductsCommand extends AbstractCommand {

    public PrintProductsCommand(ProductMenu productMenu) {
        super(productMenu);
    }

    @Override
    public String getCommandName() {
        return "Print all products";
    }

    @Override
    public void run() {
        List<Product> productList = productMenu.getProductList();
        productList.forEach(System.out::println);
    }
}
