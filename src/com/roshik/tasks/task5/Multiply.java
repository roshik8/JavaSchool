package com.roshik.tasks.task5;

public class Multiply extends BaseBinaryOperator {
    public Multiply(){
        super("*");
    }

    @Override
    public double operation(double a, double b)
    {
        return a * b;
    }
}
