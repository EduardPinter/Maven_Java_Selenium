package AutomationPractise;

import AutomationPractisePOM.MainPage;
import AutomationPractisePOM.SearchPage;
import AutomationPractisePOM.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class MainDescriptionAssertationTest extends TestBase {

    protected String word = "blouse";
    protected String blouseItemDescriptionText = "Short sleeved blouse with feminine draped sleeve detail.";

    @Test
    public void testDescriptionAssertation() {

        MainPage mainPage = new MainPage(driver);
        mainPage.searchBarSendKeys(word);
        SearchPage searchPage = mainPage.clickSearchButton();
        searchPage.hoverBlouseItem();
        searchPage.clickQuickView();
        searchPage.switchToIframe();
        Assert.assertEquals("Expected item desc is not the same as actual", blouseItemDescriptionText, searchPage.getBlouseDesc());

    }
}
