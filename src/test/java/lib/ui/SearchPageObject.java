package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

abstract public class SearchPageObject extends MainPageObject {

    protected static String
            LOGIN,
            WATCHLIST,
            MENU_BUTTON,
            SKIP_ONBOARDING_BUTTON,
            SEARCH_INIT_ELEMENT,
            CLEAR_SEARCH_LINE_BUTTON,
            SEARCH_INPUT,
            LIST_OF_ELEMENTS,
            SEARCH_CLOSE_BUTTON,
            SEARCH_RESULT_TITLE_BY_SUBSTRING_TPL,
            SEARCH_RESULT_DESCRIPTION_BY_SUBSTRING_TPL,
            SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void openAuthorizationPage() {
        this.waitForElementAndClick(MENU_BUTTON, "Cannot find menu button", 10);
        this.tryClickElementWithFewAttempts(LOGIN, "Cannot find login button", 10);
    }

    public boolean checkTitleInArticle(String title, int countOfArticleForChecking, List<WebElement> listOfArticles) {
        int count = 0;
        for (int i = 0; i < countOfArticleForChecking; i++) {
            if (listOfArticles.get(i).getText().contains(title))
            count++;
        }
        if (count == countOfArticleForChecking) {
            return true;
        } else {
            return false;
        }
    }

    public void openArticleWithDescription(String description) {
        String descriptionXpath = replaceTemplate(SEARCH_RESULT_DESCRIPTION_BY_SUBSTRING_TPL, description);
        this.waitForElementAndClick(
                descriptionXpath,
                "Cannot find search result with title: " + descriptionXpath,
                15);
    }

    public void openArticleWithTitle(String title) {
        String titleXpath = replaceTemplate(SEARCH_RESULT_TITLE_BY_SUBSTRING_TPL, title);
        this.waitForElementAndClick(
                titleXpath,
                "Cannot find search result with title: " + title,
                15);
    }

    public void waitForSearchResult(String substring) {
        String searchResultXpath = replaceTemplate(SEARCH_RESULT_DESCRIPTION_BY_SUBSTRING_TPL, substring);
        this.waitForElementPresent(searchResultXpath,
                "Cannot find search result with substring: " + substring);
    }

    private static String replaceTemplate(String template, String substring) {
        return template.replace("{SUBSTRING}", substring);
    }

    public void initSearchInput() {
        this.waitForElementPresent(
                SEARCH_INIT_ELEMENT,
                "Cannot find search button",
                10);
        this.waitForElementAndClick(
                SEARCH_INIT_ELEMENT,
                "Cannot find search button",
                10);
    }

    public void initSearchInputAndClearSearchLine() {
        this.waitForElementPresent(
                SEARCH_INIT_ELEMENT,
                "Cannot find search button",
                10);
        this.waitForElementAndClick(
                SEARCH_INIT_ELEMENT,
                "Cannot find search button",
                10);
        if (Platform.getInstance().isIOS()) {
            this.waitForElementAndClick(
                    CLEAR_SEARCH_LINE_BUTTON,
                    "Cannot send text in search field",
                    10);
        }
    }

    public void typeSearchLine(String searchLine) {
        this.waitForElementAndSendKeys(
                SEARCH_INPUT, searchLine,
                "Cannot send text in search field",
                10);
    }

    public List<WebElement> getListOfElements() {
        return this.waitAndReturnListOfElements(
                LIST_OF_ELEMENTS,
                "Cannot find the articles",
                15);
    }

    public boolean listOfElementsIsEmpty() {
        return this.waitForElementNotPresent(
                LIST_OF_ELEMENTS,
                "Articles is still present on the page",
                5);
    }

    public void resetSearch() {
        this.waitForElementAndClick(
                SEARCH_CLOSE_BUTTON,
                "Cannot find X button",
                10);
    }

    public void skipOnboarding() {
        this.waitForElementAndClick(
                SKIP_ONBOARDING_BUTTON,
                "Cannot find 'Skip' button",
                10);
    }
}
