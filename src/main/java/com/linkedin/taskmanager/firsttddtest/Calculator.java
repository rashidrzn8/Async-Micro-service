package com.linkedin.taskmanager.firsttddtest;

public class Calculator {

   public double devide(double a , double b){
        if (b == 0){
            throw new ArithmeticException();
        }

        return a/b;
    }
}
