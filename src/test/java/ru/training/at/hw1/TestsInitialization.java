package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;

public class TestsInitialization {

    protected Calculator calculator;

    @BeforeClass
    public void init() {
        this.calculator = new Calculator();
    }
}
