package orangeHRM;

import orangeHRMpom.LoginPage;
import orangeHRMpom.MainPage;
import orangeHRMpom.SystemUsersPage;
import orangeHRMpom.TestBase;
import org.junit.Test;

public class MainUsersTest extends TestBase {

    @Test
    public void testUsers() {

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.systemLogin();
        SystemUsersPage systemUsersPage = mainPage.clickViewSystemUsers();
        systemUsersPage.countLengthOfTable();
        systemUsersPage.printNames();
    }
}
