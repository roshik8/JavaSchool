package com.roshik.tasks.task1;

public class GSM {

    public static String[] ts = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};

    int carCode;
    double costFuel;
    double consumptionFuel;

    /**
     * Получение наименования типа автомобиля по его коду
     *
     * @param car_code
     * @return
     */
    public static String GetCarName(int car_code) {
        String carName = "";
        switch (car_code) {
            case 100:
                carName = "легковой авто";
                break;
            case 200:
                carName = "грузовой авто";
                break;
            case 300:
                carName = "пассажирский транспорт";
                break;
            case 400:
                carName = "тяжелая техника(краны)";
                break;
        }
        return carName;
    }

    /**
     * Получение стоимости топлива для передаваемого типа автомобиля
     *
     * @param car_code
     * @return
     */
    public static double GetFuelCost(int car_code) {
        double cost = 0.0;
        switch (car_code) {
            case 100:
                cost = 46.10;
                break;
            case 200:
                cost = 48.90;
                break;
            case 300:
                cost = 47.50;
                break;
            case 400:
                cost = 48.90;
                break;
        }
        return cost;
    }

    /**
     * Получение расхода топлива на 100 км по типу автомобиля
     *
     * @param car_code
     * @return
     */
    public static double GetConsumption(int car_code) {
        double consumption = 0.0;
        switch (car_code) {
            case 100:
                consumption = 12.5;
                break;
            case 200:
                consumption = 12.0;
                break;
            case 300:
                consumption = 11.5;
                break;
            case 400:
                consumption = 20.0;
                break;
        }
        return consumption;
    }

    public static int[] GetArrCarCode(String[] arr){
       int countDiffCarCode = 1;
       int[] careCode = new int[arr.length];
       for (int i = 0;i<arr.length;i++){
           careCode[i] = GetCarCode(arr[i]);
       }
       for (int i = careCode.length-1;i>0;i--){
           for(int j =0; j<i;j++){
               if(careCode[j] > careCode[j+1]) {
                   int tmp = careCode[j];
                   careCode[j]=careCode[j+1];
                   careCode[j+1]=tmp;
               }
           }
       }
       for (int i = 0;i<careCode.length-1;i++){
               if (careCode[i] != careCode[i+1]) {
                   countDiffCarCode++;
               }
       }
       int[] carDiffCode = new int[countDiffCarCode];
        careCode[0] = careCode[0];
        for (int i = 1,j = 1;i<careCode.length;i++){
            //System.out.println(careCode[i]);
            if (careCode[i] != careCode[i-1]) {
                carDiffCode[j]=careCode[i];
                j++;
                System.out.println(carDiffCode[j]);
            }
        }
       System.out.println(countDiffCarCode);
        return careCode;

    }
    public static int GetDistanceCar(String car) {
        return Integer.parseInt(car.substring(car.indexOf("-") + 1, car.indexOf("-") == car.lastIndexOf("-") ? car.length() : car.lastIndexOf("-")));
    }

    public static int GetCarCode(String car) {
        return Integer.parseInt(car.substring(1, car.indexOf("_")));
    }

    public static double GetSumGsm(double fuelCost, double consum, double dist) {
        return (fuelCost * consum * dist) / 100;
    }

    public double GetAllGsm(String[] arr) {
        double sum = 0;

        for (String i : arr) {
            int carCode = GetCarCode(i);
            int dist = GetDistanceCar(i);
            sum += GetSumGsm(GetFuelCost(carCode), GetConsumption(carCode), dist);
        }
        return sum;
    }

    public static double GetTypeCarGsm(String[] arr, int carCode) {
        double sum = 0;
        for (String i : arr) {
            int carCodeArr = GetCarCode(i);
            sum += GetCarCode(i) == carCode ? GetSumGsm(GetFuelCost(carCodeArr), GetConsumption(carCodeArr), GetDistanceCar(i)) : 0;

        }
        return sum;
    }

    public String GetMaxTypeCarGsm(String[] arr) {
        int carCodeMax = 100;
        for (int i = 100; i < 500; i += 100) {
            if (GetTypeCarGsm(arr, i) > GetTypeCarGsm(arr, carCodeMax))
                carCodeMax = i;
        }

        return GetCarName(carCodeMax);
    }

    public String GetMinTypeCarGsm(String[] arr) {
        int carCodeMin = 100;
        for (int i = 100; i < 500; i += 100) {
            if (GetTypeCarGsm(arr, i) < GetTypeCarGsm(arr, carCodeMin))
                carCodeMin = i;
        }

        return GetCarName(carCodeMin);
    }

    public static String[] GetInfoCar(String[] arr,int carCode){
     return new String[]{};

    }

    public static void main(String[] args) {
        GSM primer = new GSM();
        System.out.println("Расходы на ГСМ всего " + primer.GetAllGsm(ts));
        for (int i = 100; i < 500; i += 100) {
            System.out.println("Расходы на " + GetCarName(i) + " " + GetTypeCarGsm(ts, i));
        }
        System.out.println("Самые высокие расходы на " + primer.GetMaxTypeCarGsm(ts));
        System.out.println("Самые низкие расходы на " + primer.GetMinTypeCarGsm(ts));
        GetArrCarCode(ts);
    }
}
