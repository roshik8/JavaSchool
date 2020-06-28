package com.roshik.tasks.task7;

public class PrimeNumberGenerator implements IPrimeNumberGenerator {

    @Override
    public int[] generate(int max) {
        if (max < 2)
            return null;
        boolean[] sieve = getDefaultSieve(max);
        int lengthPrimeNumbers = siftSieve(sieve);
        int[] arrPrimeNumber = getArrPrimeNumber(sieve, lengthPrimeNumbers);

        return arrPrimeNumber;

    }

    private boolean[] getDefaultSieve(int max) {
        int lengthSieve = max + 1;
        boolean[] sieve = new boolean[lengthSieve];

        // Заполняем массив true
        for (int i = 0; i < lengthSieve; i++)
            sieve[i] = true;
        sieve[0] = sieve[1] = false; //Удаляем числа, которые точно не простые 0 и 1

        return sieve;
    }

    private int siftSieve(boolean[] sieve) {
        // Алгоритм Решето Эратосфена
        for (int i = 2; i < Math.sqrt(sieve.length) + 1; i++) {
            // Вычеркиваем числа кратные данному числу
            if (sieve[i]) {
                for (int j = 2 * i; j < sieve.length; j += i) {
                    sieve[j] = false;
                }
            }
        }
        // Подсчитываем количество простых чисел
        int lengthPrimeNumbers = 0;
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i])
                lengthPrimeNumbers++;
        }
        return lengthPrimeNumbers;

    }

    private int[] getArrPrimeNumber(boolean[] sieve, int lengthPrimeNumbers) {
        int[] arrPrimeNumber = new int[lengthPrimeNumbers];
        // Итоговый массив
        for (int i = 0, j = 0; i < sieve.length; i++) {
            if (sieve[i])
                arrPrimeNumber[j++] = i;
        }
        return arrPrimeNumber;
    }


}
