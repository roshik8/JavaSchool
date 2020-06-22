package com.roshik.tasks.task5;

public  class Calculator {

    public static double plus(double a, double b){
        return a+b;
    }
    public static int plus(int a, int b){
        return a+b;
    }

    public static double minus(double a, double b){
        return a-b;
    }

    public static double multiply(double a, double b){
        return a*b;
    }

    public static double divide(double a, double b){
        return a/b;
    }

    public static double power(double a, double b){
        double result = 1;
        for(int i = 1;i<=b;i++){
            result = result*a;
        }
        return result;
    }

    public static double sqrt(double a){
        return Math.sqrt(a);
    }


}

