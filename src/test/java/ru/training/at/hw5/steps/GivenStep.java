package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GivenStep extends AbstractStep {

    @Given("I open through {string} and {string} different elements page")
    public void openDifferentElementsPageThroughSectionAndButton(String section, String button) {
        //можно сделать кастомные типы(например{section},
        //но на сайте сложно собрать елементы в коллецию(больше результатов(чем нужно) выдаёт при поиске групы)
        if (section.equals("headerSection")) {
            switch (button) {
                case "home":
                    break;
                case "contact_form":
                    break;
                case "service":
                    homePage.headerSection.serviceButton.click();
                    homePage.wait
                        .until(ExpectedConditions.elementToBeClickable(homePage.headerSection.differentElementsButton))
                        .click();
                    break;
                default:
            }
        }
    }

    @Given("I open JDI GitHub site")
    public void openHomepage() {
        homePage.openHomePage();
    }

    @Given("I login user with name {string} and pass {string}")
    public void loginUser(String userName, String password) {
        homePage.loginUser(userName, password);
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void loginAsRomanIovlev() {
        homePage.loginUser("Roman", "Jdi1234");
    }



}
