package demoQA;

import demoQApom.ElementsPage;
import demoQApom.MainPage;
import demoQApom.TestBase;
import demoQApom.UploadPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainUploadTest extends TestBase {

    protected String filePath = "/home/edi/Desktop/image.png";
    protected String alertMessageText = String.format("Thanks, you have selected %s file to Upload", filePath);

    @Test
    public void testUpload() {

        MainPage mainPage = new MainPage(driver);
        ElementsPage elementsPage = mainPage.clickOnElements();
        UploadPage uploadPage = elementsPage.clickOnUpload();
        uploadPage.uploadFileSendKeys();
        assertEquals("Actual result is not the same as expected", alertMessageText, uploadPage.getMessageText()); // prvi je expected, drugi je actual
    }

}
