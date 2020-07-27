package com.roshik.tasks.task4_1;

import java.util.HashMap;

public class Car extends BaseCar {

    public Car(HashMap<Main.carParameter,Integer> parameters){
        super(parameters);
        fuelCost = 46.1;
        consumption = 12.5;
        carName = "легковой авто";
    }

}
