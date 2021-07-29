package ru.training.at.hw5.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.training.at.hw5.hooks.CucumberHook;

public class WhenStep extends AbstractStep {

    @ParameterType("'(.+)'")
    public List<String> elements(String elements) {
        return Arrays.stream(elements.split(","))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }

    @When("I select elements {elements}")
    public void selectElements(List<String> elements) {
        elements.forEach(s -> differentElementsPage.wait.until(ExpectedConditions.elementToBeClickable(
            differentElementsPage.driver.findElement(By.xpath("//label[contains(.,\"" + s + "\")]/input"))))
                                                        .click());
    }

    @When("I select in dropdownmenu {string}")
    public void selectDropDownMenu(String element) {
        Select colors = new Select(differentElementsPage.colorsMenu);
        colors.selectByVisibleText(element);
    }

    @When("I click on {string} button in Header")
    public void clickHeaderMenuButton(String button) {
        homePage.wait.until(ExpectedConditions.elementToBeClickable(homePage.driver
            .findElement(By.xpath("//ul[contains(@class, 'uui-navigation')]/li[contains(.,\"" + button + "\")]"))))
                     .click();
    }

    @When("I click on {string} button in Service dropdown")
    public void clickServicesButton(String button) {
        homePage.wait.until(ExpectedConditions.elementToBeClickable(homePage.driver.findElement(By.xpath(
            "//ul[contains(@class, 'uui-navigation')]/li[contains(.,\"Service\")]//li[contains(.,\"" + button
                + "\")]")))).click();
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectCheckBoxForUsername(String username) {
        CucumberHook.driver.findElement(By.xpath("//tr[contains(.,\"" + username + "\")]/td/div/input")).click();
    }
}
