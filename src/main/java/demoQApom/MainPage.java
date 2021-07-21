package demoQApom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(MainPage.class);

    @FindBy(css = "div:nth-of-type(1) > div > .card-up")
    WebElement elementsPage;
    @FindBy(css = "div:nth-of-type(4) > div > .card-up")
    WebElement widgetsPage;
    @FindBy(css = "div:nth-of-type(5) > div > .card-up")
    WebElement interactionsPage;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ElementsPage clickOnElements() {
        log.info("Clicking on Elements Page");
        log.info("==========================================");
        elementsPage.click();
        return new ElementsPage(driver);
    }

    public WidgetsPage clickOnWidgets() {
        log.info("Clicking on Widgets Page");
        log.info("==========================================");
        widgetsPage.click();
        return new WidgetsPage(driver);
    }

    public InteractionsPage clickOnInteractions() {
        log.info("Clicking on Interactions Page");
        log.info("==========================================");
        interactionsPage.click();
        return new InteractionsPage(driver);
    }

}
