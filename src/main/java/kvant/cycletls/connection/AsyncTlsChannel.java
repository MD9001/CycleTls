package kvant.cycletls.connection;

import kvant.cycletls.json.JacksonApi;
import kvant.cycletls.model.TlsRequest;
import kvant.cycletls.model.TlsResponse;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class AsyncTlsChannel implements Connection {
    @Setter
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    private AsynchronousSocketChannel connection;

    public void connect(String host, int port) throws IOException {
        if (connection != null) return;

        connection = AsynchronousSocketChannel.open();
        connection.connect(new InetSocketAddress(host, port));
    }

    public CompletableFuture<TlsResponse> sendAsync(TlsRequest request) {
        if (connection == null) {
            return null;
        }

        return CompletableFuture.supplyAsync(() -> {
            try (OutputStream out = Channels.newOutputStream(connection);
                 InputStream in = Channels.newInputStream(connection)) {

                out.write(request.asPayload());
                out.flush();

                return JacksonApi.readFromBytes(in.readAllBytes(), TlsResponse.class);
            } catch (IOException e) {
                return null;
            }
        }, executor);
    }

    @Override
    public void close() throws IOException {
        if (connection != null) {
            connection.close();
        }
    }
}
