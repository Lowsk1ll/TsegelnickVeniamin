package ru.training.at.hw8api.test;

import static apihw.constants.ParameterExamples.DESCRIPTION_EXAMPLE;
import static apihw.constants.ParameterExamples.GREEN_NAME_EXAMPLE;
import static apihw.constants.ParameterExamples.NAME_EXAMPLE;
import static apihw.constants.ParameterExamples.PREFS_BACKGROUND_EXAMPLE;
import static apihw.constants.ParameterExamples.UPDATED_NAME;
import static apihw.constants.ParameterExamples.YELLOW_NAME_EXAMPLE;
import static apihw.core.TrelloBoardsServiceObj.getTrelloAnswer;
import static apihw.core.TrelloBoardsServiceObj.goodResponseSpecification;
import static apihw.core.TrelloBoardsServiceObj.requestBuilder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
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
    public void createBoard(String name) {
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
    public void createBoardWithDescription(String description) {
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
    public void createBoardWithBackground(String background) {
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
    public void deleteBoardWithId() {
        requestBuilder()
            .setId(boardId)
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendRequest()
            .then().assertThat()
            .spec(goodResponseSpecification());
    }

    @Test(groups = {"get"})
    public void getBoardWithId() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(boardId)
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest());
        assertThat("Api get table with id: " + boardId, result,
            hasProperty(ParametersName.ID, is(boardId)));
    }

    @Test(groups = {"update"})
    public void updateBoardName() {
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
    public void updateBoardDesc() {
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
    public void updateBoardBackground() {
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
            .updateLabelNamesYellow(YELLOW_NAME_EXAMPLE)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest());
        assertThat("Api update board label name green with id: " + boardId, result.getLabelNames(), allOf(
            hasProperty(ParametersName.GREEN, is(GREEN_NAME_EXAMPLE)),
            hasProperty(ParametersName.YELLOW, is(YELLOW_NAME_EXAMPLE))));
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
