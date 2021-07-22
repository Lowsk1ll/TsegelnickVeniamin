package ru.training.at.hw4.main.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("авторизация пользователя")
    public void loginUser(String userName, String password) {
        homePage.loginUser(userName, password);
    }

    @Step("открытие страницы с различными елементами")
    public void openDifferentElementsPage() {
        homePage.openDifferentElementsPage();
    }

    @Step("выбор различных елементов")
    public void selectDifferentElements() {
        differentElementsPage.selectWaterElement();
        differentElementsPage.selectWindElement();
        differentElementsPage.selectSelenElement();
        differentElementsPage.selectColor();
    }
}
