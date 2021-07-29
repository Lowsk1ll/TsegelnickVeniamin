package ru.training.at.hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.training.at.hw5.hooks.CucumberHook;

public class ThenStep extends AbstractStep {

    @Then("I check that elements {elements} are selected")
    public void checkSelectedElements(List<String> elements) {
        Assert.assertTrue(elements.stream()
                                  .allMatch(s -> differentElementsPage.driver
                                      .findElement(By.xpath("//label[contains(.,'" + s + "')]/input"))
                                      .isSelected()));
    }

    @Then("I check that dropdownmenu is select {string}")
    public void checkDropDownMenu(String element) {
        Select colors = new Select(differentElementsPage.colorsMenu);
        Assert.assertEquals(colors.getFirstSelectedOption().getText(), element);
    }

    @Then("I check that logrows is displayed elements {elements}")
    public void checkLogRows(List<String> elements) {
        Assert.assertTrue(differentElementsPage.logList.isDisplayed()
            & elements.stream().allMatch(s -> differentElementsPage.logList.getText().contains(s)));
    }

    @Then("\"User Table\" page should be opened")
    public void checkUserTablePage() {
        Assert
            .assertEquals(CucumberHook.driver.getCurrentUrl(),
                "https://jdi-testing.github.io/jdi-light/user-table.html");
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkCountOfNumberType(int count) {
        Assert.assertEquals(count, CucumberHook.driver.findElements(By.xpath("//tbody/tr")).size());
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkCountOfUsernames(int count) {
        Assert.assertEquals(count, CucumberHook.driver.findElements(By.xpath("//tbody/tr/td/a")).size());
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkCountOfDescription(int count) {
        Assert.assertEquals(count, CucumberHook.driver.findElements(By.xpath("//tbody/tr/td/div/span")).size());
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkCountOfCheckboxes(int count) {
        Assert.assertEquals(count, CucumberHook.driver.findElements(By.xpath("//tbody/tr/td/div/input")).size());
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValues(DataTable values) {
        Assert.assertTrue(values.rows(2).asList().stream()
                                .allMatch(
                                    s -> CucumberHook.driver
                                        .findElement(By.xpath("//*[.=\"" + s + "\"]"))
                                        .isDisplayed()));
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable table) {
        Select droplist =
            new Select(CucumberHook.driver.findElement(By.xpath("//tr[contains(.,\"" + "Roman" + "\")]/td/select")));
        List<String> elements = droplist.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
        Assert.assertTrue(table.asList().stream().skip(1).allMatch(elements::contains));
    }

    @Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int count, String expectedText) {
        Assert.assertEquals(
            CucumberHook.driver.findElements(By.xpath("//ul[@class=\"panel-body-list logs\"]/li")).stream()
                               .filter(s -> s.getText().contains(expectedText)).count(), count);
    }
}
