package demoQA;

import demoQApom.BasePage;
import demoQApom.DynamicPropertiesPage;
import demoQApom.ElementsPage;
import demoQApom.MainPage;
import driverInit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestMainDynamicProperties extends TestBase {

    protected String randomText = "This text has random Id";
    protected String colorValue = "red";

    @Test
    public void testDynamicProperties() {

        BasePage basePage = new BasePage(driver);
        MainPage mainPage = basePage.visitUrl();
        ElementsPage elementsPage = mainPage.clickOnElements();
        DynamicPropertiesPage dpp = elementsPage.clickOnDynamicProperties();
        Assertions.assertEquals(randomText, dpp.getRandomText(), "Actual result is not the same as expected");
        dpp.visibleAfterException();
        Assertions.assertFalse(dpp.getEnableButtonFalse(), "Button is true");
        Assertions.assertTrue(dpp.getEnableButtonTrue(), "Button is false");
        Assertions.assertEquals(colorValue, dpp.getColorAssert(), "Color is not red");
        Assertions.assertTrue(dpp.visibleAfterTrue(), "Button is False");

    }

}
