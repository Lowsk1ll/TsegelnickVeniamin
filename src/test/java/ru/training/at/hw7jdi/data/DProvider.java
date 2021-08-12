package ru.training.at.hw7jdi.data;

import org.testng.annotations.DataProvider;

public class DProvider {

    @DataProvider(name = "data-provider")
    public static Object[][] dataProviderMethod() {
        return new Object[][] {{"JDI_ex8_metalsColorsDataSet.json"}};
    }
}
