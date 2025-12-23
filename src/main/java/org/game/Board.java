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

    public boolean moveLeft() {
        boolean moved = false;
        for (int i = 0; i < 4; i++) {
            for (int step = 0; step < 3; step++) {
                if(left(i)) moved = true;
            }
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i][j + 1]) {
                    grid[i][j] *= 2;
                    score += grid[i][j];
                    grid[i][j + 1] = 0;
                    moved = true;
                }
            }
            if(left(i)) moved = true;
        }
        return moved;
    }

    private boolean left(int i) {
        boolean moved = false;
        for (int j = 0; j < 3; j++) {
            if (grid[i][j] == 0 && grid[i][j + 1] != 0) {
                grid[i][j] = grid[i][j + 1];
                grid[i][j + 1] = 0;
                moved = true;
            }
        }
        return moved;
    }

    public boolean moveRight() {
        boolean moved = false;
        for (int i = 0; i < 4; i++) {
            for (int step = 0; step < 3; step++) {
                if(right(i)) moved = true;
            }
            for (int j = 3; j > 0; j--) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i][j - 1]) {
                    grid[i][j] *= 2;
                    score += grid[i][j];
                    grid[i][j - 1] = 0;
                    moved = true;
                }
            }
            if(right(i)) moved = true;
        }
        return moved;
    }

    private boolean right(int i) {
        boolean moved = false;
        for (int j = 3; j > 0; j--) {
            if (grid[i][j] == 0 && grid[i][j - 1] != 0) {
                grid[i][j] = grid[i][j - 1];
                grid[i][j - 1] = 0;
                moved = true;
            }
        }
        return moved;
    }

    public boolean moveUp() {
        boolean moved = false;
        for (int j = 0; j < 4; j++) {
            for (int step = 0; step < 3; step++) {
                if(up(j)) moved = true;
            }
            for (int i = 0; i < 3; i++) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i + 1][j]) {
                    grid[i][j] *= 2;
                    score += grid[i][j];
                    grid[i + 1][j] = 0;
                    moved = true;
                }
            }
            if(up(j)) moved = true;
        }
        return moved;
    }

    private boolean up(int j) {
        boolean moved = false;
        for (int i = 0; i < 3; i++) {
            if (grid[i][j] == 0 && grid[i + 1][j] != 0) {
                grid[i][j] = grid[i + 1][j];
                grid[i + 1][j] = 0;
                moved = true;
            }
        }
        return moved;
    }

    public boolean moveDown() {
        boolean moved = false;
        for (int j = 0; j < 4; j++) {
            for (int step = 0; step < 3; step++) {
                if(down(j)) moved = true;
            }
            for (int i = 3; i > 0; i--) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i - 1][j]) {
                    grid[i][j] *= 2;
                    score += grid[i][j];
                    grid[i - 1][j] = 0;
                    moved = true;
                }
            }
            if(down(j)) moved = true;
        }
        return moved;
    }

    private boolean down(int j) {
        boolean moved = false;
        for (int i = 3; i > 0; i--) {
            if (grid[i][j] == 0 && grid[i - 1][j] != 0) {
                grid[i][j] = grid[i - 1][j];
                grid[i - 1][j] = 0;
                moved = true;
            }
        }
        return moved;
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