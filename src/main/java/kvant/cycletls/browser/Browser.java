package kvant.cycletls.browser;

import kvant.cycletls.model.browser.UserAgent;

public interface Browser {
    UserAgent generateUserAgent();

    String getFingerPrint(UserAgent userAgent);
}