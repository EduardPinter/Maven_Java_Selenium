package orangeHRM;
import orangeHRMpom.LoginPage;
import orangeHRMpom.MainPage;
import orangeHRMpom.MyInfoPage;
import orangeHRMpom.TestBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainMyInfoTest extends TestBase {

    private final Logger log = LoggerFactory.getLogger(MainMyInfoTest.class);

    @Test
    public void testMyInfo() {

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.systemLogin();
        MyInfoPage myInfoPage = mainPage.clickMyInfo();
        String firstName = myInfoPage.getFirstNameValue();
        log.debug(firstName);
        String middleName = myInfoPage.getMiddleNameValue();
        log.debug(middleName);
        String lastName = myInfoPage.getLastNameValue();
        log.debug(lastName);
        String employeeId = myInfoPage.getEmployeeId();
        log.debug(employeeId);
        String maritalStatus = myInfoPage.getMaritalStatus();
        log.debug(maritalStatus);
        String birthDate = myInfoPage.getBirthDate();
        log.debug(birthDate);
        String gender = myInfoPage.checkedGender();
        log.debug(gender);
        String nationality = myInfoPage.getNationality();
        log.debug(nationality);
        String licenceExpiryDate = myInfoPage.getLicenceExpiryDate();
        log.debug(licenceExpiryDate);


    }

}
