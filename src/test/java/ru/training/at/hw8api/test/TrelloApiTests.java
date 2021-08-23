package ru.training.at.hw8api.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static ru.training.at.hw8api.main.core.TrelloBoardsServiceObj.getTrelloAnswer;
import static ru.training.at.hw8api.main.core.TrelloBoardsServiceObj.goodResponseSpecification;
import static ru.training.at.hw8api.main.core.TrelloBoardsServiceObj.requestBuilder;

import io.restassured.http.Method;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw8api.main.beans.TrelloAnswers;
import ru.training.at.hw8api.main.constants.ParametersName;
import ru.training.at.hw8api.main.constants.ParametrExamples;
import ru.training.at.hw8api.main.core.DataProviderForTrello;

public class TrelloApiTests {

    @Test(dataProvider = "createBoardProvider", dataProviderClass = DataProviderForTrello.class)
    public void createTable(String name) {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setName(name)
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest());
        assertThat("Api create table with name: " + name, result, hasProperty(ParametersName.NAME, is(name)));
    }

    @Test(dataProvider = "createBoardWithDescriptionProvider", dataProviderClass = DataProviderForTrello.class)
    public void createTableWithDescription(String name, String description) {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setName(name)
            .setDescription(description)
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest());
        assertThat("Api create table with description: " + description, result,
            hasProperty(ParametersName.DESCRIPTION, is(description)));
    }

    @Test(dataProvider = "createBoardWithBackgroundProvider", dataProviderClass = DataProviderForTrello.class)
    public void createTableWithBackground(String name, String background) {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setName(name)
            .setBackground(background)
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest());
        assertThat("Api create table with background " + background, result.getPrefs(),
            hasProperty(ParametersName.BACKGROUND, is(background)));
    }

    @Test(dataProvider = "deleteBoardDataProvider", dataProviderClass = DataProviderForTrello.class)
    public void deleteTableWithId(String id) {
        requestBuilder()
            .setId(id)
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendRequest()
            .then().assertThat()
            .spec(goodResponseSpecification());
    }

    @Test(dataProvider = "getBoardDataProvider", dataProviderClass = DataProviderForTrello.class, alwaysRun = true)
    public void getTableWithId(String id) {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(id)
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest());
        assertThat("Api get table with id: " + id, result,
            hasProperty(ParametersName.ID, is(id)));
    }

    @BeforeClass(alwaysRun = true)
    public void createTableForUpdate() {
        ParametrExamples.ID = getTrelloAnswer(requestBuilder()
            .setName("Table for update")
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest()).getId();
    }

    @Test
    public void updateTableName() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(ParametrExamples.ID)
            .setName(ParametrExamples.UPDATED_NAME)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest());
        assertThat("Api update table name with id: " + ParametrExamples.ID, result,
            hasProperty(ParametersName.NAME, is(ParametrExamples.UPDATED_NAME)));
    }

    @Test
    public void updateTableDesc() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(ParametrExamples.ID)
            .setDescription(ParametrExamples.DESCRIPTION_EXAMPLE)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest());
        assertThat("Api update table description with id: " + ParametrExamples.ID, result,
            hasProperty(ParametersName.DESCRIPTION, is(ParametrExamples.DESCRIPTION_EXAMPLE)));
    }

    @Test
    public void updateTableBackground() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(ParametrExamples.ID)
            .updateBackground(ParametrExamples.PREFS_BACKGROUND_EXAMPLE)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest());
        assertThat("Api update table background with id: " + ParametrExamples.ID, result.getPrefs(),
            hasProperty(ParametersName.BACKGROUND, is(ParametrExamples.PREFS_BACKGROUND_EXAMPLE)));
    }

    @Test
    public void updateLabelNamesGreen() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(ParametrExamples.ID)
            .updateLabelNamesGreen(ParametrExamples.GREEN_NAME_EXAMPLE)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest());
        assertThat("Api update table label name green with id: " + ParametrExamples.ID, result.getLabelNames(),
            hasProperty(ParametersName.GREEN, is(ParametrExamples.GREEN_NAME_EXAMPLE)));
    }

    @Test
    public void updateLabelNamesYellow() {
        TrelloAnswers result = getTrelloAnswer(requestBuilder()
            .setId(ParametrExamples.ID)
            .updateLabelNamesYellow(ParametrExamples.YELLOW_NAME_EXAMPLE)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest());
        assertThat("Api update table label name yellow with id: " + ParametrExamples.ID, result.getLabelNames(),
            hasProperty(ParametersName.YELLOW, is(ParametrExamples.YELLOW_NAME_EXAMPLE)));
    }

    @AfterClass(alwaysRun = true)
    public void deleteTableForUpdate() {
        requestBuilder()
            .setId(ParametrExamples.ID)
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendRequest();

        ParametrExamples.ID = "";

    }
}
