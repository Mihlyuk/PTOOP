package object_serialization.commands;

import object_serialization.view.ProductMenu;

@CommandItem
public class ExitCommand extends AbstractCommand {

    public ExitCommand(ProductMenu productMenu) {
        super(productMenu);
    }

    @Override
    public String getCommandName() {
        return "Exit";
    }

    @Override
    public void run() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
