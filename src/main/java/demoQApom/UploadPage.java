package demoQApom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadPage {
    protected String filePath = "/home/edi/Desktop/image.png";
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

    public void uploadFileSendKeys() {
        log.info("Uploading a file");
        log.info("==========================================");
        uploadFile.sendKeys(filePath);
    }

    public String getMessageText() {
        log.info("Getting the message about the upload");
        log.info("==========================================");
        return alertMessage.getText();
    }
}
