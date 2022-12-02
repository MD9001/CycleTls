package kvant.cycletls.enums;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static kvant.cycletls.constant.SysPlatformDetails.*;

public enum SystemPlatform {
    WIN_10("Windows NT 10.0") {
        @Override
        public List<String> randomDetails() {
            return Windows.random().getDetails();
        }
    },

    MACINTOSH("Macintosh") {
        @Override
        public List<String> randomDetails() {
            return Macintosh.random().getDetails();
        }
    },

    LINUX("x11") {
        @Override
        public List<String> randomDetails() {
            return Linux.random().getDetails();
        }
    };

    private final String rawName;

    SystemPlatform(String rawName) {
        this.rawName = rawName;
    }

    public String getRawName() {
        return rawName;
    }

    public abstract List<String> randomDetails();

    public static SystemPlatform random() {
        var values = values();
        var index = ThreadLocalRandom.current().nextInt(values.length);

        return values[index];
    }
}
