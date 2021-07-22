package ru.training.at.hw4.data;

import java.lang.reflect.Method;
import java.util.List;
import org.testng.annotations.DataProvider;

public class Values {

    public static final String TEXT_UNDER_FIRST_IMAGE = "To include good practices\n"
        + "and ideas from successful\n"
        + "EPAM project";
    public static final String TEXT_UNDER_SECOND_IMAGE = "To be flexible and\n"
        + "customizable";
    public static final String TEXT_UNDER_THIRD_IMAGE = "To be multiplatform";
    public static final String TEXT_UNDER_FOURTH_IMAGE = "Already have good base\n"
        + "(about 20 internal and\n"
        + "some external projects),\n"
        + "wish to get more…";

    @DataProvider(name = "values")
    public static Object[][] dpMethod(Method method) {
        switch (method.getName()) {
            case "firstExerciseTest":
                return new Object[][] {
                    {"Home Page", "Roman", "Jdi1234", "ROMAN IOVLEV"}};
            case "secondExerciseTest":
                return new Object[][] {
                    {"Home Page", "Roman", "Jdi1234", "ROMAN IOVLEV", List.of("Water", "Wind", "Selen", "Yellow")}};
            case "firstFailureTest":
                return new Object[][] {
                    {"Home Page", "Roman", "Jdi1234", "ROMAN IOVLEVbcv", List.of("Water", "Wind", "Selen", "Yellow")}};
            default:
                return null;
        }
    }
}
