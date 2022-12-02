package kvant.cycletls.model.browser;

import kvant.cycletls.enums.ExtensionType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class Extension {
    private final ExtensionType extensionType;
    private final String version;

    @Override
    public String toString() {
        return extensionType.getRawName() + "/" + version;
    }

    public static final Extension SAFARI_EXTENSION = new Extension(ExtensionType.SAFARI, "537.36");
}
