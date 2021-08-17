package ru.training.at.hw7jdi.data;

import java.util.List;
import ru.training.at.hw7jdi.entities.MetalsColorsData;

public class TestData {
    public static List<MetalsColorsData> metalsColorsData =
        ReadData.readJsonForMetalsColors("JDI_ex8_metalsColorsDataSet.json");
}
