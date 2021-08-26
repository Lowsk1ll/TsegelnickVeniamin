package apihw.core;

import apihw.constants.ParametrExamples;
import io.restassured.http.Method;
import org.testng.annotations.DataProvider;


public class DataProviderForTrello {

    @DataProvider
    public Object[][] createBoardProvider() {
        return new Object[][] {{ParametrExamples.NAME_EXAMPLE}};
    }

    @DataProvider
    public Object[][] createBoardWithDescriptionProvider() {
        return new Object[][] {{ParametrExamples.DESCRIPTION_EXAMPLE}};
    }

    @DataProvider
    public Object[][] createBoardWithBackgroundProvider() {
        return new Object[][] {{ParametrExamples.PREFS_BACKGROUND_EXAMPLE}};
    }
}
