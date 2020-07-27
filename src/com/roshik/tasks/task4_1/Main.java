package com.roshik.tasks.task4_1;

import java.util.*;

public class Main {

    enum carParameter {
        gosNumber, distance, additional
    }

    public static String[] ts = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-120-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};

    public static BaseCar createCar(String str) {
        int indexOf = str.indexOf("_");
        String codeCar = str.substring(0, indexOf);
        String parameterSting = str.substring(indexOf + 1);
        var parameters = parse(parameterSting);
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

    private static HashMap<carParameter, Integer> parse(String parameterSting) {
        HashMap<carParameter, Integer> map = new HashMap<>();

        int start = 0;
        for (carParameter i : carParameter.values()) {
            int end = parameterSting.indexOf("-", start);
            String substring;
            if (end < 0)
                substring = parameterSting.substring(start);
            else
                substring = parameterSting.substring(start, end);

            int value = Integer.parseInt(substring);
            map.put(i, value);
            start = end + 1;
        }

        return map;
    }

    public static HashMap<String, Double> getTypeSumCostGSM(ArrayList<BaseCar> cars) {
        HashMap<String, Double> typeSumCostGSM = new HashMap<>();

        for (BaseCar car : cars) {
            double sumCost = typeSumCostGSM.getOrDefault(car.carName, 0.0);
            sumCost += car.getSumCostGsm();
            typeSumCostGSM.put(car.carName, sumCost);
        }

        return typeSumCostGSM;
    }

    public static String getMaxCarCostSumGsm(HashMap<String, Double> typeSumCostGSM) {
        Double maxGsm = null;
        String carName = "";
        for (var i : typeSumCostGSM.entrySet()) {
            double currentSumCostGsm = i.getValue();
            if (maxGsm == null || maxGsm <= currentSumCostGsm) {
                maxGsm = currentSumCostGsm;
                carName = i.getKey();
            }
        }

        return carName;
    }

    public static String getMinCarCostSumGsm(HashMap<String, Double> typeSumCostGSM) {
        Double minGsm = null;
        String carName = "";
        for (var i : typeSumCostGSM.entrySet()) {
            double currentSumCostGsm = i.getValue();
            if (minGsm == null || minGsm > currentSumCostGsm) {
                minGsm = currentSumCostGsm;
                carName = i.getKey();
            }
        }

        return carName;
    }

    static Comparator<BaseCar> nameComparator = new Comparator<>() {
        @Override
        public int compare(BaseCar o1, BaseCar o2) {
            return o1.carName.compareTo(o2.carName);
        }
    };
    static Comparator<BaseCar> distanceComparator = new Comparator<>() {
        @Override
        public int compare(BaseCar o1, BaseCar o2) {
            if (o1.distance < o2.distance) return -1;
            if (o1.distance > o2.distance) return 1;
            return 0;
        }
    };

    private static void sortCarList(ArrayList<BaseCar> cars) {
        Collections.sort(cars, nameComparator.thenComparing(distanceComparator));
    }

    public static void main(String[] args) {
        ArrayList<BaseCar> cars = new ArrayList<>();
        for (String str : ts) {
            cars.add(createCar(str));
        }

        double allCostGsm = 0;
        for (BaseCar car : cars) {
            allCostGsm += car.getSumCostGsm();
        }
        System.out.println("Расходы на ГСМ всего " + allCostGsm);

        for (var carType : getTypeSumCostGSM(cars).entrySet()) {
            System.out.println("Расходы на " + carType.getKey() + ": " + carType.getValue());
        }
        System.out.println("Самые высокие расходы на " + getMaxCarCostSumGsm(getTypeSumCostGSM(cars)));
        System.out.println("Самые низкие расходы на " + getMinCarCostSumGsm(getTypeSumCostGSM(cars)));

        sortCarList(cars);
        for (BaseCar car : cars) {
            System.out.println(car.getCarInfo());
        }
    }
}

