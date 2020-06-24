package com.roshik.tasks.task5;

public class Plus extends BaseBinaryOperator
{
    public Plus(){
        super("+");
    }

    @Override
    public double operation(double a, double b)
    {
        return a + b;
    }
}
