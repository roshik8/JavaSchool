package com.roshik.tasks.task7;

public class Test {

    public static IPrimeNumberGenerator generator;
    public static IPagePrinter printer;

    public static void main(String[] args) {

        generator = new PrimeNumberGenerator();

        printer  = new PrimeNumbersPrinter();
        printer.setMaxCharsInLine(15);
        printer.setMaxLinesInPage(4);

        int[] arr = generator.generate(1000);
        printer.print(arr);
    }
}
