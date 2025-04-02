package com.linkedin.taskmanager.firsttddtest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {
    @Test
    void devideTwoPositiveNumbers(){

        //arrange
        Calculator calculator = new Calculator();

        //act
        double result = calculator.devide(6,3);

        //asserts
        assertEquals(2.0,result);
    }
}
