package ru.training.at.hw6.main.homepage.pagecomponents;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw6.test.TestsInitialization;

public class HeaderSection {

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li")
    public List<WebElement> headerMenu;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement serviceButton;

    @FindBy(xpath = "//a[text()='Different elements']")
    public WebElement differentElementsButton;


    public HeaderSection() {
        PageFactory.initElements(TestsInitialization.driver, this);
    }

}
