package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.TestsInitialization;

public class HomePageContentTest extends TestsInitialization {

    @Test
    public void firstExerciseTest() {
        SoftAssert softAssert = new SoftAssert();

        //1.Open test site
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //2.Assert browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3.Login User
        wait.until(ExpectedConditions.elementToBeClickable(By.id("user-icon"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dropdown-menu.dropdown-menu-login")));
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Roman");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Jdi1234");
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@class='dropdown-menu dropdown-menu-login']/form/button[@type='submit']"))).click();

        //4.Assert that name is displayed and equals to "ROMAN IOVLEV"
        WebElement userName = driver.findElement(By.xpath("//span[@id='user-name']"));
        softAssert.assertTrue(userName.getText().equals("ROMAN IOVLEV") & userName.isDisplayed());

        //5.Assert that menu buttons are displayed and have proper text
        WebElement homeButton = driver.findElement(By.xpath("//a[@href='index.html']"));
        softAssert.assertTrue(homeButton.isDisplayed() & homeButton.getText().equals("HOME"));
        WebElement contactFormButton = driver.findElement(By.xpath("//a[@href='contacts.html']"));
        softAssert.assertTrue(contactFormButton.isDisplayed() & contactFormButton.getText().equals("CONTACT FORM"));
        WebElement serviceButton = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
        softAssert.assertTrue(serviceButton.isDisplayed() & serviceButton.getText().equals("SERVICE"));
        WebElement metalsAndColorsButton = driver.findElement(By.xpath("//a[@href='metals-colors.html']"));
        softAssert.assertTrue(
            metalsAndColorsButton.isDisplayed() & metalsAndColorsButton.getText().equals("METALS & COLORS"));

        //6.Assert that images are displayed
        softAssert
            .assertTrue(driver.findElement(By.xpath("//span[@class='icons-benefit icon-practise']")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//span[@class='icons-benefit icon-custom']")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//span[@class='icons-benefit icon-multi']")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//span[@class='icons-benefit icon-base']")).isDisplayed());

        //7.Assert that texts are displayed and equal to expected
        WebElement textUnderFirstImage =
            driver.findElement(By.xpath("//div[@class='col-sm-3'][1]//span[@class='benefit-txt']"));
        WebElement textUnderSecondImage =
            driver.findElement(By.xpath("//div[@class='col-sm-3'][2]//span[@class='benefit-txt']"));
        WebElement textUnderThirdImage =
            driver.findElement(By.xpath("//div[@class='col-sm-3'][3]//span[@class='benefit-txt']"));
        WebElement textUnderFourthImage =
            driver.findElement(By.xpath("//div[@class='col-sm-3'][4]//span[@class='benefit-txt']"));
        softAssert.assertTrue(
            textUnderFirstImage.isDisplayed() & textUnderFirstImage.getText().equals("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project"));
        softAssert.assertTrue(
            textUnderSecondImage.isDisplayed() & textUnderSecondImage.getText().equals("To be flexible and\n"
                + "customizable"));
        softAssert.assertTrue(
            textUnderThirdImage.isDisplayed() & textUnderThirdImage.getText().equals("To be multiplatform"));
        softAssert.assertTrue(
            textUnderFourthImage.isDisplayed() & textUnderFourthImage.getText().equals("Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…"));

        //8.Assert that iframe exists
        softAssert.assertTrue(driver.findElement(By.xpath("//iframe[@id='frame']")).isDisplayed());

        //9.Assert that "Frame Button" exists
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame']")));
        softAssert.assertTrue(driver.findElement(By.xpath("//input[@id='frame-button']")).isEnabled());

        //10.Switch driver on the original window
        driver.switchTo().defaultContent();

        //11.Assert that left sections menu items are displayed and have proper text
        WebElement leftHomeButton = driver.findElement(By.xpath("//li[@index='1']/a"));
        WebElement leftContactFormButton = driver.findElement(By.xpath("//li[@index='2']/a"));
        WebElement leftServiceButton = driver.findElement(By.xpath("//li[@index='3']/a"));
        WebElement leftMetalsAndColorsButton =
            driver.findElement(By.xpath("//li[@index='4']/a[@href='metals-colors.html']"));
        WebElement leftElementsPacksButton = driver.findElement(By.xpath("//li[@index='5']/a[@ui='label']"));
        softAssert.assertTrue(leftHomeButton.isDisplayed() & leftHomeButton.getText().equals("Home"));
        softAssert
            .assertTrue(leftContactFormButton.isDisplayed() & leftContactFormButton.getText().equals("Contact form"));
        softAssert.assertTrue(leftServiceButton.isDisplayed() & leftServiceButton.getText().equals("Service"));
        softAssert.assertTrue(
            leftMetalsAndColorsButton.isDisplayed() & leftMetalsAndColorsButton.getText().equals("Metals & Colors"));
        softAssert.assertTrue(
            leftElementsPacksButton.isDisplayed() & leftElementsPacksButton.getText().equals("Elements packs"));
        softAssert.assertAll();
    }
}
