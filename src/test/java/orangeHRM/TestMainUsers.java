package orangeHRM;

import orangeHRMpom.BasePage;
import orangeHRMpom.LoginPage;
import orangeHRMpom.MainPage;
import orangeHRMpom.SystemUsersPage;
import DriverInit.TestBase;
import org.junit.jupiter.api.Test;

public class TestMainUsers extends TestBase {

    @Test
    public void testUsers() {

        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = basePage.visitUrl();
        MainPage mainPage = loginPage.systemLogin();
        SystemUsersPage systemUsersPage = mainPage.clickViewSystemUsers();
        systemUsersPage.countLengthOfTable();
        systemUsersPage.printNames();
    }
}
