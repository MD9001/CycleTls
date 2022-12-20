package kvant.cycletls.connection;

import kvant.cycletls.json.JacksonApi;
import kvant.cycletls.model.TlsRequest;
import kvant.cycletls.model.TlsResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public final class TlsChannel implements Connection {
    private Socket connection;

    private InputStream in;
    private OutputStream out;

    @Override
    public void connect(String host, int port) throws IOException {
        connection = new Socket();
        connection.connect(new InetSocketAddress(host, port));

        in = connection.getInputStream();
        out = connection.getOutputStream();
    }

    public TlsResponse send(TlsRequest request) throws IOException {
        if (connection == null) {
            return null;
        }

        out.write(request.asPayload());
        out.flush();

        return JacksonApi.readFromBytes(in.readAllBytes(), TlsResponse.class);
    }

    @Override
    public void close() throws IOException {
        if (connection != null) {
            connection.close();
        }
    }
}
