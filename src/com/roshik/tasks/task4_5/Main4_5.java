package com.roshik.tasks.task4_5;

import java.util.HashMap;

public class Main4_5 {
    public static String[] players = {"Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"};

    public static void main(String[] args) {
        int maxScore = 0;
        String winner = "";

        HashMap<String, Integer> tableScore = new HashMap<>();
        for (var player : players) {
            String[] str = player.split(" ");

            String namePlayer = str[0];
            int score = Integer.parseInt(str[1]);
            int allScore = tableScore.getOrDefault(namePlayer, 0);
            allScore += score;
            tableScore.put(namePlayer, allScore);

            if (maxScore < allScore) {
                maxScore = allScore;
                winner = namePlayer;
            }
        }

        System.out.println(winner);
    }
}
