package com.roshik.tasks.task3;

public class Truck extends BaseCar {
    public int volumeGoods;

    public Truck(int[] parameters){
        super(parameters);
        this.volumeGoods = parameters[2];
        fuelCost = 48.90;
        consumption = 12.0;
        carName = "грузовой авто";
    }

    @Override
    public String getCarInfo(){

        return super.getCarInfo() +", Доп. параметр: "+volumeGoods;
    }
}
