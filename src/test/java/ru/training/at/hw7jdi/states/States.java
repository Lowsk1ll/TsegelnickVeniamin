package ru.training.at.hw7jdi.states;

import com.epam.jdi.light.elements.composite.WebPage;
import ru.training.at.hw7jdi.entities.User;
import ru.training.at.hw7jdi.site.SiteJdi;

public class States {
    private static void onSite() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/")) {
            SiteJdi.homePage.open();
        }
    }

    public static void shouldBeLoggedIn() {
        onSite();
        if (!SiteJdi.userName.isDisplayed()) {
            login();
        }
    }

    public static void login() {
        SiteJdi.userIcon.click();
        SiteJdi.loginForm.login(User.ROMAN_IOVLEV);
    }

    public static void shouldBeloggedOut() {
        onSite();
        if (SiteJdi.userName.isDisplayed()) {
            logout();
        }
        if (SiteJdi.loginForm.isDisplayed()) {
            SiteJdi.userIcon.click();
        }
    }

    public static void logout() {
        if (!SiteJdi.logout.isDisplayed()) {
            SiteJdi.userIcon.click();
        }
        SiteJdi.logout.click();
    }
}
