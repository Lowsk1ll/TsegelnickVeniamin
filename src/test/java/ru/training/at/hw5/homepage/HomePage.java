package ru.training.at.hw5.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.training.at.hw5.homepage.pagecomponents.HeaderSection;
import ru.training.at.hw5.homepage.pagecomponents.LeftSection;

public class HomePage {
    public HeaderSection headerSection;
    public LeftSection leftSection;
    public WebDriver driver;
    public WebDriverWait wait;
    private static final String HOME_PAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @FindBy(id = "user-icon")
    public WebElement userIcon;

    @FindBy(css = ".dropdown-menu.dropdown-menu-login")
    public WebElement dropdownLoginMenu;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameTextField;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextField;

    @FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-login']/form/button[@type='submit']")
    public WebElement loginSubmitButton;

    @FindBy(xpath = "//span[@id='user-name']")
    public WebElement userName;

    @FindBy(xpath = "//span[@class='icons-benefit icon-practise']")
    public WebElement firstImage;

    @FindBy(xpath = "//span[@class='icons-benefit icon-custom']")
    public WebElement secondImage;

    @FindBy(xpath = "//span[@class='icons-benefit icon-multi']")
    public WebElement thirdImage;

    @FindBy(xpath = "//span[@class='icons-benefit icon-base']")
    public WebElement fourthImage;

    @FindBy(xpath = "//div[@class='col-sm-3'][1]//span[@class='benefit-txt']")
    public WebElement textUnderFirstImage;

    @FindBy(xpath = "//div[@class='col-sm-3'][2]//span[@class='benefit-txt']")
    public WebElement textUnderSecondImage;

    @FindBy(xpath = "//div[@class='col-sm-3'][3]//span[@class='benefit-txt']")
    public WebElement textUnderThirdImage;

    @FindBy(xpath = "//div[@class='col-sm-3'][4]//span[@class='benefit-txt']")
    public WebElement textUnderFourthImage;

    @FindBy(xpath = "//iframe[@id='frame']")
    public WebElement frameCardTitle;

    @FindBy(xpath = "//input[@id='frame-button']")
    public WebElement frameButton;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.headerSection = new HeaderSection();
        this.leftSection = new LeftSection();
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get(HOME_PAGE_URL);
    }

    public void loginUser(String userName, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
        wait.until(ExpectedConditions.visibilityOf(dropdownLoginMenu));
        nameTextField.sendKeys(userName);
        passwordTextField.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitButton)).click();
    }

    public void openDifferentElementsPage() {
        headerSection.serviceButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(headerSection.differentElementsButton)).click();
    }
}
