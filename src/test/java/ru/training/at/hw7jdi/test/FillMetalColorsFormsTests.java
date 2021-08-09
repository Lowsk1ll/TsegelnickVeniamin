package ru.training.at.hw7jdi.test;


import org.testng.annotations.Test;
import ru.training.at.hw7jdi.entities.User;
import ru.training.at.hw7jdi.site.SiteJdi;
import ru.training.at.hw7jdi.site.sections.MetalsColorForm;
import ru.training.at.hw7jdi.states.States;

public class FillMetalColorsFormsTests implements InitTest {

    @Test
    public void loginTest() {
        States.shouldBeloggedOut();
        SiteJdi.userIcon.click();
        SiteJdi.loginForm.login(User.ROMAN_IOVLEV);
        SiteJdi.userName.is().text(User.ROMAN_IOVLEV.getFullName());
        SiteJdi.homePage.checkOpened();
    }

    @Test
    public void openMetalsColorsPage() {
        States.shouldBeLoggedIn();
        SiteJdi.metalsColors.click();
        SiteJdi.metalsColorsPage.checkOpened();
    }

    @Test
    public void fillAndCheckMetalColorsForms() {
        States.shouldBeLoggedIn();
        SiteJdi.metalsColorsPage.shouldBeOpened();
        MetalsColorForm.fillByData(5);
        SiteJdi.metalsColorsPage.submit.click();
        MetalsColorForm.checkByData(5);
    }
}
