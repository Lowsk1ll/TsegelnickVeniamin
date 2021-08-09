package ru.training.at.hw6.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Test;
import ru.training.at.hw6.data.Values;

public class DifferentElementsPageContentTest extends TestsInitialization {


    @Feature("Checking allure annotations")
    @Story("first exercise from 2-3 hw")
    @Test(dataProvider = "values", dataProviderClass = Values.class)
    public void secondExerciseTest(String expectedTitle, String userName, String password, String expectedUserName,
                                   List<String> expectedCheckboxAndRadioElements) {

        //Check browser title
        assertionStep.checkBrowserTitle(expectedTitle);

        //login user
        actionStep.loginUser(userName, password);

        //check username
        assertionStep.checkUserName(expectedUserName);

        //open different elements page
        actionStep.openDifferentElementsPage();

        //select elements
        actionStep.selectDifferentElements();

        //check log list
        assertionStep.checkLogList(expectedCheckboxAndRadioElements);

        //check checkbox and radio elements are selected
        assertionStep.checkSelectedElements();

        //check dropdownmenu are selected
        assertionStep.checkDropDownMenu();
    }
}
