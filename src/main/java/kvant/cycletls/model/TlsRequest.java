package kvant.cycletls.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import kvant.cycletls.json.JacksonApi;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Getter
@RequiredArgsConstructor
public final class TlsRequest {
    private final String url, method, ja3;

    @JsonIgnore
    private String requestId = UUID.randomUUID().toString();
    private String body, userAgent, proxy;

    private Map<String, String> headers = new HashMap<>();
    private List<String> headerOrder;

    private List<TlsCookie> cookies = new ArrayList<>();

    private int timeOut = 6;
    private boolean redirect = false;

    public byte[] asPayload() {
        var options = JacksonApi.convertToValue(this, JsonNode.class);
        var objectNode = JacksonApi.newObjectNode();

        objectNode.put("requestId", requestId);
        objectNode.putPOJO("options", options);

        return JacksonApi.writeAsBytes(objectNode);
    }

    public static TlsRequestBuilder newBuilder(String url, String method, String ja3) {
        return new TlsRequestBuilder(url, method, ja3);
    }

    public static class TlsRequestBuilder {
        private final TlsRequest request;

        public TlsRequestBuilder(String url, String method, String ja3) {
            this.request = new TlsRequest(url, method, ja3);
        }

        public TlsRequestBuilder requestId(String requestId) {
            request.requestId = requestId;
            return this;
        }

        public TlsRequestBuilder body(String body) {
            request.body = body;
            return this;
        }

        public TlsRequestBuilder userAgent(String userAgent) {
            request.userAgent = userAgent;
            return this;
        }

        public TlsRequestBuilder proxy(String proxyString) {
            request.proxy = proxyString;
            return this;
        }

        public TlsRequestBuilder headers(Map<String, String> headers) {
            request.headers = headers;
            return this;
        }

        public TlsRequestBuilder headerOrder(List<String> headerOrder) {
            request.headerOrder = headerOrder;
            return this;
        }

        public TlsRequestBuilder cookies(List<TlsCookie> cookies) {
            request.cookies = cookies;
            return this;
        }

        public TlsRequestBuilder timeOut(int timeOut) {
            request.timeOut = timeOut;
            return this;
        }

        public TlsRequestBuilder redirect(boolean redirect) {
            request.redirect = redirect;
            return this;
        }

        public TlsRequest build() {
            return request;
        }
    }
}
