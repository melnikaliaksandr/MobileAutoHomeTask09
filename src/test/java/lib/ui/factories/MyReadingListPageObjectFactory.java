package lib.ui.factories;

import lib.Platform;
import lib.ui.MyReadingListPageObject;
import lib.ui.android.AndroidMyReadingListPageObject;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.ios.IOSMyReadingListPageObject;
import lib.ui.ios.IOSSearchPageObject;
import lib.ui.mobileWeb.MWMyReadingListPageObject;
import lib.ui.mobileWeb.MWSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyReadingListPageObjectFactory {

    public static MyReadingListPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyReadingListPageObject(driver);
        } else if (Platform.getInstance().isIOS()){
            return new IOSMyReadingListPageObject(driver);
        } else {
            return new MWMyReadingListPageObject(driver);
        }
    }

}
