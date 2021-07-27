package automationPractisePOM;

import demoQApom.UploadPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutPaymentPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(CheckoutPaymentPage.class);

    @FindBy(css = "small:nth-of-type(2) > a")
    protected WebElement summaryProductAttr;
    @FindBy(css = ".address_0.cart_item.first_item.last_item.odd  p > a")
    protected WebElement summaryProductTitle;
    @FindBy(id = "total_product")
    protected WebElement summaryTotalPrice;
    @FindBy(css = "div#center_column  a[title='Proceed to checkout'] > span") // pogledati ovaj css path
    protected WebElement proceedToCheckout;

    public CheckoutPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Getting Summary Product Attributes text")
    public String getSummaryProductAttrText() {
        log.info("Getting Summary Product Attributes text");
        log.info("==========================================");
        return summaryProductAttr.getText();
    }

    @Step("Getting Summary Product Title text")
    public String getSummaryProductTitleText() {
        log.info("Getting Summary Product Title text");
        log.info("==========================================");
        return summaryProductTitle.getText();
    }

    @Step("Getting Summary total price text")
    public String getSummaryTotalPriceText() {
        log.info("Getting Summary total price text");
        log.info("==========================================");
        return summaryTotalPrice.getText();
    }

    @Step("Clicking on Proceed to Checkout Page")
    public ProceedCheckoutPage clickOnProceed() {
        log.info("Clicking on Proceed to Checkout Page");
        log.info("==========================================");
        proceedToCheckout.click();
        return new ProceedCheckoutPage(driver);
    }
}
