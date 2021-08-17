package ru.training.at.hw7jdi.test;

import java.util.List;
import org.testng.annotations.Test;
import ru.training.at.hw7jdi.data.DProvider;
import ru.training.at.hw7jdi.entities.MetalsColorsData;
import ru.training.at.hw7jdi.entities.User;
import ru.training.at.hw7jdi.site.SiteJdi;
import ru.training.at.hw7jdi.site.sections.metalcolors.MetalsColorForm;
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

    @Test(dataProvider = "data-provider", dataProviderClass = DProvider.class)
    public void fillAndCheckMetalColorsForms(List<MetalsColorsData> data) {
        States.shouldBeLoggedIn();
        SiteJdi.metalsColorsPage.shouldBeOpened();
        MetalsColorForm.fillAndCheckByData(data);
    }
}
