package AutomationPractisePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FadedTshirtPage {

    protected WebDriver driver;


    @FindBy(id = "group_1")
    protected WebElement size;
    @FindBy(name = "Blue")
    protected WebElement color;
    @FindBy(id = "quantity_wanted")
    protected WebElement quantity;
    @FindBy(css = "p#add_to_cart  span")
    protected WebElement addToCartButton;
    @FindBy(id = "layer_cart_product_title")
    protected WebElement shoppingCartTitle;
    @FindBy(id = "layer_cart_product_attributes")
    protected WebElement shoppingCartAttr;
    @FindBy(id = "layer_cart_product_quantity")
    protected WebElement shoppingCartQuantity;
    @FindBy(id = "layer_cart_product_price")
    protected WebElement shoppingCartPrice;
    @FindBy(css = "a[title='Proceed to checkout'] > span")
    protected WebElement proceedToCheckout;
    @FindBy(linkText = "Faded Short Sleeve T-shirts")
    protected WebElement fadedShortSleeveLinkText;

    public FadedTshirtPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pickSize() {
        Select dropSize = new Select(size);
        dropSize.selectByVisibleText("M");
    }

    public void pickColor() {
        color.click();
    }

    public void enterQuantity(String quantityNumber) {
        quantity.clear();
        quantity.sendKeys(quantityNumber);
    }

    public void addToCartClick() {
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(shoppingCartTitle));
    }


    public String getShoppingCartTitleText() {
        return shoppingCartTitle.getText();
    }

    public String getShoppingCartAttrText() {
        return shoppingCartAttr.getText();
    }

    public String getShoppingCartQuantityText() {
        return shoppingCartQuantity.getText();
    }

    public String getShoppingCartCostText() {
        return shoppingCartPrice.getText();
    }

    public CheckoutPaymentPage proceedToCheckoutClick() {
        proceedToCheckout.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(fadedShortSleeveLinkText));
        return new CheckoutPaymentPage(driver);
    }

}
