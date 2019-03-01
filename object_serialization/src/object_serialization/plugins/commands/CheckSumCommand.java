package object_serialization.plugins.commands;

import object_serialization.commands.AbstractCommand;
import object_serialization.commands.CommandItem;
import object_serialization.plugins.ChecksumPlugin;
import object_serialization.view.ProductMenu;

/**
 * Toggle adding checksum to serialization file
 */
@CommandItem
public class CheckSumCommand extends AbstractCommand {

    public CheckSumCommand(ProductMenu productMenu) {
        super(productMenu);
    }

    @Override
    public String getCommandName() {
        return "Checksum";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Please, input 1 (turn on) or 0 (turn off): ");

            Integer productIndex = readInteger();
            if (productIndex == 0 || productIndex == 1) {
                ChecksumPlugin.VALIDATION = productIndex.equals(1);
                break;
            }
        }
    }
}
