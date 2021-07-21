package orangeHRMpom;

import demoQApom.UploadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyInfoPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(MyInfoPage.class);

    @FindBy(id = "personal_txtEmpFirstName")
    WebElement firstName;
    @FindBy(id = "personal_txtEmpMiddleName")
    WebElement middleName;
    @FindBy(id = "personal_txtEmpLastName")
    WebElement lastName;
    @FindBy(id = "personal_txtEmployeeId")
    WebElement employeeId;
    @FindBy(id = "personal_cmbMarital")
    WebElement maritalStatus;
    @FindBy(id = "personal_DOB")
    WebElement birthDate;
    @FindBy(id = "personal_optGender_1")
    WebElement genderMale;
    @FindBy(id = "personal_optGender_2")
    WebElement genderFemale;
    @FindBy(id = "personal_cmbNation")
    WebElement nationality;
    @FindBy(id = "personal_txtLicExpDate")
    WebElement licenceExpiryDate;
    @FindBy(css = "#frmEmpPersonalDetails > fieldset > ol:nth-child(3) > li.radio > ul > li:nth-child(1) > label")
    WebElement genderMaleText;
    @FindBy(css = "#frmEmpPersonalDetails > fieldset > ol:nth-child(3) > li.radio > ul > li:nth-child(2) > label")
    WebElement genderFemaleText;

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstNameValue() {
        log.info("Getting First Name Value");
        log.info("==========================================");
        return firstName.getAttribute("value");
    }

    public String getMiddleNameValue() {
        log.info("Getting Middle Name Value");
        log.info("==========================================");
        return middleName.getAttribute("value");
    }

    public String getLastNameValue() {
        log.info("Getting Last Name Value");
        log.info("==========================================");
        return lastName.getAttribute("value");
    }

    public String getEmployeeId() {
        log.info("Getting Employee id");
        log.info("==========================================");
        return employeeId.getAttribute("value");
    }

    public String getBirthDate() {
        log.info("Getting birth date");
        log.info("==========================================");
        return birthDate.getAttribute("value");
    }

    public String getLicenceExpiryDate() {
        log.info("Getting licence expiry date");
        log.info("==========================================");
        return licenceExpiryDate.getAttribute("value");
    }

    public String getMaritalStatus() {
        log.info("Getting Marital Status");
        log.info("==========================================");
        Select select = new Select(maritalStatus);
        return select.getFirstSelectedOption().getText();
    }

    public String getNationality() {
        log.info("Getting Nationality");
        log.info("==========================================");
        Select select = new Select(nationality);
        return select.getFirstSelectedOption().getText();
    }

    public String checkedGender() {
        log.info("Checking the persons gender");
        log.info("==========================================");
        if (genderMale.isSelected()) {
            return genderMale.getText();
        } else
            return genderFemale.getText();
    }
}