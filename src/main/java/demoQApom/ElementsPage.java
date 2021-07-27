package demoQApom;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ElementsPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(ElementsPage.class);

    @FindBy(css = ".collapse.element-list.show > .menu-list > li:nth-of-type(9) > .text")
    WebElement dynamicPropSection;
    @FindBy(css = ".collapse.element-list.show > .menu-list > li:nth-of-type(8) > .text")
    WebElement uploadSection;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Clicking on Dynamic Properties page")
    public DynamicPropertiesPage clickOnDynamicProperties() {
        log.info("Clicking on Dynamic Properties page");
        log.info("==========================================");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dynamicPropSection);
        dynamicPropSection.click();
        return new DynamicPropertiesPage(driver);
    }

    @Step("Clicking on Upload segment of page")
    public UploadPage clickOnUpload() {
        log.info("Clicking on Upload segment of page");
        log.info("==========================================");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadSection);
        uploadSection.click();
        return new UploadPage(driver);
    }


}
