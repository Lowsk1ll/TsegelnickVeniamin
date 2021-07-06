package ru.training.at.hw3.data;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

public class Values {
    @DataProvider(name = "values")
    public static Object[][] dpMethod(Method method) {
        return new Object[][] {{"Home Page", "Roman", "Jdi1234", "ROMAN IOVLEV"}};
    }
}
