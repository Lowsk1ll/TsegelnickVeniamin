package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.data.Values;
import ru.training.at.hw1.groups.Groups;

public class MultOperationTests extends InitCalculator {

    @Test(groups = {Groups.MULTIPLY_AND_DIVIDE}, dataProvider = "values", dataProviderClass = Values.class)
    public void multLongValuesTest(long a, long b, long expectedResult) {
        Assert.assertEquals(calculator.mult(a, b), expectedResult);
    }

    @Test(groups = {Groups.MULTIPLY_AND_DIVIDE}, dataProvider = "values", dataProviderClass = Values.class)
    public void multDoubleValuesTest(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.mult(a, b), expectedResult);
    }
}
