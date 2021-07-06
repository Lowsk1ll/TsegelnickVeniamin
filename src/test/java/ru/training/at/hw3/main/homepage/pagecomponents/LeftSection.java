package ru.training.at.hw3.main.homepage.pagecomponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.training.at.hw3.test.TestsInitialization;

public class LeftSection {
    @FindBy(xpath = "//li[@index='1']/a")
    WebElement homeButton;

    @FindBy(xpath = "//li[@index='2']/a")
    WebElement contactFormButton;

    @FindBy(xpath = "//li[@index='3']/a")
    WebElement serviceButton;

    @FindBy(xpath = "//li[@index='4']/a[@href='metals-colors.html']")
    WebElement metalsAndColorsButton;

    @FindBy(xpath = "//li[@index='5']/a[@ui='label']")
    WebElement elementsPacksButton;

    public LeftSection() {
        PageFactory.initElements(TestsInitialization.driver, this);
    }

    public void checkLeftMenu() {
        Assert.assertTrue(homeButton.isDisplayed() & homeButton.getText().equals("Home"));
        Assert.assertTrue(contactFormButton.isDisplayed() & contactFormButton.getText().equals("Contact form"));
        Assert.assertTrue(serviceButton.isDisplayed() & serviceButton.getText().equals("Service"));
        Assert.assertTrue(
            metalsAndColorsButton.isDisplayed() & metalsAndColorsButton.getText().equals("Metals & Colors"));
        Assert.assertTrue(elementsPacksButton.isDisplayed() & elementsPacksButton.getText().equals("Elements packs"));
    }
}
