package orangeHRMpom;

import demoQApom.UploadPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    protected WebDriver driver;
    protected String usernameInput = "Admin";
    protected String passwordInput = "admin123";
    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "txtUsername")
    WebElement username;
    @FindBy(id = "txtPassword")
    WebElement password;
    @FindBy(id = "btnLogin")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Loggin into the page")
    public MainPage systemLogin() {
        log.info("Loggin into the page");
        log.info("==========================================");
        username.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
        loginButton.click();
        return new MainPage(driver);
    }
}