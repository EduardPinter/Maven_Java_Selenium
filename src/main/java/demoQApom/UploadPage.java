package demoQApom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage {
    protected String filePath = "/home/edi/Desktop/image.png";
    protected WebDriver driver;

    @FindBy(id = "uploadFile")
    WebElement uploadFile;
    @FindBy(id = "uploadedFilePath")
    WebElement alertMessage;

    public UploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void uploadFileSendKeys() {
        uploadFile.sendKeys(filePath);
    }

    public String getMessageText() {
        return alertMessage.getText();
    }
}
