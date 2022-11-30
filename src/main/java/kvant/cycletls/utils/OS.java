package kvant.cycletls.utils;

public enum OS {
    MAC,
    WINDOWS,
    LINUX;

    public static OS current() {
        var name = System.getProperty("os.name").toLowerCase();

        if (name.contains("win"))
            return WINDOWS;
        else if (name.contains("mac"))
            return MAC;
        else
            return LINUX;
    }
}
