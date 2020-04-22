package lib.ui.mobileWeb;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        LIST_OF_ELEMENTS = "css:ul.page-list>li.page-summary";
        SEARCH_CLOSE_BUTTON = "css:button.clear";
        SEARCH_RESULT_DESCRIPTION_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
//        CLEAR_SEARCH_LINE_BUTTON = "id:clear mini";
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }


}
