package org.game;

import java.util.Random;

public class Board {
    private final int[][] grid = new int[4][4];
    private int score = 0;
    private final Random random = new Random();

    public Board(){
        this.addRandomNumber();
        this.addRandomNumber();
    }

    public int[][] getGrid() { return grid; }
    public int getScore() { return score; }

    public void addRandomNumber() {
        boolean hasEmpty = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 0) {
                    hasEmpty = true;
                    break;
                }
            }
        }
        if (!hasEmpty) return;

        boolean placed = false;
        while (!placed) {
            int r = random.nextInt(4);
            int c = random.nextInt(4);
            if (grid[r][c] == 0) {
                grid[r][c] = (random.nextInt(10) == 0) ? 4 : 2;
                placed = true;
            }
        }
    }

    public void moveLeft() {
        for (int i = 0; i < 4; i++) {
            for (int step = 0; step < 3; step++) {
                left(i);
            }
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i][j + 1]) {
                    grid[i][j] *= 2;
                    score += grid[i][j];
                    grid[i][j + 1] = 0;
                }
            }
            left(i);
        }
    }

    private void left(int i) {
        for (int j = 0; j < 3; j++) {
            if (grid[i][j] == 0 && grid[i][j + 1] != 0) {
                grid[i][j] = grid[i][j + 1];
                grid[i][j + 1] = 0;
            }
        }
    }

    public void moveRight() {
        for (int i = 0; i < 4; i++) {
            for (int step = 0; step < 3; step++) {
                right(i);
            }
            for (int j = 3; j > 0; j--) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i][j - 1]) {
                    grid[i][j] *= 2;
                    score += grid[i][j];
                    grid[i][j - 1] = 0;
                }
            }
            right(i);
        }
    }

    private void right(int i) {
        for (int j = 3; j > 0; j--) {
            if (grid[i][j] == 0 && grid[i][j - 1] != 0) {
                grid[i][j] = grid[i][j - 1];
                grid[i][j - 1] = 0;
            }
        }
    }

    public void moveUp() {
        for (int j = 0; j < 4; j++) {
            for (int step = 0; step < 3; step++) {
                up(j);
            }
            for (int i = 0; i < 3; i++) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i + 1][j]) {
                    grid[i][j] *= 2;
                    score += grid[i][j];
                    grid[i + 1][j] = 0;
                }
            }
            up(j);
        }
    }

    private void up(int j) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][j] == 0 && grid[i + 1][j] != 0) {
                grid[i][j] = grid[i + 1][j];
                grid[i + 1][j] = 0;
            }
        }
    }

    public void moveDown() {
        for (int j = 0; j < 4; j++) {
            for (int step = 0; step < 3; step++) {
                down(j);
            }
            for (int i = 3; i > 0; i--) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i - 1][j]) {
                    grid[i][j] *= 2;
                    score += grid[i][j];
                    grid[i - 1][j] = 0;
                }
            }
            down(j);
        }
    }

    private void down(int j) {
        for (int i = 3; i > 0; i--) {
            if (grid[i][j] == 0 && grid[i - 1][j] != 0) {
                grid[i][j] = grid[i - 1][j];
                grid[i - 1][j] = 0;
            }
        }
    }

    public boolean isGameOver() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 0) return false;
                if (i >0 && grid[i][j] == grid[i - 1][j]) return false;
                if (i < 3 && grid[i][j] == grid[i + 1][j]) return false;
                if (j > 0 && grid[i][j] == grid[i][j - 1]) return false;
                if (j < 3 && grid[i][j] == grid[i][j + 1]) return false;
            }
        }
        return true;
    }
}