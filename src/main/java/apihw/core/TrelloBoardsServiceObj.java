package apihw.core;

import static apihw.constants.ParametersName.DESCRIPTION;
import static apihw.constants.ParametersName.KEY;
import static apihw.constants.ParametersName.LABELNAMES_GREEN;
import static apihw.constants.ParametersName.LABELNAMES_YELLOW;
import static apihw.constants.ParametersName.NAME;
import static apihw.constants.ParametersName.PREFS_BACKGROUND;
import static apihw.constants.ParametersName.PREFS_BACKGROUND_UPD;
import static apihw.constants.ParametersName.TOKEN;
import static apihw.constants.RequiredParameters.API_KEY;
import static apihw.constants.RequiredParameters.API_TOKEN;
import static apihw.constants.RequiredParameters.BASE_URL;
import static org.hamcrest.Matchers.lessThan;

import apihw.beans.TrelloAnswers;
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

public class TrelloBoardsServiceObj {
    public static URI trelloBoardUri = URI.create(BASE_URL + "boards/");
    public static final URI baseTrelloBoardUri = URI.create(BASE_URL + "boards/");
    private static long requestNumber = 0L;

    private Map<String, String> parameters;
    private Method requestMethod;

    public TrelloBoardsServiceObj() {
    }

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
            trelloBoardUri = URI.create(BASE_URL + "boards/" + id);
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

        public URI getTrelloURI() {
            return URI.create(BASE_URL + "boards/");
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
            .build();
    }

    public Response sendRequest() {
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParams(parameters)
            .request(requestMethod, trelloBoardUri)
            .prettyPeek();
    }

    public Response sendRequestForCreate() {
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParams(parameters)
            .request(requestMethod, baseTrelloBoardUri)
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
