package automationPractisePOM;

import demoQApom.UploadPage;
import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage visitUrl() {
        log.info("Visiting the page url");
        log.info("==========================================");
        driver.get("http://automationpractice.com/");
        return new MainPage(driver);
    }
}
