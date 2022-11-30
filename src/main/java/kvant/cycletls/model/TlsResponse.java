package kvant.cycletls.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public final class TlsResponse {
    private final String requestId;

    private final int statusCode;
    private final Map<String, String> headers;
    private final String body;
}