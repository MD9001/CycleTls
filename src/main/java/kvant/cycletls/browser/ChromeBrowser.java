package kvant.cycletls.browser;

import kvant.cycletls.enums.*;
import kvant.cycletls.model.browser.*;

public class ChromeBrowser implements Browser {
    private UserAgent userAgent = generateUserAgent();

    public ChromeBrowser(UserAgent userAgent) {
        this.userAgent = userAgent;
    }

    public ChromeBrowser() {}

    @Override
    public UserAgent generateUserAgent() {
        var sysPlatform = SystemPlatform.random();

        var platformDetails = sysPlatform.randomDetails();

        return new UserAgent(
                BrowserType.CHROME,
                new SysInformation(sysPlatform, platformDetails),
                new Platform(PlatformType.WEBKIT, Extension.SAFARI_EXTENSION.getVersion()),
                ChromeExtensions.random().getValue(),
                UserAgentFormat.CHROME.getFormat()
        );
    }

    @Override
    public String getFingerPrint(UserAgent userAgent) {
        switch (userAgent.getExtensions().get(0).getVersion()) {
            case Version.VERSION_96:
                return FingerPrint.JA3_96;
            case Version.VERSION_99:
                return FingerPrint.JA3_99;
            case Version.VERSION_103:
                return FingerPrint.JA3_103;
            case Version.VERSION_104:
                return FingerPrint.JA3_104;
            case Version.VERSION_107:
                return FingerPrint.JA3_107;
            default:
                throw new UnsupportedOperationException("Chrome version not supported");
        }
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }

    public static final class Version {
        public static final String VERSION_96 = "96.0.4664.110";
        public static final String VERSION_99 = "99.0.4844.84";
        public static final String VERSION_103 = "103.0.0.0";
        public static final String VERSION_104 = "104.0.0.0";
        public static final String VERSION_107 = "107.0.0.0";
    }

    public static final class FingerPrint {
        public static final String JA3_96 = "772,4867-4865-4866-52393-52392-49195-49199-49196-49200-49171-49172-156-157-47-53,0-23-65281-10-11-35-16-5-13-18-51-45-43-27-17513,2570-29-23-24,0";
        public static final String JA3_99 = "772,4867-4865-4866-52393-52392-49195-49199-49196-49200-49171-49172-156-157-47-53,0-23-65281-10-11-35-16-5-13-18-51-45-43-27-17513,29-23-24,0";
        public static final String JA3_103 = "772,4867-4865-4866-52393-52392-49195-49199-49196-49200-49171-49172-156-157-47-53,0-23-65281-10-11-35-16-5-13-18-51-45-43-27-17513-41,29-23-24,0";
        public static final String JA3_104 = "772,4867-4865-4866-52393-52392-49195-49199-49196-49200-49171-49172-156-157-47-53,0-23-65281-10-11-35-16-5-13-18-51-45-43-27-17513-41,29-23-24,0";
        public static final String JA3_107 = "772,4865-4866-4867-49195-49199-49196-49200-52393-52392-49171-49172-156-157-47-53,0-23-65281-10-11-35-16-5-13-18-51-45-43-27-17513-41,2570-29-23-24,0";
    }
}
