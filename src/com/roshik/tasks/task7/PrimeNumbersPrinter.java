package com.roshik.tasks.task7;

public  class PrimeNumbersPrinter implements IPagePrinter {

    private int maxCharsInLine=100; // Максимальное количество символов с строке
    private int maxLinesInPage=10; // Максимальное количество строк на странице

    public void setMaxCharsInLine(int maxCharsInLine){
        this.maxCharsInLine = maxCharsInLine;
    }

    public void setMaxLinesInPage(int maxLinesInPage){
        this.maxLinesInPage = maxLinesInPage;
    }

    @Override
    public void print(int[] arr){
        int amountCharsInLine = 0;
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
