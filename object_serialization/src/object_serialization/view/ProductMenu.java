package object_serialization.view;

import object_serialization.commands.AbstractCommand;
import javafx.util.Pair;
import object_serialization.products.ProductPluginManager;
import object_serialization.products.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements the menu display for each command.
 */
public class ProductMenu {

    private List<Pair<String, Runnable>> menuCommands;
    private List<Product> productList;
    private BufferedReader bufferedReader;
    private ProductPluginManager productPluginManager;

    public ProductMenu(ProductPluginManager productPluginManager) {
        productList = new ArrayList<>();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.productPluginManager = productPluginManager;
        menuCommands = new ArrayList<>();
        productPluginManager.setProductMenu(this);
        initMenuCommands();
    }

    /**
     * Set available commands into menu.
     */
    private void initMenuCommands() {
        List<AbstractCommand> commands = productPluginManager.getCommands();
        int index = 0;
        for (AbstractCommand productCommand : commands) {
            menuCommands.add(new Pair<>(++index + ": " + productCommand.getCommandName(), productCommand));
        }
    }

    /**
     * Runs menu command
     */
    public void runMenu() {
        while (true) {
            System.out.println("Choose option:");
            menuCommands.forEach(p -> System.out.println(p.getKey()));

            Integer commandIndex = readInteger();
            if (isValidCommandIndex(commandIndex)) {
                Runnable action = menuCommands.get(commandIndex - 1).getValue();
                action.run();
            } else {
                System.out.println("Please, input number: 0-" + (menuCommands.size()));
            }
        }
    }

    private boolean isValidCommandIndex(Integer commandIndex) {
        return commandIndex != null && commandIndex.compareTo(menuCommands.size() + 1) < 0;
    }

    public Integer readInteger() {
        Integer commandIndex = null;

        try {
            String userInput = bufferedReader.readLine();
            commandIndex = Integer.parseInt(userInput);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return commandIndex;
    }

    public String readString() {
        String line = null;

        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList.clear();
        this.productList.addAll(productList);
    }

    public List<Class> getProductNameList() {
        return productPluginManager.getProducts();
    }

    public ProductPluginManager getProductPluginManager() {
        return productPluginManager;
    }
}
