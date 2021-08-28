package apihw.core;

import apihw.constants.ParameterExamples;
import org.testng.annotations.DataProvider;


public class DataProviderForTrello {

    @DataProvider
    public Object[][] createBoardProvider() {
        return new Object[][] {{ParameterExamples.NAME_EXAMPLE}};
    }

    @DataProvider
    public Object[][] createBoardWithDescriptionProvider() {
        return new Object[][] {{ParameterExamples.DESCRIPTION_EXAMPLE}};
    }

    @DataProvider
    public Object[][] createBoardWithBackgroundProvider() {
        return new Object[][] {{ParameterExamples.PREFS_BACKGROUND_EXAMPLE}};
    }
}
