package kvant.cycletls.model.browser;

import kvant.cycletls.enums.BrowserType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public class UserAgent {
    private final BrowserType browser;
    private final SysInformation system;
    private final Platform platform;
    private final List<Extension> extensions;
    private final String stringFormat;

    private String platformDetails = "KHTML, like Gecko";

    public void setPlatformDetails(String platformDetails) {
        this.platformDetails = platformDetails;
    }

    @Override
    public String toString() {
        return String.format(stringFormat, system, platform, platformDetails, extensions
                .stream().map(Extension::toString).collect(Collectors.joining(" ")));
    }
}
