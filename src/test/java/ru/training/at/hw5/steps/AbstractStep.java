package ru.training.at.hw5.steps;


import ru.training.at.hw5.differentelementspage.DifferentElementsPage;
import ru.training.at.hw5.homepage.HomePage;
import ru.training.at.hw5.hooks.CucumberHook;

public abstract class AbstractStep {
    HomePage homePage;
    DifferentElementsPage differentElementsPage;

    public AbstractStep() {
        this.homePage = new HomePage(CucumberHook.driver, CucumberHook.wait);
        this.differentElementsPage = new DifferentElementsPage(CucumberHook.driver, CucumberHook.wait);
    }

}
