package demoQApom;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicPropertiesPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(DynamicPropertiesPage.class);


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

    @Step("Getting page's random text")
    public String getRandomText() {
        log.info("Getting page's random text");
        log.info("==========================================");
        return randomTextId.getText();
    }

    @Step("Checking if button is visible, not found")
    public void visibleAfterException() {
        log.info("Checking if button is visible, not found");
        log.info("==========================================");
        try {
            visibleAfter.isDisplayed();
        } catch (NoSuchElementException e) {
            log.debug("Element not found");
        }
    }

    @Step("Checking if button is enabled, FALSE")
    public Boolean getEnableButtonFalse() {
        log.info("Checking if button is enabled, FALSE");
        log.info("==========================================");
        System.out.println(enableButton.isEnabled());
        return enableButton.isEnabled();
    }

    @Step("Checking if button is enabled, TRUE")
    public Boolean getEnableButtonTrue() {
        log.info("Checking if button is enabled, TRUE");
        log.info("==========================================");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(enableButton));
        System.out.println(enableButton.isEnabled());
        return enableButton.isEnabled();
    }

    @Step("Getting color for assertion")
    public String getColorAssert() {
        log.info("Getting color for assertion");
        log.info("==========================================");
        return colorChange.getCssValue("color");
    }

    @Step("Checking if button is visible, TRUE")
    public Boolean visibleAfterTrue() {
        log.info("Checking if button is visible, TRUE");
        log.info("==========================================");
        return visibleAfter.isDisplayed();
    }

}
