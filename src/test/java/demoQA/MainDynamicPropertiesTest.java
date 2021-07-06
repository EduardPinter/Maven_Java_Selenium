package demoQA;

import demoQApom.DynamicPropertiesPage;
import demoQApom.ElementsPage;
import demoQApom.MainPage;
import demoQApom.TestBase;
import org.junit.Test;

import static org.junit.Assert.*;


public class MainDynamicPropertiesTest extends TestBase {

    protected String randomText = "This text has random Id";
    protected String colorValue = "red";

    @Test
    public void testDynamicProperties() {

        MainPage mainPage = new MainPage(driver);
        ElementsPage elementsPage = mainPage.clickOnElements();
        DynamicPropertiesPage dpp = elementsPage.clickOnDynamicProperties();
        assertEquals("Actual result is not the same as expected", randomText, dpp.getRandomText());
        dpp.visibleAfterException();
        assertFalse("Button is true", dpp.getEnableButtonFalse());
        assertTrue("Button is false", dpp.getEnableButtonTrue());
        assertEquals("Color is not red", colorValue, dpp.getColorAssert());
        assertTrue("Button is False", dpp.visibleAfterTrue());

    }

}
