package ru.training.at.hw6.main.steps;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Stream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.training.at.hw6.data.Values;

public class AssertionStep extends AbstractStep {

    WebDriver driver;

    public AssertionStep(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
    }

    @Step("Browser title check")
    public void checkBrowserTitle(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Step("Username check")
    public void checkUserName(String expectedUserName) {
        Assert.assertTrue(homePage.userName.getText().equals(expectedUserName) & homePage.userName.isDisplayed());
    }

    @Step("Checking the correct display of the main menu items")
    public void checkHeaderMenuElements() {
        Assert.assertTrue(homePage.headerSection.headerMenu.stream().allMatch(WebElement::isDisplayed));
        Assert.assertTrue(homePage.headerSection.headerMenu.stream().anyMatch(s -> s.getText().equals("HOME")));
        Assert.assertTrue(homePage.headerSection.headerMenu.stream().anyMatch(s -> s.getText().equals("CONTACT FORM")));
        Assert.assertTrue(homePage.headerSection.headerMenu.stream().anyMatch(s -> s.getText().equals("SERVICE")));
        Assert.assertTrue(
            homePage.headerSection.headerMenu.stream().anyMatch(s -> s.getText().equals("METALS & COLORS")));
    }

    @Step("Checking the display of pictures")
    public void checkImages() {
        Assert.assertTrue(
            Stream.of(homePage.firstImage, homePage.secondImage, homePage.thirdImage, homePage.fourthImage)
                  .allMatch(WebElement::isDisplayed));
    }

    @Step("Checking text under pictures")
    public void checkTextUnderImages() {
        Assert.assertTrue(Stream
            .of(homePage.textUnderFirstImage, homePage.textUnderSecondImage, homePage.textUnderThirdImage,
                homePage.textUnderFourthImage).allMatch(WebElement::isDisplayed));
        Assert.assertEquals(homePage.textUnderFirstImage.getText(), Values.TEXT_UNDER_FIRST_IMAGE);
        Assert.assertEquals(homePage.textUnderSecondImage.getText(), Values.TEXT_UNDER_SECOND_IMAGE);
        Assert.assertEquals(homePage.textUnderThirdImage.getText(), Values.TEXT_UNDER_THIRD_IMAGE);
        Assert.assertEquals(homePage.textUnderFourthImage.getText(), Values.TEXT_UNDER_FOURTH_IMAGE);
    }

    @Step("Checking the frame and buttons inside it")
    public void checkFrameElements() {
        Assert.assertTrue(homePage.frameCardTitle.isDisplayed());
        driver.switchTo().frame(homePage.frameCardTitle);
        Assert.assertTrue(homePage.frameButton.isEnabled());
        driver.switchTo().defaultContent();
    }

    @Step("Checking left menu items")
    public void checkLeftMenuElements() {
        Assert.assertTrue(Stream.of(homePage.leftSection.homeButton, homePage.leftSection.contactFormButton,
            homePage.leftSection.serviceButton, homePage.leftSection.metalsAndColorsButton,
            homePage.leftSection.elementsPacksButton).allMatch(
            WebElement::isDisplayed));
        Assert.assertEquals(homePage.leftSection.homeButton.getText(), "Home");
        Assert.assertEquals(homePage.leftSection.contactFormButton.getText(), "Contact form");
        Assert.assertEquals(homePage.leftSection.serviceButton.getText(), "Service");
        Assert.assertEquals(homePage.leftSection.metalsAndColorsButton.getText(), "Metals & Colors");
        Assert.assertEquals(homePage.leftSection.elementsPacksButton.getText(), "Elements packs");
    }

    @Step("Checking the log list")
    public void checkLogList(List<String> expectedCheckboxAndRadioElements) {
        Assert.assertTrue(differentElementsPage.logList.isDisplayed()
            & expectedCheckboxAndRadioElements.stream()
                                              .allMatch(s -> differentElementsPage.logList
                                                  .getText().contains(s)));
    }

    @Step("Checking selected items")
    public void checkSelectedElements() {
        Assert.assertTrue(Stream.of(differentElementsPage.waterCheckBox, differentElementsPage.windCheckBox,
            differentElementsPage.selenRadio).allMatch(WebElement::isSelected));
    }

    @Step("Checking the dropdown menu")
    public void checkDropDownMenu() {
        Select colors = new Select(differentElementsPage.colorsMenu);
        Assert.assertEquals(colors.getFirstSelectedOption().getText(), "Yellow");
    }
}
