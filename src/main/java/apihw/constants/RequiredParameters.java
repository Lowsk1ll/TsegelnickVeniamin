package apihw.constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RequiredParameters {
    public static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/test/resources/test.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        API_KEY = properties.getProperty("key");
        API_TOKEN = properties.getProperty("token");

    }


    public static final String BASE_URL = "https://api.trello.com/1/";
    public static final String API_KEY;
    public static final String API_TOKEN;
}
