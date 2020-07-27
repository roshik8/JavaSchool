package com.roshik.tasks.task4_1;

import java.util.HashMap;

public class HeavyEquipment extends BaseCar {
public int weightCargo;
    public HeavyEquipment(HashMap<Main.carParameter,Integer> parameters){
        super(parameters);
        this.weightCargo = parameters.get(Main.carParameter.additional);
        fuelCost = 48.90;
        consumption = 20.0;
        carName = "тяжелая техника(краны)";
    }

    @Override
    public String getCarInfo(){

        return super.getCarInfo()+", Доп. параметр: "+weightCargo;
    }
}
