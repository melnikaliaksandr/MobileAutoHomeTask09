package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTest extends CoreTestCase {

    @Test
    public void testThreeArticlesVerification() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        String title = "Android";
        searchPageObject.typeSearchLine(title);
        List<WebElement> listOfArticles = searchPageObject.getListOfElements();
        assertTrue("Error in article of title",
                searchPageObject.checkTitleInArticle(title, 3, listOfArticles));
    }

}
