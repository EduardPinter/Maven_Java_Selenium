package demoQA;

import demoQApom.BasePage;
import demoQApom.DynamicPropertiesPage;
import demoQApom.ElementsPage;
import demoQApom.MainPage;
import DriverInit.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestMainDynamicProperties extends TestBase {

    protected String randomText = "This text has random Id";
    protected String colorValue = "red";

    @Test
    public void testDynamicProperties() {

        BasePage basePage = new BasePage(driver);
        MainPage mainPage = basePage.visitUrl();
        ElementsPage elementsPage = mainPage.clickOnElements();
        DynamicPropertiesPage dpp = elementsPage.clickOnDynamicProperties();
        assertEquals(randomText, dpp.getRandomText(), "Actual result is not the same as expected");
        dpp.visibleAfterException();
        assertFalse(dpp.getEnableButtonFalse(), "Button is true");
        assertTrue(dpp.getEnableButtonTrue(), "Button is false");
        assertEquals(colorValue, dpp.getColorAssert(), "Color is not red");
        assertTrue(dpp.visibleAfterTrue(), "Button is False");

    }

}
