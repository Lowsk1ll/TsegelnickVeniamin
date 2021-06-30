package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.data.Values;
import ru.training.at.hw1.groups.Groups;

public class SumOperationTests extends InitCalculator {

    @Test(groups = {Groups.ADD_AND_SUBTRACT}, dataProvider = "values", dataProviderClass = Values.class)
    public void sumLongValuesTest(long a, long b, long expectedResult) {
        Assert.assertEquals(calculator.sum(a, b), expectedResult);
    }

    @Test(groups = {Groups.ADD_AND_SUBTRACT}, dataProvider = "values", dataProviderClass = Values.class)
    public void sumDoubleValuesTest(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.sum(a, b), expectedResult);
    }
}
