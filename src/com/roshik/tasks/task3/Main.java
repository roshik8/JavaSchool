package com.roshik.tasks.task3;

public class Main {

    public static String[] ts = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-120-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};

    public static BaseCar createCar(String str) {
        int indexOf = str.indexOf("_");
        String codeCar = str.substring(0, indexOf);
        String parameterSting = str.substring(indexOf + 1);
        int[] parameters = parse(parameterSting);

        switch (codeCar) {
            case "C100":
                return new Car(parameters);
            case "C200":
                return new Truck(parameters);
            case "C300":
                return new PassengerTransport(parameters);
            case "C400":
                return new HeavyEquipment(parameters);
            default:
                return null;
        }
    }

    public static String getCarName(BaseCar[] cars, String carType)
    {
        for (BaseCar i : cars)
        {
            if (i.getClass().getSimpleName() == carType)
                return i.carName;
        }

        return "";
    }

    private static int[] parse(String parameterSting) {
        int[] result = new int[3];

        int start = 0;
        for (int i = 0; i < result.length; i++)
        {
            int end = parameterSting.indexOf("-", start);
            String substring;
            if (end < 0)
                substring = parameterSting.substring(start);
            else
                substring = parameterSting.substring(start, end);
            result[i] = Integer.parseInt(substring);
            start = end + 1;
        }

        return result;

    }

    public static String[] getArrCarType(BaseCar[] cars)
    {
        int countDiffCarCode = 0;
        String[] carCode = new String[cars.length];

        for (int i = 0; i < cars.length; i++)
        {
            String carType = cars[i].getClass().getSimpleName();
            boolean carCodeAlreadyAdd = false;

            for (int j = 0; j < countDiffCarCode; j++)
            {
                if (carCode[j] == carType)
                {
                    carCodeAlreadyAdd = true;
                    j = countDiffCarCode; //выход из цикла поиска дублей
                }
            }

            if (!carCodeAlreadyAdd)
            {
                carCode[countDiffCarCode++] = carType;
            }
        }

        String[] carDiffCode = new String[countDiffCarCode];
        for (int i = 0; i < carDiffCode.length; i++)
        {
            carDiffCode[i] = carCode[i];
        }

        return carDiffCode;
    }
    public static double getTypeSumCostGsm(BaseCar[] cars, String carType)
    {
        double sum = 0;
        for (BaseCar i : cars)
        {
            if (i.getClass().getSimpleName() == carType)
                sum += i.getSumCostGsm();
        }
        return sum;
    }

    public static String getMaxCarCostSumGsm(BaseCar[] cars)
    {
        double maxGsm = 0;
        String carCodeMax = "BaseCar";
        for (String i : getArrCarType(cars))
        {
            double currentSumCostGsm = getTypeSumCostGsm(cars, i);
            if (maxGsm <= currentSumCostGsm)
            {
                maxGsm = currentSumCostGsm;
                carCodeMax = i;
            }
        }

        return getCarName(cars, carCodeMax);
    }

    public static String getMinCarCostSumGsm(BaseCar[] cars)
    {
        double minGsm = getTypeSumCostGsm(cars, cars[0].getClass().getSimpleName());
        String carCodeMin = cars[0].getClass().getSimpleName();
        for (String i : getArrCarType(cars))
        {
            double currentSumCostGsm = getTypeSumCostGsm(cars, i);
            if (minGsm > currentSumCostGsm)
            {
                minGsm = currentSumCostGsm;
                carCodeMin = i;
            }
        }

        return getCarName(cars, carCodeMin);
    }

    public static BaseCar[] getCarTypeArr(BaseCar[] cars, String carType) {
        int countCarType = 0;
        for (BaseCar i : cars) {
            countCarType += i.getClass().getSimpleName() == carType ? 1 : 0;
        }
        BaseCar[] CarArray = new BaseCar[countCarType];

        for (int i = 0, j = 0; i < cars.length; i++) {
            if (cars[i].getClass().getSimpleName() == carType) {
                CarArray[j++] = cars[i];
            }
        }

        return CarArray;

    }

    public static BaseCar[] sortCarArray(BaseCar[] cars) {
        for (int i = cars.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (cars[j].distance > cars[j + 1].distance){
                    BaseCar tmp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = tmp;
                }
            }
        }
        return cars;
    }


    public static void main(String[] args) {

        BaseCar[] cars = new BaseCar[ts.length];
        for (int i = 0; i < ts.length; i++) {
            cars[i] = createCar(ts[i]);
        }
        double allCostGsm =0;
        for(BaseCar i:cars){

            allCostGsm+=i.getSumCostGsm();

        }

        System.out.println("Расходы на ГСМ всего " + allCostGsm);
        for (String i: getArrCarType(cars)){
            System.out.println("Расходы на "+getCarName(cars,i)+": "+getTypeSumCostGsm(cars,i));
        }
        System.out.println("Самые высокие расходы на " + getMaxCarCostSumGsm(cars));
        System.out.println("Самые низкие расходы на " + getMinCarCostSumGsm(cars));

        for (String i : getArrCarType(cars)) {
            for (BaseCar j : sortCarArray(getCarTypeArr(cars,i))) {
                System.out.println(j.getCarInfo());
            }
        }





    }


}

