package kvant.cycletls.con;

import java.io.Closeable;
import java.io.IOException;

public interface Connection extends Closeable {
    void connect(String host, int port) throws IOException;
}
