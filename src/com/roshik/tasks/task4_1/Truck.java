package com.roshik.tasks.task4_1;

import java.util.HashMap;

public class Truck extends BaseCar {
    public int volumeGoods;

    public Truck(HashMap<Main.carParameter,Integer> parameters){
        super(parameters);
        this.volumeGoods = parameters.get(Main.carParameter.additional);
        fuelCost = 48.90;
        consumption = 12.0;
        carName = "грузовой авто";
    }

    @Override
    public String getCarInfo(){

        return super.getCarInfo() +", Доп. параметр: "+volumeGoods;
    }
}
