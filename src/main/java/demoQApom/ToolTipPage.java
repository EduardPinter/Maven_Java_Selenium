package demoQApom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ToolTipPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(ToolTipPage.class);

    @FindBy(id = "toolTipButton")
    WebElement toolTipBtn;
    @FindBy(id = "buttonToolTip")
    WebElement btnMessage;
    @FindBy(id = "toolTipTextField")
    WebElement textField;
    @FindBy(id = "textFieldToolTip")
    WebElement textFieldMessage;

    public ToolTipPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Hovering over a button")
    public void hoverButton() {
        log.info("Hovering over a button");
        log.info("==========================================");
        Actions action = new Actions(driver);
        action.moveToElement(toolTipBtn).perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(btnMessage));
    }

    @Step("Getting button hover text message")
    public String getButtonText() {
        log.info("Getting button hover text message");
        log.info("==========================================");
        return btnMessage.getText();
    }

    @Step("Hovering over a input field")
    public void hoverInputField() {
        log.info("Hovering over a input field");
        log.info("==========================================");
        Actions action = new Actions(driver);
        action.moveToElement(textField).perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(textFieldMessage));
    }

    @Step("Getting input field hover text message")
    public String getInputFieldMessage() {
        log.info("Getting input field hover text message");
        log.info("==========================================");
        return textFieldMessage.getText();
    }


}
