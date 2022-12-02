package kvant.cycletls.constant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class SysPlatformDetails {
    private SysPlatformDetails() {}

    public enum Windows {
        WOW_64(List.of("WOW64")),
        WIN_64(List.of("Win64", "x64"));

        private final List<String> details;

        Windows(List<String> details) {
            this.details = details;
        }

        public List<String> getDetails() {
            return details;
        }

        public static Windows random() {
            var values = values();
            var nextIndex = ThreadLocalRandom.current().nextInt(values.length);

            return values[nextIndex];
        }
    }

    public enum Macintosh {
        INTEL_MAC_OS_13(List.of("Intel Mac OS X 13_0_1"));

        private final List<String> details;

        Macintosh(List<String> details) {
            this.details = details;
        }

        public List<String> getDetails() {
            return details;
        }

        public static Macintosh random() {
            var values = values();
            var nextIndex = ThreadLocalRandom.current().nextInt(values.length);

            return values[nextIndex];
        }
    }

    public enum Linux {
        X86_64(List.of("Linux x86_64"));

        private final List<String> details;

        Linux(List<String> details) {
            this.details = details;
        }

        public List<String> getDetails() {
            return details;
        }

        public static Linux random() {
            var values = values();
            var nextIndex = ThreadLocalRandom.current().nextInt(values.length);

            return values[nextIndex];
        }
    }
}