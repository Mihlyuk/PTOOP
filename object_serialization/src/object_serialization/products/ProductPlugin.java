package object_serialization.products;

import object_serialization.commands.AbstractCommand;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Product plugins
 */
public interface ProductPlugin {
    /**
     * Gets commands from plugins
     * @return commands from plugins
     */
    List<AbstractCommand> getCommands();

    /**
     * Gets products from plugins
     * @return products from plugins
     */
    List<Class> getProducts();

    default OutputStream serializationWrap(OutputStream outputStream) {
        return outputStream;
    }

    default InputStream deserializationWrap(InputStream inputStream) {
        return inputStream;
    }
}
