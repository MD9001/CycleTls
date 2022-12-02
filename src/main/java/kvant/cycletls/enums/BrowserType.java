package kvant.cycletls.enums;

public enum BrowserType {
    CHROME("chrome");

    private final String rawName;

    BrowserType(String rawName) {
        this.rawName = rawName;
    }

    public String getRawName() {
        return rawName;
    }
}
