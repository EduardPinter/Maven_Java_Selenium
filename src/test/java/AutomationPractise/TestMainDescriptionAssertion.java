package AutomationPractise;

import automationPractisePOM.BasePage;
import automationPractisePOM.MainPage;
import automationPractisePOM.SearchPage;
import driverInit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMainDescriptionAssertion extends TestBase {

    protected String word = "blouse";
    protected String blouseItemDescriptionText = "Short sleeved blouse with feminine draped sleeve detail.";

    @Test
    public void testDescriptionAssertation() {

        BasePage basePage = new BasePage(driver);
        MainPage mainPage = basePage.visitUrl();
        mainPage.searchBarSendKeys(word);
        SearchPage searchPage = mainPage.clickSearchButton();
        searchPage.hoverBlouseItem();
        searchPage.clickQuickView();
        searchPage.switchToIframe();
        Assertions.assertEquals(blouseItemDescriptionText, searchPage.getBlouseDesc(), "Expected item desc is not the same as actual");

    }
}
