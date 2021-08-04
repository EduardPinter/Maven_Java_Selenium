package AutomationPractise;

import automationPractisePOM.*;
import driverInit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMainCheckoutAssertion extends TestBase {

    protected String shoppingCartTitleText = "Faded Short Sleeve T-shirts";
    protected String shoppingCartAttrText = "Blue, M";
    protected String shoppingCartQuantityText = "2";
    protected String shoppingCartCostText = "$33.02";
    protected String descColorSize = "Color : Blue, Size : M";
    protected String loginPageUrl = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
    protected String loginTitle = "Login - My Store";

    @Test
    public void testCheckoutAssertion() {

        BasePage basePage = new BasePage(driver);
        MainPage mainPage = basePage.visitUrl();
        //mainPage.hoverWomenSection(); commented out because website changed, no longer is viable option
        //TshirtsPage tshirtsPage = mainPage.clickTshirtSection();
        TshirtsPage tshirtsPage = mainPage.footerWomenCategory();
        FadedTshirtPage fadedTshirtPage = tshirtsPage.clickOnFadedShortSleeve();
        fadedTshirtPage.pickColor();
        fadedTshirtPage.pickSize();
        fadedTshirtPage.enterQuantity("2");
        fadedTshirtPage.addToCartClick();
        Assertions.assertEquals(shoppingCartTitleText, fadedTshirtPage.getShoppingCartTitleText(), "Expected title is not the same as actual title");
        Assertions.assertEquals(shoppingCartAttrText, fadedTshirtPage.getShoppingCartAttrText(), "Expected attributes are not the same as actual attributes");
        Assertions.assertEquals(shoppingCartQuantityText, fadedTshirtPage.getShoppingCartQuantityText(), "Expected quantity is not the same as actual quantity");
        Assertions.assertEquals(shoppingCartCostText, fadedTshirtPage.getShoppingCartCostText(), "Expected cost is not the same as actual cost");
        CheckoutPaymentPage checkoutPaymentPage = fadedTshirtPage.proceedToCheckoutClick();
        Assertions.assertEquals(shoppingCartTitleText, checkoutPaymentPage.getSummaryProductTitleText(), "Expected title is not the same as actual title");
        Assertions.assertEquals(descColorSize, checkoutPaymentPage.getSummaryProductAttrText(), "Expected attributes are not the same as actual attributes");
        Assertions.assertEquals(shoppingCartCostText, checkoutPaymentPage.getSummaryTotalPriceText(), "Expected cost is not the same as actual cost");
        ProceedCheckoutPage proceedCheckoutPage = checkoutPaymentPage.clickOnProceed();
        Assertions.assertEquals(loginTitle, proceedCheckoutPage.getPageTitle(), "Expected page title is not the same as actual title");
        Assertions.assertEquals(loginPageUrl, proceedCheckoutPage.getPageUrl(), "Expected url is not the same as actual url");

    }
}
