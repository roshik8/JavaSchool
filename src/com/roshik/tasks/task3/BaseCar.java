package com.roshik.tasks.task3;

public abstract class BaseCar {

    protected int carCode;
    protected String carName;
    protected int gosNumber;
    protected int distance;
    protected double fuelCost;
    protected double consumption;

    public BaseCar(int[] parameters){
        this.gosNumber = parameters[0];
        this.distance = parameters[1];
    }

    public String getCarInfo(){

        return "Тип авто: "+this.carName+", Номер: "+this.gosNumber+
                ", Пробег: "+this.distance;
    }

    public double getSumCostGsm() {
        return (this.fuelCost* this.consumption * this.distance) / 100;
    }
}
