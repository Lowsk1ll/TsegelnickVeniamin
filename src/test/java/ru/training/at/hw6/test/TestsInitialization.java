package ru.training.at.hw6.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.training.at.hw6.main.steps.ActionStep;
import ru.training.at.hw6.main.steps.AssertionStep;

public class TestsInitialization {
    public static WebDriver driver;
    public static WebDriverWait wait;
    String site = "https://jdi-testing.github.io/jdi-light/index.html";
    ActionStep actionStep;
    AssertionStep assertionStep;

    @BeforeClass
    public void init(ITestContext testContext) {
        Capabilities capabilities = new ChromeOptions();
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.get(site);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        actionStep = new ActionStep(driver, wait);
        assertionStep = new AssertionStep(driver, wait);
        testContext.setAttribute("driver", driver);
    }

    @AfterClass(alwaysRun = true)
    public void close() {
        driver.quit();
        driver = null;
    }
}
