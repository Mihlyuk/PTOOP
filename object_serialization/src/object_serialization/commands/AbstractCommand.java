package object_serialization.commands;

import object_serialization.view.ProductMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Base class for command
 */
public abstract class AbstractCommand implements Runnable {
    protected ProductMenu productMenu;
    protected BufferedReader bufferedReader;

    protected AbstractCommand(ProductMenu productMenu) {
        this.productMenu = productMenu;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public abstract String getCommandName();
}
