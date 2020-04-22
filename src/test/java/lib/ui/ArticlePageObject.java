package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            WATCHLIST,
            MENU_BUTTON,
            OVERFLOW_READING_LIST,
            OVERFLOW_MENU_BUTTON,
            NO_THANKS_BUTTON,
            DIALOG_CHECKBOX,
            NAVIGATE_UP_BUTTON,
            UN_SAVE,
            BOOKMARK_MENU_BUTTON,
            ONBOARDING_BUTTON,
            PATH_TO_READING_LIST_TPL,
            TITLE_OF_ARTICLE;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    private static String replaceTemplate(String template, String substring) {
        return template.replace("{SUBSTRING}", substring);
    }

    public WebElement getTitleElement() {
        return this.getElementByXpath(TITLE_OF_ARTICLE);
    }

    public String getTitleOfArticle() {
        return this.waitForElementAndGetAttribute(
                TITLE_OF_ARTICLE,
                "text",
                "Cannot get attribute text",
                20);
    }

    public void doNotSyncReadingList() {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    DIALOG_CHECKBOX,
                    "Cannot find checkbox",
                    10);
            this.waitForElementAndClick(
                    NO_THANKS_BUTTON,
                    "Cannot find 'No thanks' button",
                    10);
        } else {
            this.waitForElementAndClick(
                    DIALOG_CHECKBOX,
                    "Cannot find checkbox",
                    10);
            closeArticle();
        }
    }

    public void openMyReadingList() {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    OVERFLOW_MENU_BUTTON,
                    "Cannot find 'Menu' button",
                    10);
            this.waitForElementAndClick(
                    OVERFLOW_READING_LIST,
                    "Cannot find 'My lists' button",
                    10);
        } else if (Platform.getInstance().isIOS()) {
            closeArticle();
            this.waitForElementAndClick(
                    OVERFLOW_READING_LIST,
                    "Cannot find 'Menu' button",
                    10);
        } else {
            this.waitForElementAndClick(
                    MENU_BUTTON,
                    "Cannot find menu button",
                    10);
            this.tryClickElementWithFewAttempts(
                    WATCHLIST,
                    "Cannot find login button",
                    10);
        }
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                NAVIGATE_UP_BUTTON,
                "Cannot find 'Navigate up' button",
                10);
    }

    public void unSaveArticle() {
        if (Platform.getInstance().isAndroid()) {

        } else if (Platform.getInstance().isIOS()){
            this.waitForElementAndClick(
                    UN_SAVE,
                    "Cannot find 'Save to reading list' button",
                    10);
        } else {
            this.waitForElementAndClick(
                    BOOKMARK_MENU_BUTTON,
                    "Cannot find 'Save to reading list' button",
                    10);
        }
    }

    public void saveArticleToReadingList(String readingListName) {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    BOOKMARK_MENU_BUTTON,
                    "Cannot find 'Save to reading list' button",
                    10);
            this.waitForElementAndClick(
                    ONBOARDING_BUTTON,
                    "Cannot find 'Onboarding' button",
                    10);
            String readingList = replaceTemplate(PATH_TO_READING_LIST_TPL, readingListName);
            this.waitForElementAndClick(
                    readingList,
                    "Cannot find list for saved articles",
                    10);
        } else if (Platform.getInstance().isIOS()) {
            this.waitForElementAndClick(
                    BOOKMARK_MENU_BUTTON,
                    "Cannot find 'Save to reading list' button",
                    10);
        } else {
            this.waitForElementAndClick(
                    BOOKMARK_MENU_BUTTON,
                    "Cannot find 'Save to reading list' button",
                    10);
        }
    }

    public void saveArticleToReadingListAndCloseHint(String readingListName) {
        this.waitForElementAndClick(
                BOOKMARK_MENU_BUTTON,
                "Cannot find 'Save to reading list' button",
                10);
        this.waitForElementAndClick(
                BOOKMARK_MENU_BUTTON,
                "Cannot find 'Save to reading list' button",
                10);
        String folderForArticle = replaceTemplate(PATH_TO_READING_LIST_TPL, readingListName);
        this.waitForElementAndClick(
                folderForArticle,
                "Cannot find list for saved articles",
                10);
    }

}
