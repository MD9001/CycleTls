package kvant.cycletls.enums;

import kvant.cycletls.browser.ChromeBrowser;
import kvant.cycletls.model.browser.Extension;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static kvant.cycletls.model.browser.Extension.SAFARI_EXTENSION;

public enum ChromeExtensions {
    CHROME_96(List.of(new Extension(ExtensionType.CHROME, ChromeBrowser.Version.VERSION_96), SAFARI_EXTENSION)),
    CHROME_99(List.of(new Extension(ExtensionType.CHROME, ChromeBrowser.Version.VERSION_99), SAFARI_EXTENSION)),
    CHROME_103(List.of(new Extension(ExtensionType.CHROME, ChromeBrowser.Version.VERSION_103), SAFARI_EXTENSION)),
    CHROME_104(List.of(new Extension(ExtensionType.CHROME, ChromeBrowser.Version.VERSION_104), SAFARI_EXTENSION)),
    CHROME_107(List.of(new Extension(ExtensionType.CHROME, ChromeBrowser.Version.VERSION_107), SAFARI_EXTENSION));

    private final List<Extension> value;

    ChromeExtensions(List<Extension> value) {
        this.value = value;
    }

    public List<Extension> getValue() {
        return value;
    }

    public static ChromeExtensions random() {
        var values = values();
        var index = ThreadLocalRandom.current().nextInt(values.length);

        return values[index];
    }
}