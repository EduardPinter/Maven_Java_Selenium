package orangeHRMpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    protected WebDriver driver;

    @FindBy(id = "menu_admin_viewAdminModule")
    WebElement navAdminModule;
    @FindBy(id = "menu_admin_UserManagement")
    WebElement navUserManag;
    @FindBy(id = "menu_admin_viewSystemUsers")
    WebElement navSystemUsers;
    @FindBy(id = "menu_pim_viewMyDetails")
    WebElement navMyDetails;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SystemUsersPage clickViewSystemUsers() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(navAdminModule));
        Actions actions = new Actions(driver);
        actions.moveToElement(navAdminModule).perform();
        wait.until(ExpectedConditions.visibilityOf(navUserManag));
        actions.moveToElement(navUserManag).perform();
        navSystemUsers.click();
        return new SystemUsersPage(driver);
    }

    public MyInfoPage clickMyInfo() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(navMyDetails));
        navMyDetails.click();
        return new MyInfoPage(driver);
    }
}