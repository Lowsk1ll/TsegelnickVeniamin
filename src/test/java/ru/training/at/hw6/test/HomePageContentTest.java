package ru.training.at.hw6.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw6.data.Values;

public class HomePageContentTest extends TestsInitialization {


    @Feature("Checking allure annotations")
    @Story("first exercise from 2-3 hw")
    @Test(dataProvider = "values", dataProviderClass = Values.class)
    public void firstExerciseTest(String expectedTitle, String userName, String password, String expectedUserName) {

        //Check browser title
        assertionStep.checkBrowserTitle(expectedTitle);

        //Login user
        actionStep.loginUser(userName, password);

        //check username
        assertionStep.checkUserName(expectedUserName);

        //check header menu elements
        assertionStep.checkHeaderMenuElements();

        //check images
        assertionStep.checkImages();

        //check text under images
        assertionStep.checkTextUnderImages();

        //chek frame elements
        assertionStep.checkFrameElements();

        //check left menu elements
        assertionStep.checkLeftMenuElements();
    }
}
