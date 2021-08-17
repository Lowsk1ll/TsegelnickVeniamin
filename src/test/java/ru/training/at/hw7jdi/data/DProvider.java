package ru.training.at.hw7jdi.data;

import static ru.training.at.hw7jdi.data.TestData.*;

import org.testng.annotations.DataProvider;

public class DProvider {

    @DataProvider(name = "data-provider")
    public static Object[][] dataProviderMethod() {
        return new Object[][] {{metalsColorsData}};
    }
}
