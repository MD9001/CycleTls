package kvant.cycletls.model.browser;

import kvant.cycletls.enums.SystemPlatform;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class SysInformation {
    private final SystemPlatform system;
    private final List<String> details;

    @Override
    public String toString() {
        var modifiedDetails = new ArrayList<>(details);
        modifiedDetails.add(0, system.getRawName());

        return String.join("; ", modifiedDetails);
    }
}
