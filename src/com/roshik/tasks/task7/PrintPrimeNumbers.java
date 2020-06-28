package com.roshik.tasks.task7;

public  class PrintPrimeNumbers implements  IPrint {

    @Override
    public void print(int[] arr){
        int maxCharsInLine = 20; // Максимальное количество символов с строке
        int amountCharsInLine = 0;
        int maxLinesInPage = 5; // Максимальное количество строк на странице
        int amountLinesInPage = 0;
        for (int a: arr) {
            System.out.print(a + " ");
            amountCharsInLine += String.valueOf(a).length() + 1;
            if (amountCharsInLine >= maxCharsInLine) {
                // Переход на новую строку
                System.out.println();
                amountCharsInLine = 0;
                amountLinesInPage++;
            }
            if (amountLinesInPage >= maxLinesInPage) {
                System.out.println("--------Новая cтраница--------");
                amountLinesInPage = 0;
            }
        }
    }

}
