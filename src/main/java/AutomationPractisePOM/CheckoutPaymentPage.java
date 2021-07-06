package AutomationPractisePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPaymentPage {

    protected WebDriver driver;

    @FindBy(css = "small:nth-of-type(2) > a")
    protected WebElement summaryProductAttr;
    @FindBy(css = ".address_0.cart_item.first_item.last_item.odd  p > a")
    protected WebElement summaryProductTitle;
    @FindBy(id = "total_product")
    protected WebElement summaryTotalPrice;
    @FindBy(css = "div#center_column  a[title='Proceed to checkout'] > span")
    protected WebElement proceedToCheckout;

    public CheckoutPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSummaryProductAttrText() {
        return summaryProductAttr.getText();
    }

    public String getSummaryProductTitleText() {
        return summaryProductTitle.getText();
    }

    public String getSummaryTotalPriceText() {
        return summaryTotalPrice.getText();
    }

    public ProceedCheckoutPage clickOnProceed() {
        proceedToCheckout.click();
        return new ProceedCheckoutPage(driver);
    }
}
