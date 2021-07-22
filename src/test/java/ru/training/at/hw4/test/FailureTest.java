package ru.training.at.hw4.test;

import java.util.List;
import org.testng.annotations.Test;
import ru.training.at.hw4.data.Values;


public class FailureTest extends TestsInitialization {
    @Test(dataProvider = "values", dataProviderClass = Values.class)
    public void firstFailureTest(String expectedTitle, String userName, String password, String expectedUserName,
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
