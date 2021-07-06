package AutomationPractisePOM;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class MainPage {

    protected WebDriver driver;


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

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverWomenSection() {
        Actions actions = new Actions(driver);
        actions.moveToElement(womenNavigationLink).perform();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(tshirtSection));
    }

    public TshirtsPage clickTshirtSection() {
        tshirtSection.click();
        return new TshirtsPage(driver);
    }

    public void searchBarSendKeys(String word) {
        searchInputField.sendKeys(word);
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(driver);
    }

    public void clickNextButtonSlider() throws InterruptedException {
        nextButton.click();
        Thread.sleep(1000);
    }

    public String getSliderCssProperty() {
        return sliderSelector.getCssValue("left");
    }

    public String getSrcAttribute() {
        return srcRedDress.getAttribute("src");
    }

    public void screenshotElement() throws IOException {
        File file = sliderScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenshot.png"));
    }
}
