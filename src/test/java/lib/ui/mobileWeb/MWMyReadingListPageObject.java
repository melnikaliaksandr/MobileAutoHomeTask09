package lib.ui.mobileWeb;

import lib.ui.MyReadingListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyReadingListPageObject extends MyReadingListPageObject {

    static {
        ARTICLE = "css:li[class='page-summary with-watchstar']";
        PATH_TO_ARTICLE_TPL = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{SUBSTRING}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{SUBSTRING}')]/../../a[contains(@class,'watched')]";
    }

    public MWMyReadingListPageObject(RemoteWebDriver driver) {
        super(driver);
    }

}
