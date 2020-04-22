package lib.ui.android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SKIP_ONBOARDING_BUTTON = "id:org.wikipedia:id/fragment_onboarding_skip_button";
        SEARCH_INIT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']";
        SEARCH_INPUT = "id:org.wikipedia:id/search_src_text";
        LIST_OF_ELEMENTS = "id:org.wikipedia:id/page_list_item_title";
        SEARCH_CLOSE_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_TITLE_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']//*[contains(@text='{SUBSTRING}')]";
        SEARCH_RESULT_DESCRIPTION_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description']//*[contains(@text='{SUBSTRING}')]";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }


}
