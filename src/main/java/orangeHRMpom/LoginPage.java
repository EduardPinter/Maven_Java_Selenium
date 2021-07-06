package orangeHRMpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected WebDriver driver;
    protected String usernameInput = "Admin";
    protected String passwordInput = "admin123";

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

    public MainPage systemLogin() {
        username.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
        loginButton.click();
        return new MainPage(driver);
    }
}