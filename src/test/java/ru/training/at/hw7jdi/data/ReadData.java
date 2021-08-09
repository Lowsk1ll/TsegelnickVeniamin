package ru.training.at.hw7jdi.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import ru.training.at.hw7jdi.entities.MetalsColorsData;

public class ReadData {

    public static MetalsColorsData readJsonForMetalsColors(int numberOfData) {
        MetalsColorsData result = new MetalsColorsData();
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json");
            JsonObject data = gson.fromJson(reader, JsonObject.class);
            result = gson.fromJson(data.getAsJsonObject("data_" + numberOfData), MetalsColorsData.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
