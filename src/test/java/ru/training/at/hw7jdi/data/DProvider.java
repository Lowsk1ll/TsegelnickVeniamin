package ru.training.at.hw7jdi.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;
import ru.training.at.hw7jdi.entities.MetalsColorsData;

public class DProvider {

    @DataProvider(name = "data-provider")
    public static Object[][] dataProviderMethod() {
        return readJsonForMetalsColors("JDI_ex8_metalsColorsDataSet.json")
            .stream()
            .map(data -> new MetalsColorsData[] {data})
            .toArray(Object[][]::new);
    }

    public static List<MetalsColorsData> readJsonForMetalsColors(String file) {
        List<MetalsColorsData> result = new ArrayList<>();
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/test/resources/" + file);
            JsonObject data = gson.fromJson(reader, JsonObject.class);
            data.keySet()
                .forEach(s -> result.add(gson.fromJson(data.getAsJsonObject(s), MetalsColorsData.class)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
