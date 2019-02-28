package object_serialization;

import object_serialization.plugin.ProductPluginManager;
import object_serialization.view.ProductMenu;

import java.util.Arrays;

/**
 * Product menu runner
 */
public class MainObjectSerialization {
    public static void main(String[] args) {
        ProductPluginManager productPluginManager = new ProductPluginManager(Arrays.asList(args));
        ProductMenu productMenu = new ProductMenu(productPluginManager);
        productMenu.runMenu();
    }
}
