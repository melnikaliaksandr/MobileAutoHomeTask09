package lib.ui.mobileWeb;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        WATCHLIST = "css:a[data-event-name='menu.unStar']";
        MENU_BUTTON = "css:label#mw-mf-main-menu-button";
        BOOKMARK_MENU_BUTTON = "css:a[id='ca-watch']";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

}
