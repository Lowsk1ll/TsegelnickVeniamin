package ru.training.at.hw7jdi.site;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import java.awt.Button;
import ru.training.at.hw7jdi.forms.LoginForm;
import ru.training.at.hw7jdi.site.pages.HomePage;
import ru.training.at.hw7jdi.site.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {

    public static HomePage homePage;
    public static MetalsColorsPage metalsColorsPage;

    public static LoginForm loginForm;
    @Css("img#user-icon")
    public static UIElement userIcon;
    @Css(".profile-photo [ui=label]")
    public static Label userName;
    @UI("ul.uui-navigation [*'Metals']")
    public static UIElement metalsColors;
    @XPath("//*[text()='Logout']")
    public static UIElement logout;
}
