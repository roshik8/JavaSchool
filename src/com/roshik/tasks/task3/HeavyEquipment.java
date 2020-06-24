package com.roshik.tasks.task3;

public class HeavyEquipment extends BaseCar{
public int weightCargo;
    public HeavyEquipment(int[] parameters){
        super(parameters);
        this.weightCargo = parameters[2];
        fuelCost = 48.90;
        consumption = 20.0;
        carName = "тяжелая техника(краны)";
    }

    @Override
    public String getCarInfo(){

        return super.getCarInfo()+", Доп. параметр: "+weightCargo;
    }
}
