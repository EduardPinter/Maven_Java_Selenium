package AutomationPractisePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage visitUrl() {
        driver.get("http://automationpractice.com/");
        return new MainPage(driver);
    }
}
