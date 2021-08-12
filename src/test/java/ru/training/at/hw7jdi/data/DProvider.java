package ru.training.at.hw7jdi.data;

import org.testng.annotations.DataProvider;

public class DProvider {

    @DataProvider(name = "data-provider")
    public static Object[][] dataProviderMethod() {
        return new Object[][] {{"JDI_ex8_metalsColorsDataSet.json", 1},
            {"JDI_ex8_metalsColorsDataSet.json", 2},
            {"JDI_ex8_metalsColorsDataSet.json", 3},
            {"JDI_ex8_metalsColorsDataSet.json", 4},
            {"JDI_ex8_metalsColorsDataSet.json", 5}};
    }
}
