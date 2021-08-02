package automationPractisePOM;

import demoQApom.UploadPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FadedTshirtPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(FadedTshirtPage.class);

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

    @Step("Picking size")
    public void pickSize() {
        log.info("Picking size");
        log.info("==========================================");
        Select dropSize = new Select(size);
        dropSize.selectByVisibleText("M");
    }

    @Step("Picking color")
    public void pickColor() {
        log.info("Picking color");
        log.info("==========================================");
        color.click();
    }

    @Step("Entering quantity of shirts")
    public void enterQuantity(String quantityNumber) {
        log.info("Entering quantity of shirts");
        log.info("==========================================");
        quantity.clear();
        quantity.sendKeys(quantityNumber);
    }

    @Step("Clicking on add to cart")
    public void addToCartClick() {
        log.info("Clicking on add to cart");
        log.info("==========================================");
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(shoppingCartTitle));
    }

    @Step("Getting shopping cart title text")
    public String getShoppingCartTitleText() {
        log.info("Getting shopping cart title text");
        log.info("==========================================");
        return shoppingCartTitle.getText();
    }

    @Step("Getting shopping cart attributes text")
    public String getShoppingCartAttrText() {
        log.info("Getting shopping cart attributes text");
        log.info("==========================================");
        return shoppingCartAttr.getText();
    }

    @Step("Getting shopping cart quantity text")
    public String getShoppingCartQuantityText() {
        log.info("Getting shopping cart quantity text");
        log.info("==========================================");
        return shoppingCartQuantity.getText();
    }

    @Step("Getting shopping cart price text")
    public String getShoppingCartCostText() {
        log.info("Getting shopping cart price text");
        log.info("==========================================");
        return shoppingCartPrice.getText();
    }

    @Step("Proceeding to Checkout Payment Page")
    public CheckoutPaymentPage proceedToCheckoutClick() {
        log.info("Proceeding to Checkout Payment Page");
        log.info("==========================================");
        proceedToCheckout.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(fadedShortSleeveLinkText));
        return new CheckoutPaymentPage(driver);
    }

}
