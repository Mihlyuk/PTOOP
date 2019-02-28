package object_serialization.plugin;

import object_serialization.view.ProductMenu;
import object_serialization.commands.AbstractCommand;
import object_serialization.commands.CommandItem;
import object_serialization.exception.PackageNotFoundException;
import object_serialization.products.ProductItem;
import object_serialization.util.ClassSearcher;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Product plugin implementation
 */
public class ProductPluginImpl implements ProductPlugin {
    private final String productPackage = "object_serialization.products";
    private final String commandPackage = "object_serialization.commands";
    private ProductPluginManager productPluginManager;

    public void setProductPluginManager(ProductPluginManager productPluginManager) {
        this.productPluginManager = productPluginManager;
    }

    @Override
    public List<AbstractCommand> getCommands() {
        try {
            List<AbstractCommand> commandList = new ArrayList<>();
            List<Class> commandClassList = ClassSearcher.getClasses(commandPackage, CommandItem.class);
            for (Class commandClass : commandClassList) {
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
            return ClassSearcher.getClasses(productPackage, ProductItem.class);
        } catch (ClassNotFoundException | IOException e) {
            throw new PackageNotFoundException("Package " + productPackage + " was not found", e);
        }
    }
}
