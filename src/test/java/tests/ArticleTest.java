package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.AuthorizationPageObject;
import lib.ui.MyReadingListPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyReadingListPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTest extends CoreTestCase {

    private final static String LOGIN = "skfjgh";
    private final static String PASSWORD = "1q2w3e4r5t6y!";

    @Test
    public void testSaveTwoArticles() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        MyReadingListPageObject myReadingListPageObject = MyReadingListPageObjectFactory.get(driver);
        AuthorizationPageObject authorizationPageObject= new AuthorizationPageObject(driver);

        if (Platform.getInstance().isMW()) {
            searchPageObject.openAuthorizationPage();
            authorizationPageObject.enterLoginAndPassword(LOGIN, PASSWORD);
            authorizationPageObject.clickLoginButton();
        }
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Java");
        String firstArticle = "High-level programming language";
        searchPageObject.openArticleWithDescription(firstArticle);
        articlePageObject.saveArticleToReadingList("Saved");
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            articlePageObject.closeArticle();
            articlePageObject.doNotSyncReadingList();
        }
        searchPageObject.initSearchInputAndClearSearchLine();
        searchPageObject.typeSearchLine("Android");
        searchPageObject.waitForSearchResult("Android");
        String secondArticle = "operating system";
        searchPageObject.openArticleWithDescription(secondArticle);
        articlePageObject.saveArticleToReadingList("Saved");
        articlePageObject.openMyReadingList();
        if (Platform.getInstance().isAndroid()) {
            myReadingListPageObject.openReadingList("Saved");
        }
        int countOfArticles = myReadingListPageObject.getCountOfArticles();
        myReadingListPageObject.deleteArticleByName(secondArticle);
        int countOfArticlesAfterDelete = myReadingListPageObject.getCountOfArticles();
        assertEquals("Error in count of articles", countOfArticles - 1, countOfArticlesAfterDelete);
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            myReadingListPageObject.openSearchPage();
        }
        searchPageObject.initSearchInputAndClearSearchLine();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Java");
        searchPageObject.openArticleWithDescription(firstArticle);
        articlePageObject.unSaveArticle();
        articlePageObject.openMyReadingList();
        if (Platform.getInstance().isAndroid()) {
            myReadingListPageObject.openReadingList("Saved");
        }
        assertTrue("Reading list is not empty", myReadingListPageObject.readingListIsEmpty());
    }

}
