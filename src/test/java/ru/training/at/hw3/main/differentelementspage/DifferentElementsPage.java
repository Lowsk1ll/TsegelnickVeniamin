package ru.training.at.hw3.main.differentelementspage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DifferentElementsPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//label[1]/input")
    WebElement waterCheckBox;

    @FindBy(xpath = "//label[3]/input")
    WebElement windCheckBox;

    @FindBy(xpath = "//label[4]/input[@name='metal']")
    WebElement selenRadio;

    @FindBy(xpath = "//div[@class='colors']")
    WebElement colorsMenu;

    @FindBy(xpath = "//div[@class='colors']/select/option[4]")
    WebElement yellowDropdown;

    public DifferentElementsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void selectElements() {
        wait.until(ExpectedConditions.elementToBeClickable(waterCheckBox)).click();
        windCheckBox.click();
        selenRadio.click();
        colorsMenu.click();
        yellowDropdown.click();
        colorsMenu.click();
    }

    public void checkSelectedElementsAndLogRows() {
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
