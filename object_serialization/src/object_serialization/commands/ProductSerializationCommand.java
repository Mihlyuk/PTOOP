package object_serialization.commands;

import object_serialization.view.ProductMenu;
import object_serialization.products.ProductPlugin;
import object_serialization.products.Product;
import com.fasterxml.jackson.core.JsonGenerator;
import de.undercouch.bson4jackson.BsonFactory;
import de.undercouch.bson4jackson.BsonGenerator;

import java.io.*;
import java.util.List;

/**
 * Command to serialize product list
 */
@CommandItem
public class ProductSerializationCommand extends AbstractCommand {

    public ProductSerializationCommand(ProductMenu productMenu) {
        super(productMenu);
    }

    @Override
    public String getCommandName() {
        return "Serialize products";
    }

    @Override
    public void run() {
        String serializeFilePath = "object_serialization/resources/products.bson";

        try {
            File serializeFile = new File(serializeFilePath);
            OutputStream os = new FileOutputStream(serializeFile);
            os = wrapStream(os);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            BsonFactory bf = new BsonFactory();
            bf.enable(BsonGenerator.Feature.ENABLE_STREAMING);
            JsonGenerator jg = bf.createGenerator(bos);
            serializeProducts(jg);
            jg.close();
        } catch (IOException e) {
            System.err.println(serializeFilePath + " was not found.");
        }
    }

    private OutputStream wrapStream(OutputStream os) {
        List<ProductPlugin> productPlugins = productPluginManager.getProductPlugins();

        for (ProductPlugin productPlugin : productPlugins) {
            os = productPlugin.serializationWrap(os);
        }

        return os;
    }

    /**
     * Serializes products
     *
     * @param jg JsonGenerator object
     * @throws IOException writing error
     */
    private void serializeProducts(JsonGenerator jg) throws IOException {
        jg.writeStartObject();
        jg.writeArrayFieldStart("object_serialization/products");

        for (Product p : products) {
            jg.writeStartObject();
            jg.writeFieldName("productType");
            jg.writeString(p.getClass().getName());
            jg.writeFieldName("cost");
            jg.writeNumber(p.getCost());
            jg.writeFieldName("name");
            jg.writeString(p.getName());
            jg.writeFieldName("weight");
            jg.writeNumber(p.getWeight());
            jg.writeEndObject();
        }

        jg.writeEndArray();
        jg.writeEndObject();
    }
}
