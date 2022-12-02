package kvant.cycletls.model.browser;

import kvant.cycletls.enums.PlatformType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Platform {
    private final PlatformType platform;
    private final String version;

    @Override
    public String toString() {
        return platform.getRawName() + "/" + version;
    }
}
