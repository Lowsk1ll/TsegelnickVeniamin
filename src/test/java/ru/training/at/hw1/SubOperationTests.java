package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.data.Values;
import ru.training.at.hw1.groups.Groups;

public class SubOperationTests extends InitCalculator {

    @Test(groups = {Groups.ADD_AND_SUBTRACT}, dataProvider = "values", dataProviderClass = Values.class)
    public void subLongValuesTest(long a, long b, long expectedResult) {
        Assert.assertEquals(calculator.sub(a, b), expectedResult);
    }

    @Test(groups = {Groups.ADD_AND_SUBTRACT}, dataProvider = "values", dataProviderClass = Values.class)
    public void subDoubleValuesTest(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.sub(a, b), expectedResult);
    }
}
