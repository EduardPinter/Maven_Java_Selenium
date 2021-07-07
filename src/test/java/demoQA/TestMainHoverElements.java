package demoQA;

import demoQApom.BasePage;
import demoQApom.MainPage;
import demoQApom.ToolTipPage;
import demoQApom.WidgetsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import DriverInit.TestBase;
import static org.junit.Assert.assertEquals;

public class TestMainHoverElements extends TestBase {

    protected String buttonMessageHover = "You hovered over the Button";
    protected String inputFieldMessage = "You hovered over the text field";

    @Test
    public void testHoverElements() {

        BasePage basePage = new BasePage(driver);
        MainPage mainPage = basePage.visitUrl();
        WidgetsPage widgetsPage = mainPage.clickOnWidgets();
        ToolTipPage toolTipPage = widgetsPage.clickOnToolTip();
        toolTipPage.hoverButton();
        Assertions.assertEquals(buttonMessageHover, toolTipPage.getButtonText(), "Actual result is not the same as expected");
        toolTipPage.hoverInputField();
        Assertions.assertEquals(inputFieldMessage, toolTipPage.getInputFieldMessage(), "Actual result is not the same as expected");
    }
}
