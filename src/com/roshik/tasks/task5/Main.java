package com.roshik.tasks.task5;

public class Main {

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        double result = calculator.calculate("1+3*5-7^3 + 5/2 + sqrt 4");
        System.out.println(result);
    }
}
