package driverInit;

import extensions.DriverQuit;
import extensions.GetTestName;
import extensions.TestFailed;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.concurrent.TimeUnit;

@ExtendWith(GetTestName.class)
@ExtendWith(DriverQuit.class) // if the position of extendWith was reversed the screenshot would fail because
@ExtendWith(TestFailed.class) // the driver would be null

public class TestBase {

    protected WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(TestBase.class);

    @BeforeEach
    public void initializeWebDriver() throws IOException {
        log.info("Initializing the driver....");
        log.info("==========================================");
        String property = System.getProperty("browser", "chrome");

        switch (property.toLowerCase()) {
            case "chrome":
                log.info("Chrome was chosen!");
                getChromeDriver();
                break;
            case "firefox":
                log.info("Firefox was chosen!");
                getFirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser! Will not start any browser!");
        }

/*        String retVal = "";
        log.info(Runtime.getRuntime().toString() + "++++++++++++++++++");
        StackTraceElement[] trace = (new Throwable()).getStackTrace();
        retVal = trace[10].getClassName();

        log.info("!!!!!!!!!!!!!!!!!!!!!" + retVal + "!!!!!!!!!!!!!!!!!!!!!!");*/
/*        log.info("Logging in...............................");
        LogEntries logEntries = driver.manage().logs().get(LogType.DRIVER);
        List<LogEntry> logEntryList = logEntries.getAll();
        for(LogEntry entry : logEntryList){
            log.info(entry.getMessage());
        }*/
/*        File loggingFile = new File( + ".txt");
        PrintStream fileOutputStream = null;
        try {
            fileOutputStream = new PrintStream(new FileOutputStream(loggingFile, false));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(fileOutputStream);*/

    }


    public void getChromeDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--window-size=2560, 1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void getFirefoxDriver() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }
}

