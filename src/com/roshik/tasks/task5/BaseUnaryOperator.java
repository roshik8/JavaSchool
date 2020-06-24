package com.roshik.tasks.task5;

public abstract class BaseUnaryOperator {
    public String symbol;

    BaseUnaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public abstract double operation(double a);
}
