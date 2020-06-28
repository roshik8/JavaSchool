package com.roshik.tasks.task7;

public class Test {

    public static IPrimeNumberGenerator prime;
    public static IPagePrinter print;

    public static void main(String[] args) {

        prime = new PrimeNumberGenerator();
        print  = new PrimeNumbersPrinter();

        print.print(prime.generate(1000));
    }
}
