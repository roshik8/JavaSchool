package com.roshik.tasks.task1;

public class GSM {

String[] ts = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};

int  carCode;
double costFuel;
double consumptionFuel;

    /**
     * Получение наименования типа автомобиля по его коду
     * @param car_code
     * @return
     */
    public String GetCarName(int car_code){
    String carName = "";
     switch (car_code) {
         case 100 : carName = "легковой авто";
                    break;
         case 200 : carName = "грузовой авто";
                    break;
         case 300 : carName = "пассажирский транспорт";
             break;
         case 400 : carName = "тяжелая техника(краны)";
             break;
        }
     return carName;
    }

    /**
     * Получение стоимости топлива для передаваемого типа автомобиля
     * @param car_code
     * @return
     */
    public double GetFuelCost(int car_code) {
    double cost = 0.0;
        switch (car_code) {
            case 100 : cost = 46.10;
                break;
            case 200 : cost = 48.90;
                break;
            case 300 : cost = 47.50;
                break;
            case 400 : cost = 48.90;
                break;
        }
    return cost;
    }

    /**
     * Получение расхода топлива на 100 км по типу автомобиля
     * @param car_code
     * @return
     */
    public double GetConsumption(int car_code) {
        double consumption = 0.0;
        switch (car_code) {
            case 100 : consumption = 12.5;
                break;
            case 200 : consumption = 12.0;
                break;
            case 300 : consumption = 11.5;
                break;
            case 400 : consumption = 20.0;
                break;
        }
        return consumption;
    }



public float GetAllGsm(String[] arr) {
    float sum = 0;



    return sum;
}

}
