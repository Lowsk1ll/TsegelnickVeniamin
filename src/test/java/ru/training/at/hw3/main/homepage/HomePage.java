package ru.training.at.hw3.main.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.training.at.hw3.main.homepage.pagecomponents.HeaderSection;
import ru.training.at.hw3.main.homepage.pagecomponents.LeftSection;

public class HomePage {
    HeaderSection headerSection;
    LeftSection leftSection;
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "user-icon")
    WebElement userIcon;

    @FindBy(css = ".dropdown-menu.dropdown-menu-login")
    WebElement dropdownLoginMenu;

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameTextField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordTextField;

    @FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-login']/form/button[@type='submit']")
    WebElement loginSubmitButton;

    @FindBy(xpath = "//span[@id='user-name']")
    WebElement userName;

    @FindBy(xpath = "//span[@class='icons-benefit icon-practise']")
    WebElement firstImage;

    @FindBy(xpath = "//span[@class='icons-benefit icon-custom']")
    WebElement secondImage;

    @FindBy(xpath = "//span[@class='icons-benefit icon-multi']")
    WebElement thirdImage;

    @FindBy(xpath = "//span[@class='icons-benefit icon-base']")
    WebElement fourthImage;

    @FindBy(xpath = "//div[@class='col-sm-3'][1]//span[@class='benefit-txt']")
    WebElement textUnderFirstImage;

    @FindBy(xpath = "//div[@class='col-sm-3'][2]//span[@class='benefit-txt']")
    WebElement textUnderSecondImage;

    @FindBy(xpath = "//div[@class='col-sm-3'][3]//span[@class='benefit-txt']")
    WebElement textUnderThirdImage;

    @FindBy(xpath = "//div[@class='col-sm-3'][4]//span[@class='benefit-txt']")
    WebElement textUnderFourthImage;

    @FindBy(xpath = "//iframe[@id='frame']")
    WebElement frameCardTitle;

    @FindBy(xpath = "//input[@id='frame-button']")
    WebElement frameButton;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.headerSection = new HeaderSection();
        this.leftSection = new LeftSection();
        PageFactory.initElements(driver, this);
    }

    public void checkBrowserTitle(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public void loginUser(String userName, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
        wait.until(ExpectedConditions.visibilityOf(dropdownLoginMenu));
        nameTextField.sendKeys(userName);
        passwordTextField.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitButton)).click();
    }

    public void checkUsername(String expectedUsername) {
        Assert.assertTrue(userName.getText().equals(expectedUsername) & userName.isDisplayed());
    }

    public void checkHeaderMenuElements() {
        headerSection.checkHeaderMenu();
    }

    public void checkImages() {
        Assert.assertTrue(firstImage.isDisplayed());
        Assert.assertTrue(secondImage.isDisplayed());
        Assert.assertTrue(thirdImage.isDisplayed());
        Assert.assertTrue(fourthImage.isDisplayed());
    }

    public void checkTextUnderImages() {
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
    }

    public void checkFrameElements() {
        Assert.assertTrue(frameCardTitle.isDisplayed());
        driver.switchTo().frame(frameCardTitle);
        Assert.assertTrue(frameButton.isEnabled());
        driver.switchTo().defaultContent();
    }

    public void checkLeftMenuElements() {
        leftSection.checkLeftMenu();
    }

    public void openDifferentElementsPage() {
        headerSection.serviceButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(headerSection.differentElementsButton)).click();
    }
}
