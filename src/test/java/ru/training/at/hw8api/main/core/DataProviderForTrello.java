package ru.training.at.hw8api.main.core;

import static ru.training.at.hw8api.main.core.TrelloBoardsServiceObj.getTrelloAnswer;
import static ru.training.at.hw8api.main.core.TrelloBoardsServiceObj.requestBuilder;

import io.restassured.http.Method;
import org.testng.annotations.DataProvider;
import ru.training.at.hw8api.main.constants.ParametrExamples;

public class DataProviderForTrello {

    @DataProvider
    public Object[][] createBoardProvider() {
        return new Object[][] {{ParametrExamples.NAME_EXAMPLE}};
    }

    @DataProvider
    public Object[][] createBoardWithDescriptionProvider() {
        return new Object[][] {{ParametrExamples.NAME_EXAMPLE + "1", ParametrExamples.DESCRIPTION_EXAMPLE}};
    }

    @DataProvider
    public Object[][] createBoardWithBackgroundProvider() {
        return new Object[][] {{ParametrExamples.NAME_EXAMPLE + "2", ParametrExamples.PREFS_BACKGROUND_EXAMPLE}};
    }

    @DataProvider
    public Object[][] deleteBoardDataProvider() {
        return new Object[][] {{getTrelloAnswer(requestBuilder()
            .setName("Table for delete")
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest()).getId()}};
    }

    @DataProvider
    public Object[][] getBoardDataProvider() {
        return new Object[][] {{getTrelloAnswer(requestBuilder()
            .setName("Table for get")
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest()).getId()}};
    }

    @DataProvider
    Object[][] updateBoardDataProvider() {
        return new Object[][] {{getTrelloAnswer(requestBuilder()
            .setName("Table for update")
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest()).getId()}};
    }
}
