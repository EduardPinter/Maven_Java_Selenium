package demoQApom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPage {

    protected WebDriver driver;

    @FindBy(css = ".collapse.element-list.show > .menu-list > li:nth-of-type(7) > .text")
    WebElement toolTipSection;

    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ToolTipPage clickOnToolTip() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toolTipSection);
        toolTipSection.click();
        return new ToolTipPage(driver);
    }
}
