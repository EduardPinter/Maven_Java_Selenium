package AutomationPractise;

import AutomationPractisePOM.*;
import org.junit.Assert;
import org.junit.Test;

public class MainCheckoutAssertationsTest extends TestBase {

    protected String shoppingCartTitleText = "Faded Short Sleeve T-shirts";
    protected String shoppingCartAttrText = "Blue, M";
    protected String shoppingCartQuantityText = "2";
    protected String shoppingCartCostText = "$33.02";
    protected String descColorSize = "Color : Blue, Size : M";
    protected String loginPageUrl = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
    protected String loginTitle = "Login - My Store";

    @Test
    public void testCheckoutAssertation() {

        MainPage mainPage = new MainPage(driver);
        mainPage.hoverWomenSection();
        TshirtsPage tshirtsPage = mainPage.clickTshirtSection();
        FadedTshirtPage fadedTshirtPage = tshirtsPage.clickOnFadedShortSleeve();
        fadedTshirtPage.pickColor();
        fadedTshirtPage.pickSize();
        fadedTshirtPage.enterQuantity("2");
        fadedTshirtPage.addToCartClick();
        Assert.assertEquals("Expected title is not the same as actual title", shoppingCartTitleText, fadedTshirtPage.getShoppingCartTitleText());
        Assert.assertEquals("Expected attributes are not the same as actual attributes", shoppingCartAttrText, fadedTshirtPage.getShoppingCartAttrText());
        Assert.assertEquals("Expected quantity is not the same as actual quantity", shoppingCartQuantityText, fadedTshirtPage.getShoppingCartQuantityText());
        Assert.assertEquals("Expected cost is not the same as actual cost", shoppingCartCostText, fadedTshirtPage.getShoppingCartCostText());
        CheckoutPaymentPage checkoutPaymentPage = fadedTshirtPage.proceedToCheckoutClick();
        Assert.assertEquals("Expected title is not the same as actual title", shoppingCartTitleText, checkoutPaymentPage.getSummaryProductTitleText());
        Assert.assertEquals("Expected attributes are not the same as actual attributes", descColorSize, checkoutPaymentPage.getSummaryProductAttrText());
        Assert.assertEquals("Expected cost is not the same as actual cost", shoppingCartCostText, checkoutPaymentPage.getSummaryTotalPriceText());
        ProceedCheckoutPage proceedCheckoutPage = checkoutPaymentPage.clickOnProceed();
        Assert.assertEquals("Expected page title is not the same as actual title", loginTitle, proceedCheckoutPage.getPageTitle());
        Assert.assertEquals("Expected url is not the same as actual url", loginPageUrl, proceedCheckoutPage.getPageUrl());

    }
}
