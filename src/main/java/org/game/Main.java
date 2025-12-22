package org.game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Renderer renderer = new Renderer();

        while (true) {
            renderer.draw(board.getGrid(), board.getScore());

            if (board.isGameOver()) {
                System.out.println("Game Over! Final Score: " + board.getScore());
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