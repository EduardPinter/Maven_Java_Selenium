package automationPractisePOM;

import demoQApom.UploadPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TshirtsPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(TshirtsPage.class);

    @FindBy(css = "h5 > a[title='Faded Short Sleeve T-shirts']")
    protected WebElement fadedShortSleeve;

    public TshirtsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Clicking on Faded Short Sleeve Shirt")
    public FadedTshirtPage clickOnFadedShortSleeve() {
        log.info("Clicking on Faded Short Sleeve Shirt");
        log.info("==========================================");
        fadedShortSleeve.click();
        return new FadedTshirtPage(driver);
    }

}