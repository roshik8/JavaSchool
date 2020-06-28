package com.roshik.tasks.task7;

public class Main {
    public static void main(String[] args) {
        /*
         * Реализация генерации всех простых чисел в заданном диапазоне
         */

        int max = 1000000;
        if (max >= 2) {
            int z = max + 1;
            boolean[] f = new boolean[z];
            int i;

            // Заполняем массив true
            for (i = 0; i < z ; i++)
                f[i] = true;
            f[0] = f[1] = false; //Удаляем числа, которые точно не простые 0 и 1

            // Алгоритм Решето Эратосфена
            int j;
            for (i = 2; i < Math.sqrt(z) + 1; i++) {
                // Вычеркиваем числа кратные данному числу
                if (f[i]) {
                    for (j = 2 * i; j < z; j += i) {
                        f[j] = false;
                    }
                }
            }

            // Подсчитываем количество простых чисел
            int c = 0;
            for (i = 0; i < z; i++) {
                if (f[i])
                    c++;
            }

            int[] arr = new int[c];
            // Итоговый массив
            for (i = 0, j = 0; i < z; i++) {
                if (f[i])
                    arr[j++] = i;
            }
            // Вывод
            int m = 20; // Максимальное количество символов с строке
            int p = 0;
            int s = 5; // Максимальное количество строк на странице
            int l = 0;
            for (int a: arr) {
                System.out.print(a + " ");
                p += String.valueOf(a).length() + 1;
                if (p >= 20) {
                    // Переход на новую строку
                    System.out.println();
                    p = 0;
                    l++;
                }
                if (l >= s) {
                    System.out.println("--------Новая cтраница--------");
                    l = 0;
                }
            }
        } else {
            System.out.println("Невозможно создать массив");
        }

    }
}
