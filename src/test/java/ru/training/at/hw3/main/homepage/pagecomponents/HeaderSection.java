package ru.training.at.hw3.main.homepage.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.training.at.hw3.test.TestsInitialization;

public class HeaderSection {

    @FindBy(xpath = "//a[@href='index.html']")
    public WebElement homeButton;

    @FindBy(xpath = "//a[@href='contacts.html']")
    public WebElement contactFormButton;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement serviceButton;

    @FindBy(xpath = "//a[@href='metals-colors.html']")
    public WebElement metalsAndColorsButton;

    @FindBy(xpath = "//a[text()='Different elements']")
    public WebElement differentElementsButton;

    public HeaderSection() {
        PageFactory.initElements(TestsInitialization.driver, this);
    }

    public void checkHeaderMenu() {
        Assert
            .assertTrue(homeButton.isDisplayed() & homeButton.getText().equals("HOME"));
        Assert.assertTrue(contactFormButton.isDisplayed() & contactFormButton.getText().equals("CONTACT FORM"));
        Assert.assertTrue(serviceButton.isDisplayed() & serviceButton.getText().equals("SERVICE"));
        Assert.assertTrue(
            metalsAndColorsButton.isDisplayed() & metalsAndColorsButton.getText().equals("METALS & COLORS"));
    }
}
