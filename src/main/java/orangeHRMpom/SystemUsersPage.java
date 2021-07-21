package orangeHRMpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SystemUsersPage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(SystemUsersPage.class);

    @FindBy(css = "#resultTable > tbody > tr")
    List<WebElement> lengthOfTable;
    @FindBy(css = "#resultTable > tbody > tr > td:nth-child(2) > a")
    List<WebElement> names;

    public SystemUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void countLengthOfTable() {
        log.info("Counting length of the table");
        log.info("==========================================");
        Integer counter = lengthOfTable.size();
        log.info("Number of names on the first page is : " + counter);
    }

    public void printNames() {
        log.info("Printing names from the table on the 1st page");
        log.info("==========================================");
        for (WebElement element : names) {
            log.info(element.getText());
        }
    }
}