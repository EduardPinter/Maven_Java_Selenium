package demoQApom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InteractionsPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(InteractionsPage.class);

    @FindBy(css = ".collapse.element-list.show > .menu-list > li:nth-of-type(4) > .text")
    WebElement droppablePage;

    public InteractionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DroppablePage clickOnDroppablePage() {
        log.info("Clicking on Droppable Page");
        log.info("==========================================");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", droppablePage);
        droppablePage.click();
        return new DroppablePage(driver);
    }


}
