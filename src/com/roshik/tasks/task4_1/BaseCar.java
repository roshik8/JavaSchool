package com.roshik.tasks.task4_1;

import java.util.HashMap;

public abstract class BaseCar implements ISumCostGsm {

    protected String carName;
    protected int gosNumber;
    protected int distance;
    protected double fuelCost;
    protected double consumption;

    public BaseCar(HashMap<Main.carParameter,Integer> parameters){
        this.gosNumber = parameters.get(Main.carParameter.gosNumber);
        this.distance = parameters.get(Main.carParameter.distance);
    }

    public String getCarInfo(){

        return "Тип авто: "+this.carName+", Номер: "+this.gosNumber+
                ", Пробег: "+this.distance;
    }

    public double getSumCostGsm() {
        return (this.fuelCost* this.consumption * this.distance) / 100;
    }
}
