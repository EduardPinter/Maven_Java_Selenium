package demoQA;

import demoQApom.BasePage;
import demoQApom.ElementsPage;
import demoQApom.MainPage;
import demoQApom.UploadPage;
import driverInit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestMainUpload extends TestBase {

    protected String filePath = "/home/edi/IdeaProjects/Maven_Java_Selenium/image.png";  // koristiti unutar ovog foldera
    protected String alertMessageText = String.format("Thanks, you have selected %s file to Upload", filePath);
    private final Logger log = LoggerFactory.getLogger(TestMainUpload.class);

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
