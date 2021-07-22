package ru.training.at.hw4.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.training.at.hw4.main.steps.ActionStep;
import ru.training.at.hw4.main.steps.AssertionStep;

public class TestsInitialization {
    public static WebDriver driver;
    public static WebDriverWait wait;
    String site = "https://jdi-testing.github.io/jdi-light/index.html";
    ActionStep actionStep;
    AssertionStep assertionStep;

    @BeforeClass
    public void init(ITestContext testContext) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(site);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        actionStep = new ActionStep(driver, wait);
        assertionStep = new AssertionStep(driver, wait);
        testContext.setAttribute("driver", driver);
    }

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}
