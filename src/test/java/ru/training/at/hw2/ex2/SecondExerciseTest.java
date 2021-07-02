package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw2.TestsInitialization;

public class SecondExerciseTest extends TestsInitialization {
    @Test
    public void exerciseTest() {

        //1.Open test site
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //2.Assert browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3.Login User
        wait.until(ExpectedConditions.elementToBeClickable(By.id("user-icon"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dropdown-menu.dropdown-menu-login")));
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Roman");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Jdi1234");
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@class='dropdown-menu dropdown-menu-login']/form/button[@type='submit']"))).click();

        //4.Assert that name is displayed and equals to "ROMAN IOVLEV"
        WebElement userName = driver.findElement(By.xpath("//span[@id='user-name']"));
        Assert.assertTrue(userName.getText().equals("ROMAN IOVLEV") & userName.isDisplayed());

        //5.Open Different Elements page
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Different elements']"))).click();

        //6.Select checkboxes
        WebElement waterCheckBox = driver.findElement(By.xpath("//label[1]/input"));
        wait.until(ExpectedConditions.elementToBeClickable(waterCheckBox)).click();
        WebElement windCheckBox = driver.findElement(By.xpath("//label[3]/input"));
        windCheckBox.click();

        //7.Select radio
        WebElement selenRadio = driver.findElement(By.xpath("//label[4]/input[@name='metal']"));
        selenRadio.click();
        driver.findElement(By.xpath("//div[@class='colors']")).click();

        //8.Select in dropdown
        WebElement yellowDropdown = driver.findElement(By.xpath("//div[@class='colors']/select/option[4]"));
        yellowDropdown.click();
        driver.findElement(By.xpath("//div[@class='colors']")).click();

        //9.Assert that each checkbox, radio, dropdown is selected correctly and has correct status on log row.
        Assert.assertTrue(
            driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Water')]"))
                  .isDisplayed() & waterCheckBox.isSelected());
        Assert.assertTrue(
            driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Wind')]"))
                  .isDisplayed() & windCheckBox.isSelected());
        Assert.assertTrue(
            driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Selen')]"))
                  .isDisplayed() & selenRadio.isSelected());
        Assert.assertTrue(
            driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Yellow')]"))
                  .isDisplayed() & yellowDropdown.isSelected());
    }
}
