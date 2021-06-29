package ru.training.at.hw1.data;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

public class Values {
    @DataProvider(name = "values")
    public static Object[][] dpMethod(Method method) {
        switch (method.getName()) {
            case "divLongValuesTest":
                return new Object[][] {{4L, 2L, 2L}, {10L, 5L, 2L}};
            case "divDoubleValuesTest":
                return new Object[][] {{4.2, 2D, 2.1}, {10.2, 2, 5.1}};
            case "multLongValuesTest":
                return new Object[][] {{2L, 2L, 4L}, {10L, 5L, 50L}};
            case "multDoubleValuesTest":
                return new Object[][] {{2.1, 2D, 4.2}, {5.1, 2D, 10.2}};
            case "subLongValuesTest":
                return new Object[][] {{4L, 2L, 2L}, {10L, 5L, 5L}};
            case "subDoubleValuesTest":
                return new Object[][] {{4.2, 2D, 2.2}, {10.2, 5D, 5.2}};
            case "sumLongValuesTest":
                return new Object[][] {{2L, 2L, 4L}, {10L, 5L, 15L}};
            case "sumDoubleValuesTest":
                return new Object[][] {{2.2, 2D, 4.2}, {10.2, 5D, 15.2}};
            default: return null;
        }
    }
}
