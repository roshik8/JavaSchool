package com.roshik.tasks.task7;

public  class PrimeNumbersPrinter implements IPagePrinter {
    public int maxCharsInLine = 20; // Максимальное количество символов с строке
    public int amountCharsInLine = 0;
    public int maxLinesInPage = 5; // Максимальное количество строк на странице
    public int amountLinesInPage = 0;

    @Override
    public void print(int[] arr){
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
