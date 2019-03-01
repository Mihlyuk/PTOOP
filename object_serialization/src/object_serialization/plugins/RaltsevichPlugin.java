package object_serialization.plugins;

import object_serialization.commands.AbstractCommand;
import object_serialization.plugins.commands.RaltsevichCommand;
import object_serialization.products.ProductPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * A plugins implementing compression functionality for serialization
 */
public class RaltsevichPlugin implements ProductPlugin {
    public static boolean ENABLED = false;

    @Override
    public List<AbstractCommand> getCommands() {
        return Collections.emptyList();
    }

    @Override
    public List<Class> getProducts() {
        return Collections.emptyList();
    }

    @Override
    public OutputStream serializationWrap(OutputStream outputStream) {
        try {
            return wrapOutputStream(outputStream);
        } catch (IOException e) {
            throw new RuntimeException("Cannot wrap output stream. " + e.getMessage());
        }
    }

    @Override
    public InputStream deserializationWrap(InputStream inputStream) {
        try {
            return wrapInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Cannot wrap output stream. " + e.getMessage());
        }
    }

    /**
     * Wrap passed stream in a gzip stream
     */
    private OutputStream wrapOutputStream(OutputStream wrappedStream) throws IOException {
        if (!ENABLED) return wrappedStream;
        return new GZIPOutputStream(wrappedStream);
    }

    /**
     * Wrap passed stream in a gzip stream
     */
    private InputStream wrapInputStream(InputStream wrappedStream) throws IOException {
        if (!ENABLED) return wrappedStream;
        return new GZIPInputStream(wrappedStream);
    }
}
