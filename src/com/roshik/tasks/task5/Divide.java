package com.roshik.tasks.task5;

public class Divide extends BaseBinaryOperator {
    public Divide(){
        super("/");
    }

    @Override
    public double operation(double a, double b)
    {
        return a / b;
    }
}
