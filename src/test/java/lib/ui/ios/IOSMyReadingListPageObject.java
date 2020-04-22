package lib.ui.ios;

import lib.ui.MyReadingListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyReadingListPageObject extends MyReadingListPageObject {

    static {
        SEARCH_PAGE_BUTTON = "id:Explore";
        ARTICLE = "xpath://XCUIElementTypeLink";
        PATH_TO_ARTICLE_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
        PATH_TO_READING_LIST_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{SUBSTRING}']";
    }

    public IOSMyReadingListPageObject(RemoteWebDriver driver) {
        super(driver);
    }

}
