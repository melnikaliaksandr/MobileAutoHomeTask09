package lib.ui.factories;

import lib.Platform;
import lib.ui.MyReadingListPageObject;
import lib.ui.android.AndroidMyReadingListPageObject;
import lib.ui.ios.IOSMyReadingListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyReadingListPageObjectFactory {

    public static MyReadingListPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyReadingListPageObject(driver);
        } else {
            return new IOSMyReadingListPageObject(driver);
        }
    }

}
