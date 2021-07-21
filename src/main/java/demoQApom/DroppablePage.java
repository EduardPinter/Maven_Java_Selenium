package demoQApom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DroppablePage {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(DroppablePage.class);

    @FindBy(css = "div#draggable")
    WebElement draggable;
    @FindBy(css = "#simpleDropContainer #droppable")
    WebElement droppable;

    public DroppablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void dragAndDropElement() { // Doesnt work, needs a fix
        log.info("Drag and Drop element");
        log.info("==========================================");
        Actions actions = new Actions(driver);
        Action dragAndDrop = actions.clickAndHold(draggable).moveByOffset(30, 50).build();
        dragAndDrop.perform();
    }

}
