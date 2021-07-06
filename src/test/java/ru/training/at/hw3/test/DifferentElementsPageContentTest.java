package ru.training.at.hw3.test;

import org.testng.annotations.Test;
import ru.training.at.hw3.data.Values;
import ru.training.at.hw3.main.differentelementspage.DifferentElementsPage;
import ru.training.at.hw3.main.homepage.HomePage;

public class DifferentElementsPageContentTest extends TestsInitialization {

    @Test(dataProvider = "values", dataProviderClass = Values.class)
    public void secondExerciseTest(String expectedTitle, String userName, String password, String expectedUserName) {
        HomePage homePage = new HomePage(driver, wait);
        homePage.checkBrowserTitle(expectedTitle);
        homePage.loginUser(userName, password);
        homePage.checkUsername(expectedUserName);
        homePage.openDifferentElementsPage();
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver, wait);
        differentElementsPage.selectElements();
        differentElementsPage.checkSelectedElementsAndLogRows();
    }
}
