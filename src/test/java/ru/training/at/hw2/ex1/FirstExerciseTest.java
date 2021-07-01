package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw2.TestsInitialization;

public class FirstExerciseTest extends TestsInitialization {

    @Test
    public void exerciseTest() {
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("user-icon")));
        Assert.assertEquals(driver.getTitle(), "Home Page");
        driver.findElement(By.id("user-icon")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dropdown-menu.dropdown-menu-login")));
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Roman");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Jdi1234");
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@class='dropdown-menu dropdown-menu-login']/form/button[@type='submit']")));
        driver.findElement(By.xpath("//div[@class='dropdown-menu dropdown-menu-login']/form//button[@type='submit']"))
              .click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='user-name']")).getText(), "ROMAN IOVLEV");
        WebElement homeButton = driver.findElement(By.xpath("//a[@href='index.html']"));
        Assert.assertTrue(homeButton.isDisplayed() & homeButton.getText().equals("HOME"));
        WebElement contactFormButton = driver.findElement(By.xpath("//a[@href='contacts.html']"));
        Assert.assertTrue(contactFormButton.isDisplayed() & contactFormButton.getText().equals("CONTACT FORM"));
        WebElement serviceButton = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
        Assert.assertTrue(serviceButton.isDisplayed() & serviceButton.getText().equals("SERVICE"));
        WebElement metalsAndColorsButton = driver.findElement(By.xpath("//a[@href='metals-colors.html']"));
        Assert.assertTrue(
            metalsAndColorsButton.isDisplayed() & metalsAndColorsButton.getText().equals("METALS & COLORS"));
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='icons-benefit icon-practise']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='icons-benefit icon-custom']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='icons-benefit icon-multi']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='icons-benefit icon-base']")).isDisplayed());
        WebElement textUnderFirstImage =
            driver.findElement(By.xpath("//div[@class='col-sm-3'][1]//span[@class='benefit-txt']"));
        WebElement textUnderSecondImage =
            driver.findElement(By.xpath("//div[@class='col-sm-3'][2]//span[@class='benefit-txt']"));
        WebElement textUnderThirdImage =
            driver.findElement(By.xpath("//div[@class='col-sm-3'][3]//span[@class='benefit-txt']"));
        WebElement textUnderFourthImage =
            driver.findElement(By.xpath("//div[@class='col-sm-3'][4]//span[@class='benefit-txt']"));
        Assert.assertTrue(
            textUnderFirstImage.isDisplayed() & textUnderFirstImage.getText().equals("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project"));
        Assert.assertTrue(
            textUnderSecondImage.isDisplayed() & textUnderSecondImage.getText().equals("To be flexible and\n"
                + "customizable"));
        Assert.assertTrue(
            textUnderThirdImage.isDisplayed() & textUnderThirdImage.getText().equals("To be multiplatform"));
        Assert.assertTrue(
            textUnderFourthImage.isDisplayed() & textUnderFourthImage.getText().equals("Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…"));
        Assert.assertTrue(driver.findElement(By.xpath("//iframe[@id='frame']")).isDisplayed());
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame']")));
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='frame-button']")).isEnabled());
        driver.switchTo().defaultContent();
        WebElement leftHomeButton = driver.findElement(By.xpath("//li[@index='1']/a"));
        WebElement leftContactFormButton = driver.findElement(By.xpath("//li[@index='2']/a"));
        WebElement leftServiceButton = driver.findElement(By.xpath("//li[@index='3']/a"));
        WebElement leftMetalsAndColorsButton =
            driver.findElement(By.xpath("//li[@index='4']/a[@href='metals-colors.html']"));
        WebElement leftElementsPacksButton = driver.findElement(By.xpath("//li[@index='5']/a[@ui='label']"));
        Assert.assertTrue(leftHomeButton.isDisplayed() & leftHomeButton.getText().equals("Home"));
        Assert.assertTrue(leftContactFormButton.isDisplayed() & leftContactFormButton.getText().equals("Contact form"));
        Assert.assertTrue(leftServiceButton.isDisplayed() & leftServiceButton.getText().equals("Service"));
        Assert.assertTrue(
            leftMetalsAndColorsButton.isDisplayed() & leftMetalsAndColorsButton.getText().equals("Metals & Colors"));
        Assert.assertTrue(
            leftElementsPacksButton.isDisplayed() & leftElementsPacksButton.getText().equals("Elements packs"));
    }
}
