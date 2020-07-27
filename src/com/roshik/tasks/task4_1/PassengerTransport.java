package com.roshik.tasks.task4_1;


import java.util.HashMap;

public class PassengerTransport extends BaseCar {

    public int countPassengers;

    public PassengerTransport(HashMap<Main.carParameter,Integer> parameters){
        super(parameters);
        this.countPassengers = parameters.get(Main.carParameter.additional);
        fuelCost = 47.50;
        consumption = 11.5;
        carName = "пассажирский транспорт";
    }

    @Override
    public String getCarInfo(){

        return super.getCarInfo() +", Доп. параметр: "+countPassengers;
    }

}
