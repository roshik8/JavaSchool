package com.roshik.tasks.task7;

public class PrimeNumberGenerator implements IPrimeNumberGenerator {

    @Override
    public int[] generate(int max){
        if (max >= 2) {
            int lengthSieve = max + 1;
            boolean[] sieve = new boolean[lengthSieve];

            // Заполняем массив true
            for (int i = 0; i < lengthSieve; i++)
                sieve[i] = true;
            sieve[0] = sieve[1] = false; //Удаляем числа, которые точно не простые 0 и 1

            // Алгоритм Решето Эратосфена
            for (int i = 2; i < Math.sqrt(lengthSieve) + 1; i++) {
                // Вычеркиваем числа кратные данному числу
                if (sieve[i]) {
                    for (int j = 2 * i; j < lengthSieve; j += i) {
                        sieve[j] = false;
                    }
                }
            }

            // Подсчитываем количество простых чисел
            int lengthPrimeNumbers = 0;
            for (int i = 0; i < lengthSieve; i++) {
                if (sieve[i])
                    lengthPrimeNumbers++;
            }

            int[] arrPrimeNumber = new int[lengthPrimeNumbers];
            // Итоговый массив
            for (int i = 0, j = 0; i < lengthSieve; i++) {
                if (sieve[i])
                    arrPrimeNumber[j++] = i;
            }
            return arrPrimeNumber;

        }
        else {
            return new int[]{1};
        }

    }


}
