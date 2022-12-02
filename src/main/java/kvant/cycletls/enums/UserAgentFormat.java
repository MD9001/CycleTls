package kvant.cycletls.enums;

public enum UserAgentFormat {
    CHROME("Mozilla/5.0 (%s) %s (%s) %s");

    private final String format;

    UserAgentFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
