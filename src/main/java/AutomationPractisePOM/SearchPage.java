package AutomationPractisePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage {

    protected WebDriver driver;

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

    public void switchToIframe() {
        driver.switchTo().frame(iFrame);
    }

    public void hoverBlouseItem() {
        Actions action = new Actions(driver);
        action.moveToElement(blouseItem).perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(quickView));
    }

    public void clickQuickView() {
        quickView.click();
    }

    public String getBlouseDesc() {
        return blouseItemDesc.getText();
    }

}