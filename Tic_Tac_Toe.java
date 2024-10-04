package com.tic_tac;
import java.util.Arrays;
import java.util.Scanner;
public class TicTacToe {
    private static char[][] board = {
            {'_','_','_'},
            {'_','_','_'},
            {'_','_','_'}
    };
    private static int playerCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printBoard();
        while (true) {
            greetings(sc);
        }
    }

    private static void greetings(Scanner sc) {
        int x = 0, y = 0;
        System.out.println(playerCount % 2 == 0? "Player X" : "Player O");
        System.out.println("Enter row");
        int row = sc.nextInt();
        System.out.println("Enter col");
        int col = sc.nextInt();
        insert((playerCount%2 == 0?'X' : 'O'), row, col);
    }

    private static void insert(char playerName, int row, int col) {
        if (row < 3 && row >= 0 && col < 3 && col >= 0) {
            if (board[row][col] != 'X' && board[row][col] != 'O') {
                board[row][col] = playerName;
                playerCount++;
                printBoard();
                if (check()) {
                    System.out.println("Player "+playerName+" Wins...!");
                    System.exit(0);
                }
                if (playerCount == 9) {
                    System.out.println("Draw the match");
                    System.exit(0);
                }
                System.out.println("Inserted");
            }
            else {
                System.out.println("Seat is already occupied");
            }
        } else {
            System.out.println("Invalid Position... Please enter valid position...!");
        }
    }

    private static boolean check() {
        //row
        for (int i = 0; i<3; i++) {
            if (board[i][0] != '_') {
                if ((board[i][0] == board[i][1]) && (board[i][1] == board[i][2]))
                    return true;
            }
        }
        //col
        for (int i = 0; i<3; i++) {
            if (board[0][i] != '_') {
                if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]))
                    return true;
            }
        }
        //diagonal
        if ((board[0][0] != '_') &&(board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
            return true;

        //cross diagonal
        if ((board[0][2] != '_') && (board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))
            return true;

        return false;
    }

    private static void printBoard() {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
