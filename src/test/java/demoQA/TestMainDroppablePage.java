package demoQA;

import demoQApom.BasePage;
import demoQApom.DroppablePage;
import demoQApom.InteractionsPage;
import demoQApom.MainPage;
import org.junit.jupiter.api.Test;
import driverInit.TestBase;

public class TestMainDroppablePage extends TestBase {

    @Test
    public void testDroppableElement() {

        BasePage basePage = new BasePage(driver);
        MainPage mainPage = basePage.visitUrl();
        InteractionsPage interactionsPage = mainPage.clickOnInteractions();
        DroppablePage droppablePage = interactionsPage.clickOnDroppablePage();
        droppablePage.dragAndDropElement();
    }

}
