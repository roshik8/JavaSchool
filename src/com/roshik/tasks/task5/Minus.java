package com.roshik.tasks.task5;

public class Minus extends BaseBinaryOperator {
    public Minus(){
        super("-");
    }

    @Override
    public double operation(double a, double b)
    {
        return a - b;
    }
}
