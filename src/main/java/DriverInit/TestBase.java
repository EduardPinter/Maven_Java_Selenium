package DriverInit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestBase {

    protected WebDriver driver;

    @BeforeEach
    public void initializeWebDriver() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @AfterEach
    public void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

