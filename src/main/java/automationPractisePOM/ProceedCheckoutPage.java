package automationPractisePOM;

import demoQApom.UploadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProceedCheckoutPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(ProceedCheckoutPage.class);

    public ProceedCheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl() {
        log.info("Getting Page url");
        log.info("==========================================");
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        log.info("Getting Page title");
        log.info("==========================================");
        return driver.getTitle();
    }

}