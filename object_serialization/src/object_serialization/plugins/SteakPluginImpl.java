package object_serialization.plugin;

import object_serialization.commands.AbstractCommand;
import object_serialization.commands.GetTaxCommand;
import object_serialization.products.ProductPlugin;
import object_serialization.products.meat.Steak;

import java.util.Arrays;
import java.util.List;

/**
 * Steak plugin impl
 */
public class SteakPluginImpl implements ProductPlugin {

    @Override
    public List<AbstractCommand> getCommands() {
        return Arrays.asList(new GetTaxCommand(null));
    }

    @Override
    public List<Class> getProducts() {
        return Arrays.asList(Steak.class);
    }
}
