package object_serialization.plugins;

import object_serialization.commands.AbstractCommand;
import me.swarmer.ptoop.zipplugin.plugins.ZipPlugin;
import object_serialization.plugins.commands.RaltsevichCommand;
import object_serialization.products.ProductPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

/**
 * Zip wrapper plugin impl
 */
public class RaltsevichPlugin implements ProductPlugin {
    private ZipPlugin zipPlugin = new ZipPlugin();

    @Override
    public List<AbstractCommand> getCommands() {
        RaltsevichCommand.setZipPlugin(zipPlugin);
        return Collections.emptyList();
    }

    @Override
    public List<Class> getProducts() {
        return Collections.emptyList();
    }

    @Override
    public OutputStream serializationWrap(OutputStream outputStream) {
        try {
            return zipPlugin.wrapOutputStream(outputStream);
        } catch (IOException e) {
            throw new RuntimeException("Cannot wrap output stream. " + e.getMessage());
        }
    }

    @Override
    public InputStream deserializationWrap(InputStream inputStream) {
        try {
            return zipPlugin.wrapInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Cannot wrap output stream. " + e.getMessage());
        }
    }
}
