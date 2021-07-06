package AutomationPractisePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TshirtsPage {

    protected WebDriver driver;

    @FindBy(css = "h5 > a[title='Faded Short Sleeve T-shirts']")
    protected WebElement fadedShortSleeve;

    public TshirtsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FadedTshirtPage clickOnFadedShortSleeve() {
        fadedShortSleeve.click();
        return new FadedTshirtPage(driver);
    }

}