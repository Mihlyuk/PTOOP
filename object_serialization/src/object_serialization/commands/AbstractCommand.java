package object_serialization.commands;

import object_serialization.products.Product;
import object_serialization.products.ProductPluginManager;
import object_serialization.view.ProductMenu;

import java.util.List;

/**
 * Base class for commands.
 * Each class must implement the run method.
 */
public abstract class AbstractCommand implements Runnable {
    protected ProductMenu productMenu;
    protected List<Class> productNames;
    protected List<Product> products;
    protected ProductPluginManager productPluginManager;

    protected AbstractCommand(ProductMenu productMenu) {
        this.productMenu = productMenu;
        this.productNames = productMenu.getProductNameList();
        this.products = productMenu.getProductList();
        this.productPluginManager = productMenu.getProductPluginManager();
    }

    public Integer readInteger() {
        return productMenu.readInteger();
    }

    public String readString() {
        return productMenu.readString();
    }

    public abstract String getCommandName();
}
