package demoQApom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ToolTipPage {

    protected WebDriver driver;


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

    public void hoverButton() {
        Actions action = new Actions(driver);
        action.moveToElement(toolTipBtn).perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(btnMessage));
    }

    public String getButtonText() {
        return btnMessage.getText();
    }

    public void hoverInputField() {
        Actions action = new Actions(driver);
        action.moveToElement(textField).perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(textFieldMessage));
    }

    public String getInputFieldMessage() {
        return textFieldMessage.getText();
    }


}
