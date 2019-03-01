package object_serialization.products;

import object_serialization.view.ProductMenu;
import object_serialization.commands.AbstractCommand;
import object_serialization.commands.CommandItem;
import object_serialization.exception.PackageNotFoundException;
import object_serialization.util.ClassSearcher;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Product plugins implementation
 */
public class ProductPluginImpl implements ProductPlugin {
    private final String productPackage = "object_serialization.products";
    private final String pluginProductPackage = "object_serialization.plugins.products";
    private final String commandPackage = "object_serialization.commands";
    private final String pluginCommandPackage = "object_serialization.plugins.commands";
    private ProductPluginManager productPluginManager;

    public void setProductPluginManager(ProductPluginManager productPluginManager) {
        this.productPluginManager = productPluginManager;
    }

    @Override
    public List<AbstractCommand> getCommands() {
        try {
            List<AbstractCommand> commandList = new ArrayList<>();

            List<Class> commandClassList1 = ClassSearcher.getClasses(commandPackage, CommandItem.class);
            List<Class> commandClassList2 = ClassSearcher.getClasses(pluginCommandPackage, CommandItem.class);

            for (Class commandClass : commandClassList1) {
                AbstractCommand command = (AbstractCommand) commandClass.getDeclaredConstructor(ProductMenu.class).newInstance(productPluginManager.getProductMenu());
                commandList.add(command);
            }

            for (Class commandClass : commandClassList2) {
                AbstractCommand command = (AbstractCommand) commandClass.getDeclaredConstructor(ProductMenu.class).newInstance(productPluginManager.getProductMenu());
                commandList.add(command);
            }

            return commandList;
        } catch (ClassNotFoundException | IOException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new PackageNotFoundException("Package " + commandPackage + " was not found", e);
        }
    }

    @Override
    public List<Class> getProducts() {
        try {
            List<Class> productClasses = new ArrayList<>();
            productClasses.addAll(ClassSearcher.getClasses(productPackage, ProductItem.class));
            productClasses.addAll(ClassSearcher.getClasses(pluginProductPackage, ProductItem.class));
            return productClasses;
        } catch (ClassNotFoundException | IOException e) {
            throw new PackageNotFoundException("Package " + productPackage + " was not found", e);
        }
    }
}
