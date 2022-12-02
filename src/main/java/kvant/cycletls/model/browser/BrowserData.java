package kvant.cycletls.model.browser;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BrowserData {
    private final UserAgent userAgent;
    private final String ja3;
}
