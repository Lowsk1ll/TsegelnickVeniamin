package ru.training.at.hw5.homepage.pagecomponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw5.hooks.CucumberHook;

public class LeftSection {
    @FindBy(xpath = "//li[@index='1']/a")
    public WebElement homeButton;

    @FindBy(xpath = "//li[@index='2']/a")
    public WebElement contactFormButton;

    @FindBy(xpath = "//li[@index='3']/a")
    public WebElement serviceButton;

    @FindBy(xpath = "//li[@index='4']/a[@href='metals-colors.html']")
    public WebElement metalsAndColorsButton;

    @FindBy(xpath = "//li[@index='5']/a[@ui='label']")
    public WebElement elementsPacksButton;

    public LeftSection() {
        PageFactory.initElements(CucumberHook.driver, this);
    }
}
