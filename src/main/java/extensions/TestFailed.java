package extensions;

import driverInit.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class TestFailed implements TestWatcher {

    private final Logger log = LoggerFactory.getLogger(TestFailed.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        log.info("Assertion Failed : \n {} ", cause.getMessage());
        log.info("==========================================");
        final TestBase testBase = (TestBase) context.getRequiredTestInstance();
        final File screenshot = createScreenshotOfWindow(testBase.getDriver());
        File destFile = new File("/home/edi/IdeaProjects/Maven_Java_Selenium/FailedScreenshot" + "/" + context.getDisplayName());
        try {
            FileUtils.copyFileToDirectory(screenshot, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("***** Error " + context.getDisplayName() + " test has failed ******");
        log.info("==========================================");
        log.info("Driver on which case test case failed : " + testBase.getDriver());
        log.info("==========================================");
    }

    public File createScreenshotOfWindow(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

}
