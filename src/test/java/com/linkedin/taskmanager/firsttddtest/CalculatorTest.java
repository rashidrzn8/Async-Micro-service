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

    @Test
    void testDevideByTwo(){
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class,()->calculator.devide(5,0));
    }

    @Test
    void testDevideByMinusNumber(){
        Calculator calculator=new Calculator();
        double res = calculator.devide(-6,-2);
        assertEquals(3.0,res);
    }
}
