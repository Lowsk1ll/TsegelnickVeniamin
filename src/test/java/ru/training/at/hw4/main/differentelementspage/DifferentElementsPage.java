package ru.training.at.hw4.main.differentelementspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentElementsPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//label[contains(.,'Water')]/input")
    public WebElement waterCheckBox;

    @FindBy(xpath = "//label[contains(.,'Wind')]/input")
    public WebElement windCheckBox;

    @FindBy(xpath = "//label[contains(.,'Selen')]/input")
    public WebElement selenRadio;

    @FindBy(xpath = "//div[@class='colors']/select")
    public WebElement colorsMenu;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']")
    public WebElement logList;

    public DifferentElementsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void selectWaterElement() {
        wait.until(ExpectedConditions.elementToBeClickable(waterCheckBox)).click();
    }

    public void selectWindElement() {
        wait.until(ExpectedConditions.elementToBeClickable(windCheckBox)).click();
    }

    public void selectSelenElement() {
        wait.until(ExpectedConditions.elementToBeClickable(selenRadio)).click();
    }

    public void selectColor() {
        Select colors = new Select(colorsMenu);
        colors.selectByVisibleText("Yellow");
    }

}
