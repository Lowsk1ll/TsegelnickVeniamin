package ru.training.at.hw7jdi.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import ru.training.at.hw7jdi.entities.MetalsColorsData;

public class ReadData {

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
