package org.game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Renderer renderer = new Renderer();
        HighScoreManager highScoreManager = new HighScoreManager();

        while (true) {
            renderer.draw(board.getGrid(), board.getScore());

            if (board.isGameOver()) {
                System.out.println("  GAME OVER! SCORE: " + board.getScore());
                System.out.print("Enter your name: ");
                String name = scanner.next();

                highScoreManager.save(name, board.getScore());
                highScoreManager.show();
                break;
            }

            System.out.print("> ");
            String input = scanner.next().toUpperCase();
            if (input.isEmpty()) continue;
            char move = input.charAt(0);

            if (move == 'W') board.moveUp();
            else if (move == 'S') board.moveDown();
            else if (move == 'A') board.moveLeft();
            else if (move == 'D') board.moveRight();
            else continue;

            board.addRandomNumber();
        }
        scanner.close();
    }
}