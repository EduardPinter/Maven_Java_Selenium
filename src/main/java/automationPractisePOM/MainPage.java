package automationPractisePOM;

import demoQApom.UploadPage;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class MainPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(MainPage.class);


    @FindBy(css = "a[title='Women']")
    protected WebElement womenNavigationLink;
    @FindBy(css = ".first-in-line-xs.submenu-container a[title='T-shirts']")
    protected WebElement tshirtSection;
    @FindBy(id = "search_query_top")
    protected WebElement searchInputField;
    @FindBy(name = "submit_search")
    protected WebElement searchButton;
    @FindBy(className = "bx-next")
    protected WebElement nextButton;
    @FindBy(css = "#homeslider")
    protected WebElement sliderSelector;
    @FindBy(css = "#homepage-slider")
    protected WebElement sliderScreenshot;
    @FindBy(css = "#homeslider > li:nth-child(4) > a > img")
    protected WebElement srcRedDress;
    @FindBy(css = "#footer > div > section.blockcategories_footer.footer-block.col-xs-12.col-sm-2 > div > div > ul > li > a")
    protected WebElement footerWomen;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Hovering over 'Women' navigation link")
    public void hoverWomenSection() {
        log.info("Hovering over 'Women' navigation link");
        log.info("==========================================");
        Actions actions = new Actions(driver);
        actions.moveToElement(womenNavigationLink).perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(tshirtSection));
    }

    @Step("Clicking Tshirt section")
    public TshirtsPage clickTshirtSection() {
        log.info("Clicking Tshirt section");
        log.info("==========================================");
        tshirtSection.click();
        return new TshirtsPage(driver);
    }

    @Step("Search bar typing word")
    public void searchBarSendKeys(String word) {
        log.info("Search bar typing word");
        log.info("==========================================");
        searchInputField.sendKeys(word);
    }

    @Step("Clicking search button")
    public SearchPage clickSearchButton() {
        log.info("Clicking search button");
        log.info("==========================================");
        searchButton.click();
        return new SearchPage(driver);
    }

    @Step("Clicking slider next button")
    public void clickNextButtonSlider() throws InterruptedException {
        log.info("Clicking slider next button");
        log.info("==========================================");
        nextButton.click();
        Thread.sleep(1000);
    }

    @Step("Getting slider css property")
    public String getSliderCssProperty() {
        log.info("Getting slider css property");
        log.info("==========================================");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.attributeToBe(sliderSelector, "left", "-2337px"));
        return sliderSelector.getCssValue("left");
    }

    @Step("Getting current slider picture source attribute")
    public String getSrcAttribute() {
        log.info("Getting current slider picture source attribute");
        log.info("==========================================");
        return srcRedDress.getAttribute("src");
    }

    @Step("Screenshoting the Element")
    public void screenshotElement() throws IOException {
        log.info("Screenshoting the Element");
        log.info("==========================================");
        File file = sliderScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenshot.png"));
    }

    @Step("Women category in footer click")
    public TshirtsPage footerWomenCategory(){
        footerWomen.click();
        return new TshirtsPage(driver);
    }
}
