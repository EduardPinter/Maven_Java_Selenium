package demoQApom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WidgetsPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(UploadPage.class);

    @FindBy(css = ".collapse.element-list.show > .menu-list > li:nth-of-type(7) > .text")
    WebElement toolTipSection;

    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ToolTipPage clickOnToolTip() {
        log.info("Clicking on ToolTip page");
        log.info("==========================================");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toolTipSection);
        toolTipSection.click();
        return new ToolTipPage(driver);
    }
}
