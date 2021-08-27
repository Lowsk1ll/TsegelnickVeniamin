package apihw.constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RequiredParameters {
    public static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream locator = new FileInputStream("src/test/resources/testapi.properties");
            properties.load(locator);
            locator.close();
        } catch (IOException e) {
            try {
                throw new IOException("Wrong filename");
            } catch (IOException ioException) {
                System.exit(1);
            }
        }
        API_KEY = properties.getProperty("key");
        API_TOKEN = properties.getProperty("token");
    }

    public static final String BASE_URL = "https://api.trello.com/1/";
    public static final String API_KEY;
    public static final String API_TOKEN;
}
