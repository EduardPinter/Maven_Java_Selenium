package demoQA;

import demoQApom.MainPage;
import demoQApom.TestBase;
import demoQApom.ToolTipPage;
import demoQApom.WidgetsPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainHoverElementsTest extends TestBase {

    protected String buttonMessageHover = "You hovered over the Button";
    protected String inputFieldMessage = "You hovered over the text field";

    @Test
    public void testHoverElements() {

        MainPage mainPage = new MainPage(driver);
        WidgetsPage widgetsPage = mainPage.clickOnWidgets();
        ToolTipPage toolTipPage = widgetsPage.clickOnToolTip();
        toolTipPage.hoverButton();
        assertEquals("Actual result is not the same as expected", buttonMessageHover, toolTipPage.getButtonText());
        toolTipPage.hoverInputField();
        assertEquals("Actual result is not the same as expected", inputFieldMessage, toolTipPage.getInputFieldMessage());
    }
}
