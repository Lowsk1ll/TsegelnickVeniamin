package ru.training.at.hw3.test;

import java.util.List;
import java.util.stream.Stream;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.data.Values;
import ru.training.at.hw3.main.differentelementspage.DifferentElementsPage;
import ru.training.at.hw3.main.homepage.HomePage;

public class DifferentElementsPageContentTest extends TestsInitialization {

    @Test(dataProvider = "values", dataProviderClass = Values.class)
    public void secondExerciseTest(String expectedTitle, String userName, String password, String expectedUserName,
                                   List<String> expectedCheckboxAndRadioElements) {
        HomePage homePage = new HomePage(driver, wait);

        //Check browser title
        Assert.assertEquals(driver.getTitle(), expectedTitle);

        //login user
        homePage.loginUser(userName, password);

        //check username
        Assert.assertTrue(homePage.userName.getText().equals(expectedUserName) & homePage.userName.isDisplayed());

        //open different elements page
        homePage.openDifferentElementsPage();

        //select elements
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver, wait);
        differentElementsPage.selectWaterElement();
        differentElementsPage.selectWindElement();
        differentElementsPage.selectSelenElement();
        differentElementsPage.selectColor();

        //check log list
        Assert.assertTrue(differentElementsPage.logList.isDisplayed()
            & expectedCheckboxAndRadioElements.stream()
                  .allMatch(s -> differentElementsPage.logList
                      .getText().contains(s)));

        //check checkbox and radio elements are selected
        Assert.assertTrue(Stream.of(differentElementsPage.waterCheckBox, differentElementsPage.windCheckBox,
            differentElementsPage.selenRadio).allMatch(WebElement::isSelected));

        //check dropdownmenu are selected
        Select colors = new Select(differentElementsPage.colorsMenu);
        Assert.assertEquals(colors.getFirstSelectedOption().getText(), "Yellow");
    }
}
