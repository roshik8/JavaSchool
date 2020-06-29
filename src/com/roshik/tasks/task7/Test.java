package com.roshik.tasks.task7;

import com.roshik.tasks.task6.ConsoleLogger;
import com.roshik.tasks.task6.ILogger;

public class Test {

    public static IPrimeNumberGenerator generator;
    public static IPagePrinter printer;


    public static void main(String[] args) {

        generator = new PrimeNumberGenerator();

        printer  = new PagePrinter();
        printer.setMaxCharsInLine(20);
        printer.setMaxLinesInPage(5);

        int[] arr = generator.generate(1000);
        if(arr==null){
            System.out.println("Невозможно создать массив");
        }
        else{
        printer.print(arr);
        }
    }
}
