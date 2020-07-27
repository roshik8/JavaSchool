package com.roshik.tasks.task4_2;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        String str = "ananas";
        HashMap<Character, Integer> dictionary = new HashMap<>();

        for (char c : str.toCharArray()) {
            Integer freq = dictionary.getOrDefault(c, 0) + 1;
            dictionary.put(c, freq);
        }

        for (var i : dictionary.entrySet()) {
            System.out.println(i.getKey() + "-" + i.getValue());
        }
    }
}


