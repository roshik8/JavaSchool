package com.roshik.tasks.task5;

public class Sqrt extends BaseUnaryOperator {
    public Sqrt(){
        super("sqrt");
    }

    @Override
    public double operation(double a)
    {
        return Math.sqrt(a);
    }
}
