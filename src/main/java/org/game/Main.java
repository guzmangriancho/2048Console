package org.game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        HighScoreManager highScoreManager = new HighScoreManager();

        while (true) {
            System.out.println("\n          2048");
            System.out.println("------------------------");
            System.out.println("1.     Start Game");
            System.out.println("2.  Show High Scores");
            System.out.println("3.       Exit");

            String option = scanner.next();

            if (option.equals("1")) {
                playGame(scanner, highScoreManager);
            } else if (option.equals("2")) {
                highScoreManager.show();
            } else if (option.equals("3")) {
                break;
            }
        }
        scanner.close();
    }

    public static void playGame(Scanner scanner, HighScoreManager highScoreManager) throws Exception {
        Board board = new Board();
        Renderer renderer = new Renderer();

        while (true) {
            renderer.draw(board.getGrid(), board.getScore());

            if (board.isGameOver()) {
                System.out.println("\n  GAME OVER! SCORE: " + board.getScore());
                System.out.print("Enter your name: ");
                String name = scanner.next();

                highScoreManager.save(name, board.getScore());
                highScoreManager.show();
                System.exit(0);
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
    }
}