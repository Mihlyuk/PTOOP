package object_serialization.plugins.commands;

import object_serialization.commands.AbstractCommand;
import object_serialization.commands.CommandItem;
import object_serialization.view.ProductMenu;
import object_serialization.plugins.RaltsevichPlugin;
import me.swarmer.ptoop.zipplugin.plugins.ZipPlugin;

/**
 * Toggle adding zip wrapping
 */
@CommandItem
public class RaltsevichCommand extends AbstractCommand {
    private static ZipPlugin zipPlugin;

    public static void setZipPlugin(ZipPlugin newzipPlugin) {
        zipPlugin = newzipPlugin;
    }

    public RaltsevichCommand(ProductMenu productMenu) {
        super(productMenu);
    }

    @Override
    public String getCommandName() {
        return "Toggle zip wrapper";
    }

    @Override
    public void run() {
        zipPlugin.toggleZipping();
    }
}
