package extensions;

import driverInit.TestBase;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class DriverQuit implements TestWatcher {

    private final Logger log = LoggerFactory.getLogger(DriverQuit.class);

    @Override
    public void testSuccessful(ExtensionContext context) {
        final TestBase testBase = (TestBase) context.getRequiredTestInstance();
        testBase.getDriver().quit();
        log.info("Test was successful, test name : " + testBase);
        MDC.remove("methodName");
        MDC.clear();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        final TestBase testBase = (TestBase) context.getRequiredTestInstance();
        testBase.getDriver().quit();
        log.info("Test failed, test name : " + testBase);
        MDC.remove("methodName");
        MDC.remove("folderName");
        MDC.clear();

    }

}
