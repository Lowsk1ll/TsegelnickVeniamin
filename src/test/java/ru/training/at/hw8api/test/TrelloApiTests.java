package ru.training.at.hw8api.test;

import static apihw.constants.ParametrExamples.DESCRIPTION_EXAMPLE;
import static apihw.constants.ParametrExamples.GREEN_NAME_EXAMPLE;
import static apihw.constants.ParametrExamples.NAME_EXAMPLE;
import static apihw.constants.ParametrExamples.PREFS_BACKGROUND_EXAMPLE;
import static apihw.constants.ParametrExamples.UPDATED_NAME;
import static apihw.constants.ParametrExamples.YELLOW_NAME_EXAMPLE;
import static apihw.core.TrelloBoardsServiceObj.getTrelloAnswer;
import static apihw.core.TrelloBoardsServiceObj.goodResponseSpecification;
import static apihw.core.TrelloBoardsServiceObj.requestBuilder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import apihw.beans.TrelloAnswers;
import apihw.constants.ParametersName;
import apihw.core.DataProviderForTrello;
import io.restassured.http.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrelloApiTests {
    public static String boardId;
    public TrelloAnswers result;

    @BeforeMethod(onlyForGroups = {"delete", "update", "get"})
    public void initialize() {
        result = getTrelloAnswer(requestBuilder()
            .setName(NAME_EXAMPLE)
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequestForCreate());
        boardId = result.getId();
    }

    @Test(groups = {"create"}, dataProvider = "createBoardProvider", dataProviderClass = DataProviderForTrello.class)
    public void createTable(String name) {
        result = getTrelloAnswer(requestBuilder()
            .setName(NAME_EXAMPLE)
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequestForCreate());
        boardId = result.getId();
        assertThat("Api create table with name: " + name, result, hasProperty(ParametersName.NAME, is(name)));
    }

    @Test(groups = {"create"},
          dataProvider = "createBoardWithDescriptionProvider",
          dataProviderClass = DataProviderForTrello.class)
    public void createTableWithDescription(String description) {
        result = getTrelloAnswer(requestBuilder()
            .setName(NAME_EXAMPLE)
            .setDescription(DESCRIPTION_EXAMPLE)
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequestForCreate());
        boardId = result.getId();
        assertThat("Api create table with description: " + description, result,
            hasProperty(ParametersName.DESCRIPTION, is(description)));
    }

    @Test(groups = {"create"},
          dataProvider = "createBoardWithBackgroundProvider",
          dataProviderClass = DataProviderForTrello.class)
    public void createTableWithBackground(String background) {
        result = getTrelloAnswer(requestBuilder()
            .setName(NAME_EXAMPLE)
            .setBackground(PREFS_BACKGROUND_EXAMPLE)
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequestForCreate());
        boardId = result.getId();
        assertThat("Api create table with background " + background, result.getPrefs(),
            hasProperty(ParametersName.BACKGROUND, is(background)));
    }

    @Test(groups = {"delete"})
    public void deleteTableWithId() {
        requestBuilder()
            .setId(boardId)
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendRequest()
            .then().assertThat()
            .spec(goodResponseSpecification());
    }

    @Test(groups = {"get"})
    public void getTableWithId() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(boardId)
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest());
        assertThat("Api get table with id: " + boardId, result,
            hasProperty(ParametersName.ID, is(boardId)));
    }

    @Test(groups = {"update"})
    public void updateTableName() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(boardId)
            .setName(UPDATED_NAME)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest());
        assertThat("Api update table name with id: " + boardId, result,
            hasProperty(ParametersName.NAME, is(UPDATED_NAME)));
    }

    @Test(groups = {"update"})
    public void updateTableDesc() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(boardId)
            .setDescription(DESCRIPTION_EXAMPLE)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest());
        assertThat("Api update table description with id: " + boardId, result,
            hasProperty(ParametersName.DESCRIPTION, is(DESCRIPTION_EXAMPLE)));
    }

    @Test(groups = {"update"})
    public void updateTableBackground() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(boardId)
            .updateBackground(PREFS_BACKGROUND_EXAMPLE)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest());
        assertThat("Api update table background with id: " + boardId, result.getPrefs(),
            hasProperty(ParametersName.BACKGROUND, is(PREFS_BACKGROUND_EXAMPLE)));
    }

    @Test(groups = {"update"})
    public void updateLabelNamesGreen() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(boardId)
            .updateLabelNamesGreen(GREEN_NAME_EXAMPLE)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest());
        assertThat("Api update table label name green with id: " + boardId, result.getLabelNames(),
            hasProperty(ParametersName.GREEN, is(GREEN_NAME_EXAMPLE)));
    }

    @Test(groups = {"update"})
    public void updateLabelNamesYellow() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(boardId)
            .updateLabelNamesYellow(YELLOW_NAME_EXAMPLE)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest());
        assertThat("Api update table label name yellow with id: " + boardId, result.getLabelNames(),
            hasProperty(ParametersName.YELLOW, is(YELLOW_NAME_EXAMPLE)));
    }

    @AfterMethod(onlyForGroups = {"create", "update", "get"})
    public void tearDownTests() {
        requestBuilder()
            .setId(boardId)
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendRequest();
    }
}
