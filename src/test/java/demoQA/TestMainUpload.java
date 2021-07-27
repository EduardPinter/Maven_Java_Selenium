package demoQA;

import demoQApom.BasePage;
import demoQApom.ElementsPage;
import demoQApom.MainPage;
import demoQApom.UploadPage;
import driverInit.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Epic("Upload Test")
@Feature("Valid upload message")
public class TestMainUpload extends TestBase {

    //protected String filePath = "/home/edi/IdeaProjects/Maven_Java_Selenium/image.png";  // koristiti unutar ovog foldera
    //protected String alertMessageText = String.format("Thanks, you have selected %s file to Upload", filePath);
    protected String fileName = "imag.png";
    protected String realAllertMessage = String.format("C:\\fakepath\\%s", fileName);
    private final Logger log = LoggerFactory.getLogger(TestMainUpload.class);


    @Story("User uploads a file")
    @Description("User uploads an image, alert message is the path to the file")
    @Test
    public void testUpload() {

        BasePage basePage = new BasePage(driver);
        MainPage mainPage = basePage.visitUrl();
        ElementsPage elementsPage = mainPage.clickOnElements();
        UploadPage uploadPage = elementsPage.clickOnUpload();
        uploadPage.uploadFileSendKeys();
        Assertions.assertEquals(realAllertMessage, uploadPage.getMessageText(), "Actual result is not the same as expected"); // prvi je expected, drugi je actual

    }

}
