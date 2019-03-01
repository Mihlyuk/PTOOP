package object_serialization.plugins.commands;

import object_serialization.commands.AbstractCommand;
import object_serialization.commands.CommandItem;
import object_serialization.view.ProductMenu;
import object_serialization.plugins.RaltsevichPlugin;

/**
 * Toggle adding zip wrapping
 */
@CommandItem
public class RaltsevichCommand extends AbstractCommand {

    public RaltsevichCommand(ProductMenu productMenu) {
        super(productMenu);
    }

    @Override
    public String getCommandName() {
        return "Toggle zip wrapper";
    }

    @Override
    public void run() {
        RaltsevichPlugin.ENABLED = !RaltsevichPlugin.ENABLED;
        System.out.printf("Zipping enabled: %b", RaltsevichPlugin.ENABLED);
    }
}
