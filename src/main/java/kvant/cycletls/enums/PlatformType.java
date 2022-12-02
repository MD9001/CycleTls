package kvant.cycletls.enums;

public enum PlatformType {
    WEBKIT("AppleWebKit"),
    GECKO("GECKO");

    private final String rawName;

    PlatformType(String rawName) {
        this.rawName = rawName;
    }

    public String getRawName() {
        return rawName;
    }
}
