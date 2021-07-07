package orangeHRM;

import orangeHRMpom.BasePage;
import orangeHRMpom.LoginPage;
import orangeHRMpom.MainPage;
import orangeHRMpom.MyInfoPage;
import DriverInit.TestBase;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMainMyInfo extends TestBase {

    private final Logger log = LoggerFactory.getLogger(TestMainMyInfo.class);

    @Test
    public void testMyInfo() {

        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = basePage.visitUrl();
        MainPage mainPage = loginPage.systemLogin();
        MyInfoPage myInfoPage = mainPage.clickMyInfo();
        String firstName = myInfoPage.getFirstNameValue();
        log.debug("First Name : " + firstName);
        String middleName = myInfoPage.getMiddleNameValue();
        log.debug("Middle Name : " + middleName);
        String lastName = myInfoPage.getLastNameValue();
        log.debug("Last Name : " + lastName);
        String employeeId = myInfoPage.getEmployeeId();
        log.debug("Employee Id : " + employeeId);
        String maritalStatus = myInfoPage.getMaritalStatus();
        log.debug("Marital Status : " + maritalStatus);
        String birthDate = myInfoPage.getBirthDate();
        log.debug("Birth Date : " + birthDate);
        String gender = myInfoPage.checkedGender();
        log.debug("Gender : " + gender);
        String nationality = myInfoPage.getNationality();
        log.debug("Nationality : " + nationality);
        String licenceExpiryDate = myInfoPage.getLicenceExpiryDate();
        log.debug("Licence Expiry Date : " + licenceExpiryDate);


    }

}
