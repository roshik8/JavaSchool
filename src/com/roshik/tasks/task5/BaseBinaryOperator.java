package com.roshik.tasks.task5;

public abstract class BaseBinaryOperator {
    public String symbol;

    BaseBinaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public abstract double operation(double a, double b);
}


