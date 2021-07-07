package AutomationPractise;

import AutomationPractisePOM.BasePage;
import AutomationPractisePOM.MainPage;
import DriverInit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class  MainScreenshotElementTest extends TestBase {

    protected String pixelsRedDress = "-2337px";
    protected String srcOfPicture = "http://automationpractice.com/modules/homeslider/images/sample-3.jpg";

    @Test
    public void testScreenshotElement() throws InterruptedException, IOException {

        BasePage basePage = new BasePage(driver);
        MainPage mainPage = basePage.visitUrl();
        mainPage.clickNextButtonSlider();
        mainPage.clickNextButtonSlider();
        Assertions.assertEquals(mainPage.getSliderCssProperty(), pixelsRedDress, "Expected value is not the same as Actual");
        Assertions.assertEquals(mainPage.getSrcAttribute(), srcOfPicture, "Expected 'src' attribute is not the same as Actual");
        mainPage.screenshotElement();

    }
}
