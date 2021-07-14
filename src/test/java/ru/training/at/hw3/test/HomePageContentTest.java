package ru.training.at.hw3.test;

import java.util.stream.Stream;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.data.Values;
import ru.training.at.hw3.main.homepage.HomePage;

public class HomePageContentTest extends TestsInitialization {

    @Test(dataProvider = "values", dataProviderClass = Values.class)
    public void firstExerciseTest(String expectedTitle, String userName, String password, String expectedUserName) {
        HomePage homePage = new HomePage(driver, wait);

        //Check browser title
        Assert.assertEquals(driver.getTitle(), expectedTitle);

        //Login user
        homePage.loginUser(userName, password);

        //check username
        Assert.assertTrue(homePage.userName.getText().equals(expectedUserName) & homePage.userName.isDisplayed());

        //check header menu elements
        Assert.assertTrue(homePage.headerSection.headerMenu.stream().allMatch(WebElement::isDisplayed));
        Assert.assertTrue(homePage.headerSection.headerMenu.stream().anyMatch(s -> s.getText().equals("HOME")));
        Assert.assertTrue(homePage.headerSection.headerMenu.stream().anyMatch(s -> s.getText().equals("CONTACT FORM")));
        Assert.assertTrue(homePage.headerSection.headerMenu.stream().anyMatch(s -> s.getText().equals("SERVICE")));
        Assert.assertTrue(
            homePage.headerSection.headerMenu.stream().anyMatch(s -> s.getText().equals("METALS & COLORS")));

        //check images
        Assert.assertTrue(
            Stream.of(homePage.firstImage, homePage.secondImage, homePage.thirdImage, homePage.fourthImage)
                  .allMatch(WebElement::isDisplayed));

        //check text under images
        Assert.assertTrue(Stream
            .of(homePage.textUnderFirstImage, homePage.textUnderSecondImage, homePage.textUnderThirdImage,
                homePage.textUnderFourthImage).allMatch(WebElement::isDisplayed));
        Assert.assertEquals(homePage.textUnderFirstImage.getText(), Values.TEXT_UNDER_FIRST_IMAGE);
        Assert.assertEquals(homePage.textUnderSecondImage.getText(), Values.TEXT_UNDER_SECOND_IMAGE);
        Assert.assertEquals(homePage.textUnderThirdImage.getText(), Values.TEXT_UNDER_THIRD_IMAGE);
        Assert.assertEquals(homePage.textUnderFourthImage.getText(), Values.TEXT_UNDER_FOURTH_IMAGE);

        //chek frame elements
        Assert.assertTrue(homePage.frameCardTitle.isDisplayed());
        driver.switchTo().frame(homePage.frameCardTitle);
        Assert.assertTrue(homePage.frameButton.isEnabled());
        driver.switchTo().defaultContent();

        //check left menu elements
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
}
