package org.game;

public class Renderer {
    public void draw(int[][] grid, int score) {

        System.out.println("\n\n\nSCORE: " + score);
        System.out.println("+------+------+------+------+");

        for (int i = 0; i < 4; i++) {
            System.out.print("|");
            for (int j = 0; j < 4; j++) {
                int val = grid[i][j];

                if (val == 0) {
                    System.out.print("      |");
                } else {
                    System.out.print(" ");
                    System.out.printf("\033[36m%3d\033[0m", val);
                    System.out.print("  |");
                }
            }
            System.out.println();
            System.out.println("+------+------+------+------+");
        }
    }
}