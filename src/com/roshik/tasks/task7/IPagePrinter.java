package com.roshik.tasks.task7;

public interface IPagePrinter {
    public int maxCharsInLine=100; // Максимальное количество символов с строке
    public int amountCharsInLine=0;
    public int maxLinesInPage=10; // Максимальное количество строк на странице
    public int amountLinesInPage=0;

    public void print(int[] arr);
}
