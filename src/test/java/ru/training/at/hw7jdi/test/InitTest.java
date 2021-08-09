package ru.training.at.hw7jdi.test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;

import io.cucumber.java.ro.Si;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw7jdi.site.SiteJdi;

public interface InitTest {
    @BeforeSuite(alwaysRun = true)
     static void setUp() {
        killAllSeleniumDrivers();
        initElements(SiteJdi.class);
        SiteJdi.homePage.open();
    }

    @AfterSuite(alwaysRun = true)
     static void teardown() {
        killAllSeleniumDrivers();
    }
}
