package ru.training.at.hw8api.main.core;

import static org.hamcrest.Matchers.lessThan;
import static ru.training.at.hw8api.main.constants.ParametersName.DESCRIPTION;
import static ru.training.at.hw8api.main.constants.ParametersName.KEY;
import static ru.training.at.hw8api.main.constants.ParametersName.LABELNAMES_GREEN;
import static ru.training.at.hw8api.main.constants.ParametersName.LABELNAMES_YELLOW;
import static ru.training.at.hw8api.main.constants.ParametersName.NAME;
import static ru.training.at.hw8api.main.constants.ParametersName.PREFS_BACKGROUND;
import static ru.training.at.hw8api.main.constants.ParametersName.PREFS_BACKGROUND_UPD;
import static ru.training.at.hw8api.main.constants.ParametersName.TOKEN;
import static ru.training.at.hw8api.main.constants.RequiredParameters.API_KEY;
import static ru.training.at.hw8api.main.constants.RequiredParameters.API_TOKEN;
import static ru.training.at.hw8api.main.constants.RequiredParameters.BASE_URL;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
import ru.training.at.hw8api.main.beans.TrelloAnswers;

public class TrelloBoardsServiceObj {
    public static URI TRELLO_BOARDS_URI = URI.create(BASE_URL + "boards/");
    private static long requestNumber = 0L;

    private Map<String, String> parameters;
    private Method requestMethod;

    private TrelloBoardsServiceObj(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {
        private Map<String, String> parametrs = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setToken() {
            parametrs.put("token", API_TOKEN);
            return this;
        }

        public ApiRequestBuilder setKey() {
            parametrs.put("key", API_KEY);
            return this;
        }

        public ApiRequestBuilder setName(String name) {
            parametrs.put(NAME, name);
            return this;
        }

        public ApiRequestBuilder setDescription(String description) {
            parametrs.put(DESCRIPTION, description);
            return this;
        }

        public ApiRequestBuilder setBackground(String background) {
            parametrs.put(PREFS_BACKGROUND, background);
            return this;
        }

        public ApiRequestBuilder setId(String id) {
            TRELLO_BOARDS_URI = URI.create(BASE_URL + "boards/" + id);
            return this;
        }

        public ApiRequestBuilder updateBackground(String background) {
            parametrs.put(PREFS_BACKGROUND_UPD, background);
            return this;
        }

        public ApiRequestBuilder updateLabelNamesGreen(String green) {
            parametrs.put(LABELNAMES_GREEN, green);
            return this;
        }

        public ApiRequestBuilder updateLabelNamesYellow(String yellow) {
            parametrs.put(LABELNAMES_YELLOW, yellow);
            return this;
        }

        public TrelloBoardsServiceObj buildRequest() {
            return new TrelloBoardsServiceObj(parametrs, requestMethod);
        }
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .addQueryParam(KEY, API_KEY)
            .addQueryParam(TOKEN, API_TOKEN)
            .addQueryParam("requestNumber", ++requestNumber)
            .setBaseUri(TRELLO_BOARDS_URI)
            .build();
    }

    public Response sendRequest() {
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParams(parameters)
            .request(requestMethod, TRELLO_BOARDS_URI)
            .prettyPeek();
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_OK)
            .build();
    }

    public static TrelloAnswers getTrelloAnswer(Response response) {
        return new Gson()
            .fromJson(response.asPrettyString(), TrelloAnswers.class);
    }
}
