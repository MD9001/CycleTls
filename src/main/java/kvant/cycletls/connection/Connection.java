package kvant.cycletls.connection;

import java.io.Closeable;
import java.io.IOException;

public interface Connection extends Closeable {
    void connect(String host, int port) throws IOException;
}
