package kvant.cycletls.enums;

public enum ExtensionType {
    CHROME("Chrome"),
    SAFARI("Safari");

    private final String rawName;

    ExtensionType(String rawName) {
        this.rawName = rawName;
    }

    public String getRawName() {
        return rawName;
    }
}
