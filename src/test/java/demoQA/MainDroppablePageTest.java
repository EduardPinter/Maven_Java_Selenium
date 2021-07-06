package demoQA;

import demoQApom.DroppablePage;
import demoQApom.InteractionsPage;
import demoQApom.MainPage;
import demoQApom.TestBase;
import org.junit.Test;

public class MainDroppablePageTest extends TestBase {

    @Test
    public void testDroppableElement() {
        MainPage mainPage = new MainPage(driver);
        InteractionsPage interactionsPage = mainPage.clickOnInteractions();
        DroppablePage droppablePage = interactionsPage.clickOnDroppablePage();
        droppablePage.dragAndDropElement();
    }

}
