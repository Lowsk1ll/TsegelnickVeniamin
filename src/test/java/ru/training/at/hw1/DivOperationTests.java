package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.data.Values;
import ru.training.at.hw1.groups.Groups;

public class DivOperationTests {

    @Test(groups = {Groups.MULTIPLY_AND_DIVIDE}, dataProvider = "values", dataProviderClass = Values.class)
    public void divLongValuesTest(long a, long b, long expectedResult) {
        Assert.assertEquals(InitCalculator.calculator.div(a, b), expectedResult);
    }

    @Test(groups = {Groups.MULTIPLY_AND_DIVIDE}, dataProvider = "values", dataProviderClass = Values.class)
    public void divDoubleValuesTest(double a, double b, double expectedResult) {
        Assert.assertEquals(InitCalculator.calculator.div(a, b), expectedResult);
    }
}
