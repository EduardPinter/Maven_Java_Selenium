package demoQA;

import demoQApom.BasePage;
import demoQApom.ElementsPage;
import demoQApom.MainPage;
import demoQApom.UploadPage;
import DriverInit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MainUploadTest extends TestBase {

    protected String filePath = "/home/edi/Desktop/image.png";  // koristiti unutar ovog foldera
    protected String alertMessageText = String.format("Thanks, you have selected %s file to Upload", filePath);

    @Test
    public void testUpload() {

        BasePage basePage = new BasePage(driver);
        MainPage mainPage = basePage.visitUrl();
        ElementsPage elementsPage = mainPage.clickOnElements();
        UploadPage uploadPage = elementsPage.clickOnUpload();
        uploadPage.uploadFileSendKeys();
        Assertions.assertEquals(alertMessageText, uploadPage.getMessageText(), "Actual result is not the same as expected"); // prvi je expected, drugi je actual
    }

}
