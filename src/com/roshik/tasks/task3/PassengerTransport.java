package com.roshik.tasks.task3;

public class PassengerTransport extends BaseCar {

    public int countPassengers;

    public PassengerTransport(int[] parameters){
        super(parameters);
        this.countPassengers = parameters[2];
        fuelCost = 47.50;
        consumption = 11.5;
        carName = "пассажирский транспорт";
    }

    @Override
    public String getCarInfo(){

        return "Тип авто: "+this.carName+", Номер: "+this.gosNumber+
                ", Пробег: "+this.distance +", Доп. параметр: "+countPassengers;
    }
}
