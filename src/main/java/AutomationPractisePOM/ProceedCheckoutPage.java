package AutomationPractisePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ProceedCheckoutPage {

    protected WebDriver driver;


    public ProceedCheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}