package com.roshik.tasks.task2;


public class IntArray {
    int[] intArr;

    public IntArray(int[] intArr) {
        this.intArr = intArr;
    }

    public void add(int elem) {
        add(elem, intArr.length);
    }

    public void add(int elem, int index) {
        if (index > intArr.length || index < 0)
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива");
        int[] newArr = new int[intArr.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index)
                newArr[i] = intArr[i];
            else if (i == index)
                newArr[i] = elem;
            else if (i > index)
                newArr[i] = intArr[i - 1];
        }
        intArr = newArr;
    }

    public int getLength() {
        return intArr.length;
    }

    public void remove(int index) {
        if (index >= intArr.length || index < 0)
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива");
        int[] newArr = new int[intArr.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index)
                newArr[i] = intArr[i];
            else if (i >= index)
                newArr[i] = intArr[i + 1];
        }
        intArr = newArr;
    }

    public void set(int elem, int index) {
        if (index >= intArr.length || index < 0)
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива");
        intArr[index] = elem;
    }

    public void print() {
        for (int i : intArr) {
            System.out.println(i);
        }

    }

    public void sort() {
        for (int i = intArr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (intArr[j] > intArr[j + 1]) {
                    int tmp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = tmp;
                }
            }
        }
    }

    private void reverse() {
        for (int i = 0; i < intArr.length / 2; i++) {
            int tmp = intArr[i];
            intArr[i] = intArr[intArr.length - i - 1];
            intArr[intArr.length - i - 1] = tmp;
        }
    }

    public void sortDesc() {
        this.sort();
        this.reverse();
    }

    public int getMinElement() {
        int min = 0;
        for (int i = 0; i < intArr.length; i++) {
            if (min >= intArr[i])
                min = intArr[i];
        }
        return min;
    }

    public int getMaxElement() {
        int max = 0;
        for (int i = 0; i < intArr.length; i++) {
            if (max <= intArr[i])
                max = intArr[i];
        }
        return max;
    }

    public void fill(int value) {
        for (int i = 0; i < intArr.length; i++)
            intArr[i] = value;
    }

    public static void main(String[] args) {
        int[] newArr = new int[7];
        var newList = new IntArray(newArr);
        newList.set(20, 0);
        newList.set(45, 4);
        //newList.fill(44);
        //newList.add(6,4);
        //newList.set(88,0);
        //System.out.println(newList.getLength());
        //newList.remove(6);
        //newList.sort();
        //newList.sortDesc();
        //newList.fill(5);
        //newList.print();
        //System.out.println(newList.getMaxElement());
        System.out.println(newList.getMinElement());

    }
}



