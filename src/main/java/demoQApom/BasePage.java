package demoQApom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.qameta.allure.Step;

public class BasePage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(BasePage.class);


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Visiting the url of the page")
    public MainPage visitUrl() {
        log.info("Visiting page url");
        log.info("==========================================");
        driver.get("https://demoqa.com/");
        return new MainPage(driver);
    }
}
