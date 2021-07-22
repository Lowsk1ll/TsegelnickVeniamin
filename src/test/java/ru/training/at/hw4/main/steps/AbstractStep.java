package ru.training.at.hw4.main.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.training.at.hw4.main.differentelementspage.DifferentElementsPage;
import ru.training.at.hw4.main.homepage.HomePage;

public abstract class AbstractStep {
    HomePage homePage;
    DifferentElementsPage differentElementsPage;

    public AbstractStep(WebDriver driver, WebDriverWait wait) {
        this.homePage = new HomePage(driver, wait);
        this.differentElementsPage = new DifferentElementsPage(driver, wait);
    }

}
