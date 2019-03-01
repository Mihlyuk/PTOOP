package object_serialization.commands;

import object_serialization.products.ProductPlugin;
import object_serialization.view.ProductMenu;
import object_serialization.products.Product;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import de.undercouch.bson4jackson.BsonFactory;
import de.undercouch.bson4jackson.BsonGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Command to deserialize product list
 */
@CommandItem
public class ProductDeserializationCommand extends AbstractCommand {

    public ProductDeserializationCommand(ProductMenu productMenu) {
        super(productMenu);
    }

    @Override
    public String getCommandName() {
        return "Deserialize products";
    }

    @Override
    public void run() {
        String deserializeFileName = "/Users/konstantin/IdeaProjects/PTOOP/object_serialization/resources/products.bson";

        try {
            InputStream fis = new FileInputStream(new File(deserializeFileName));
            fis = wrapStream(fis);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BsonFactory bf = new BsonFactory();
            bf.enable(BsonGenerator.Feature.ENABLE_STREAMING);
            JsonParser jp = bf.createJsonParser(bis);
            deserializeProducts(jp);
            jp.close();
        } catch (IOException e) {
            System.err.println(deserializeFileName + e.getMessage());
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            System.err.println("File " + deserializeFileName + " has invalid format.");
        }
    }

    private InputStream wrapStream(InputStream is) {
        List<ProductPlugin> productPlugins = productPluginManager.getProductPlugins();

        for (ProductPlugin productPlugin : productPlugins) {
            is = productPlugin.deserializationWrap(is);
        }

        return is;
    }
    /**
     * Deserialize list of products
     *
     * @param jp JsonParses object
     * @throws IOException            Invalid bson file format
     * @throws ClassNotFoundException Invalid bson file format
     * @throws IllegalAccessException Invalid bson file format
     * @throws InstantiationException Invalid bson file format
     */
    private void deserializeProducts(JsonParser jp) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<Product> productList = new ArrayList<>();
        jp.nextToken();
        String productsFieldName = jp.nextFieldName();

        if ("object_serialization/products".equals(productsFieldName)) {
            while (jp.nextToken() != JsonToken.END_ARRAY) {
                if (jp.getCurrentToken() == JsonToken.START_OBJECT) {
                    Product newProduct = parseProduct(jp);
                    productList.add(newProduct);
                }
            }
            productMenu.setProductList(productList);
        } else {
            throw new IOException("Invalid file format.");
        }
    }

    /**
     * Parse product from BSON
     *
     * @param jp JsonParses object
     * @return new Product object
     * @throws IOException            Invalid bson file format
     * @throws ClassNotFoundException Invalid bson file format
     * @throws IllegalAccessException Invalid bson file format
     * @throws InstantiationException Invalid bson file format
     */
    private Product parseProduct(JsonParser jp) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String productTypeFieldName = jp.nextFieldName();

        if ("productType".equals(productTypeFieldName)) {
            String productType = jp.nextTextValue();
            Product newProduct = (Product) Class.forName(productType, true, productPluginManager.getUrlClassLoader()).newInstance();
            jp.nextFieldName();
            int cost = jp.nextIntValue(0);
            jp.nextFieldName();
            String name = jp.nextTextValue();
            jp.nextFieldName();
            int weight = jp.nextIntValue(0);
            newProduct.setCost(cost);
            newProduct.setName(name);
            newProduct.setWeight(weight);
            return newProduct;
        } else {
            throw new IOException("Invalid file format.");
        }
    }
}
