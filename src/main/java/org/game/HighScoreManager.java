package org.game;

import java.io.*;
import java.util.*;

public class HighScoreManager {
    public void save(String name, int score) throws Exception {
        FileWriter fw = new FileWriter("scores.txt", true);
        fw.write(name + ":" + score + "\n");
        fw.close();
    }

    public void show() throws Exception {
        File file = new File("scores.txt");
        Scanner reader = new Scanner(file);
        List<String> list = new ArrayList<>();

        while (reader.hasNextLine()) {
            list.add(reader.nextLine());
        }
        reader.close();

        list.sort((a, b) -> {
            int scoresA = Integer.parseInt(a.split(":")[1]);
            int scoresB = Integer.parseInt(b.split(":")[1]);
            return Integer.compare(scoresB, scoresA);
        });

        System.out.println("\n TOP 10 HIGHSCORES");
        for (int i = 0; i < list.size() && i < 10; i++) {
            String[] parts = list.get(i).split(":");
            System.out.println((i + 1) + ". " + parts[0] + " - " + parts[1]);
        }
    }
}