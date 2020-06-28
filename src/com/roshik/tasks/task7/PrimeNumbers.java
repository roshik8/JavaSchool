package com.roshik.tasks.task7;

public abstract class PrimeNumbers implements IPrimeNumbers{

    private int max;

    public PrimeNumbers(int max){
        this.max = max;
    }

    @Override
    public void generate(int max){
        generateWith(max);
    }

    public abstract void generateWith(int max);

}
