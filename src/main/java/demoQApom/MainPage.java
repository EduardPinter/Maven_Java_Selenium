package demoQApom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    protected WebDriver driver;

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
        elementsPage.click();
        return new ElementsPage(driver);
    }

    public WidgetsPage clickOnWidgets() {
        widgetsPage.click();
        return new WidgetsPage(driver);
    }

    public InteractionsPage clickOnInteractions() {
        interactionsPage.click();
        return new InteractionsPage(driver);
    }

}
