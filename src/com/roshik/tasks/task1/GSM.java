package com.roshik.tasks.task1;

public class GSM {

    public static String[] ts = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-120-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};

    int carCode;
    double costFuel;
    double consumptionFuel;

    public static String getCarName(int car_code) {
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

    public static double getFuelCost(int car_code) {
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


    public static double getConsumption(int car_code) {
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

    public static int[] getArrCarCode(String[] arr) {
        int countDiffCarCode = 0;
        int[] carCode = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int carCodeCurr = getCarCode(arr[i]);
            boolean carCodeAlreadyAdd = false;

            for (int j = 0; j < countDiffCarCode; j++) {
                if (carCode[j] == carCodeCurr) {
                    carCodeAlreadyAdd = true;
                    j = countDiffCarCode; //выход из цикла поиска дублей
                }
            }

            if (!carCodeAlreadyAdd) {
                carCode[countDiffCarCode++] = carCodeCurr;
            }
        }

        int[] carDiffCode = new int[countDiffCarCode];
        for (int i = 0; i < carDiffCode.length; i++) {
            carDiffCode[i] = carCode[i];
        }

        for (int i = carDiffCode.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (carDiffCode[j] > carDiffCode[j + 1]) {
                    int tmp = carDiffCode[j];
                    carDiffCode[j] = carDiffCode[j + 1];
                    carDiffCode[j + 1] = tmp;
                }
            }
        }

        return carDiffCode;
    }

    public static int getNumberCar(String car) {
        return Integer.parseInt(car.substring(car.indexOf("_") + 1, car.indexOf("-")));
    }

    public static int getDistanceCar(String car) {
        return Integer.parseInt(car.substring(car.indexOf("-") + 1, car.indexOf("-") == car.lastIndexOf("-") ? car.length() : car.lastIndexOf("-")));
    }

    public static int getDopParamCar(String car) {

        return car.indexOf("-") == car.lastIndexOf("-") ? 0 : Integer.parseInt(car.substring(car.lastIndexOf("-") + 1));

    }

    public static int getCarCode(String car) {
        return Integer.parseInt(car.substring(1, car.indexOf("_")));
    }

    public static double getSumGsm(double fuelCost, double consum, double dist) {
        return (fuelCost * consum * dist) / 100;
    }

    public static double getAllGsm(String[] arr) {
        double sum = 0;

        for (String i : arr) {
            int carCode = getCarCode(i);
            int dist = getDistanceCar(i);
            sum += getSumGsm(getFuelCost(carCode), getConsumption(carCode), dist);
        }
        return sum;
    }

    public static double getTypeCarGsm(String[] arr, int carCode) {
        double sum = 0;
        for (String i : arr) {
            int carCodeArr = getCarCode(i);
            sum += getCarCode(i) == carCode ? getSumGsm(getFuelCost(carCodeArr), getConsumption(carCodeArr), getDistanceCar(i)) : 0;
        }
        return sum;
    }

    public static String getMaxTypeCarGsm(String[] arr) {
        int carCodeMax = 100;
        for (int i = 100; i < 500; i += 100) {
            if (getTypeCarGsm(arr, i) > getTypeCarGsm(arr, carCodeMax))
                carCodeMax = i;
        }

        return getCarName(carCodeMax);
    }

    public static String getMinTypeCarGsm(String[] arr) {
        int carCodeMin = 100;
        for (int i : getArrCarCode(arr)) {
            if (getTypeCarGsm(arr, i) < getTypeCarGsm(arr, carCodeMin))
                carCodeMin = i;
        }

        return getCarName(carCodeMin);
    }

    public static String[] getInfoCar(String[] arr, int carCode) {
        int countCarCode = 0;
        for (String i : arr) {
            countCarCode += getCarCode(i) == carCode ? 1 : 0;
        }
        String[] CarArray = new String[countCarCode];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (getCarCode(arr[i]) == carCode) {
                CarArray[j++] = arr[i];
            }
        }

        return CarArray;

    }

    public static String[] sortCarArray(String[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (getDistanceCar(arr[j]) > getDistanceCar(arr[j + 1])) {
                    String tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Расходы на ГСМ всего " + getAllGsm(ts));
        for (int i : getArrCarCode(ts)) {
            System.out.println("Расходы на " + getCarName(i) + " " + getTypeCarGsm(ts, i));
        }
        System.out.println("Самые высокие расходы на " + getMaxTypeCarGsm(ts));
        System.out.println("Самые низкие расходы на " + getMinTypeCarGsm(ts));

        for (int i : getArrCarCode(ts)) {
            for (String j : sortCarArray(getInfoCar(ts, i))) {
                System.out.printf("Тип авто: %s, Номер: %s, Пробег: %s, Доп.параметр: %s%n ", getCarName(getCarCode(j)), getNumberCar(j), getDistanceCar(j), getDopParamCar(j));
            }
        }
    }
}
