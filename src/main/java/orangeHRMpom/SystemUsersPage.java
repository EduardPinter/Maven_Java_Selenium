package orangeHRMpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SystemUsersPage {

    protected WebDriver driver;

    @FindBy(css = "#resultTable > tbody > tr")
    List<WebElement> lengthOfTable;
    @FindBy(css = "#resultTable > tbody > tr > td:nth-child(2) > a")
    List<WebElement> names;

    public SystemUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void countLengthOfTable() {

        Integer counter = 0;
        for (WebElement element : lengthOfTable) {
            counter++;
        }
        System.out.println("Number of names on the first page is : " + counter);
    }

    public void printNames() {
        for (WebElement element : names) {
            System.out.println(element.getText());
        }
    }
}