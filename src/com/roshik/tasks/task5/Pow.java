package com.roshik.tasks.task5;

public class Pow extends BaseBinaryOperator {
    public Pow(){
        super("^");
    }

    @Override
    public double operation(double a, double b)
    {
        return Math.pow(a,b);
    }
}
