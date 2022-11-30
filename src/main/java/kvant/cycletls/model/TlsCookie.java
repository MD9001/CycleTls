package kvant.cycletls.model;

import lombok.*;

@Getter
public final class TlsCookie {
    private final String name, value;

    private String path, domain, sameSite;
    private long expires, maxAge;
    private boolean secure, httpOnly;

    public TlsCookie(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static TlsCookieBuilder newBuilder(String name, String value) {
        return new TlsCookieBuilder(name, value);
    }

    public static class TlsCookieBuilder {
        private final TlsCookie cookie;

        public TlsCookieBuilder(String name, String value) {
            this.cookie = new TlsCookie(name, value);
        }

        public TlsCookieBuilder path(String path) {
            cookie.path = path;
            return this;
        }

        public TlsCookieBuilder domain(String domain) {
            cookie.domain = domain;
            return this;
        }

        public TlsCookieBuilder sameSite(String sameSite) {
            cookie.sameSite = sameSite;
            return this;
        }

        public TlsCookieBuilder expires(long expires) {
            cookie.expires = expires;
            return this;
        }

        public TlsCookieBuilder maxAge(long maxAge) {
            cookie.maxAge = maxAge;
            return this;
        }

        public TlsCookieBuilder secure(boolean secure) {
            cookie.secure = secure;
            return this;
        }

        public TlsCookieBuilder httpOnly(boolean httpOnly) {
            cookie.httpOnly = httpOnly;
            return this;
        }

        public TlsCookie build() {
            return cookie;
        }
    }
}
