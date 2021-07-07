package demoQApom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage visitUrl() {
        driver.get("https://demoqa.com/");
        return new MainPage(driver);
    }
}
