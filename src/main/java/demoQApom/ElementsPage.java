package demoQApom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ElementsPage {

    protected WebDriver driver;

    @FindBy(css = ".collapse.element-list.show > .menu-list > li:nth-of-type(9) > .text")
    WebElement dynamicPropSection;
    @FindBy(css = ".collapse.element-list.show > .menu-list > li:nth-of-type(8) > .text")
    WebElement uploadSection;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DynamicPropertiesPage clickOnDynamicProperties() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dynamicPropSection);
        dynamicPropSection.click();
        return new DynamicPropertiesPage(driver);
    }

    public UploadPage clickOnUpload() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadSection);
        uploadSection.click();
        return new UploadPage(driver);
    }


}
