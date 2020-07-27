package com.roshik.tasks.task4_3;

import java.util.*;

public class Main4_3 {

    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }

    public static void main(String[] args) {
        Collection<Integer> t = new ArrayList<>();
        t.add(1);
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(1);

        t = removeDuplicates(t);
    }
}
