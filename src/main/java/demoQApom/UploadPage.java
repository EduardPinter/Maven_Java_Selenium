package demoQApom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadPage {
    protected String filePath = "/home/edi/IdeaProjects/Maven_Java_Selenium/image.png";
    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(UploadPage.class);

    @FindBy(id = "uploadFile")
    WebElement uploadFile;
    @FindBy(id = "uploadedFilePath")
    WebElement alertMessage;

    public UploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Uploading a file")
    public void uploadFileSendKeys() {
        log.info("Uploading a file");
        log.info("==========================================");
        uploadFile.sendKeys(filePath);
    }

    @Step("Getting the message about the upload")
    public String getMessageText() {
        log.info("Getting the message about the upload");
        log.info("==========================================");
        return alertMessage.getText();
    }
}
