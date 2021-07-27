package automationPractisePOM;

import demoQApom.UploadPage;
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


public class SearchPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(SearchPage.class);

    @FindBy(css = ".quick-view > span")
    protected WebElement quickView;
    @FindBy(css = "div#short_description_content > p")
    protected WebElement blouseItemDesc;
    @FindBy(css = "a[title='Blouse'] > img[alt='Blouse']")
    protected WebElement blouseItem;
    @FindBy(tagName = "iframe")
    protected WebElement iFrame;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Switching to iframe window on the page")
    public void switchToIframe() {
        log.info("Switching to iframe window on the page");
        log.info("==========================================");
        driver.switchTo().frame(iFrame);
    }

    @Step("Hovering over blouse item")
    public void hoverBlouseItem() {
        log.info("Hovering over blouse item");
        log.info("==========================================");
        Actions action = new Actions(driver);
        action.moveToElement(blouseItem).perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(quickView));
    }

    @Step("Clicking quick view")
    public void clickQuickView() {
        log.info("Clicking quick view");
        log.info("==========================================");
        quickView.click();
    }

    @Step("Getting blouse description for assertation")
    public String getBlouseDesc() {
        log.info("Getting blouse description for assertation");
        log.info("==========================================");
        return blouseItemDesc.getText();
    }

}