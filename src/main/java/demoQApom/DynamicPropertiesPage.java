package demoQApom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicPropertiesPage {

    protected WebDriver driver;



    @FindBy(xpath = "//div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']//p[.='This text has random Id']")
    WebElement randomTextId;
    @FindBy(id = "visibleAfter")
    WebElement visibleAfter;
    @FindBy(id = "enableAfter")
    WebElement enableButton;
    @FindBy(id = "colorChange")
    WebElement colorChange;

    public DynamicPropertiesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getRandomText() {
        return randomTextId.getText();
    }

    public void visibleAfterException() {
        try {
            visibleAfter.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }
    }

    public Boolean getEnableButtonFalse() {
        System.out.println(enableButton.isEnabled());
        return enableButton.isEnabled();
    }

    public Boolean getEnableButtonTrue() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(enableButton));
        System.out.println(enableButton.isEnabled());
        return enableButton.isEnabled();
    }

    public String getColorAssert() {
        return colorChange.getCssValue("color");
    }

    public Boolean visibleAfterTrue() {
        return visibleAfter.isDisplayed();
    }

}
