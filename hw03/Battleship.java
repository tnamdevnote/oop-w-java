package hw03;

import java.util.*;
import java.io.*;

public class Battleship {

	private void constructor() {

	}
	public static void main(String[] args) {
    System.out.println("Welcome to Battleship!");
		Scanner input = new Scanner(System.in);

		String errorMessage = "Invalid coordinates. Choose different coordinates";
		
		/** Part 1: Prompt player's to enter coordinates */
		// Initialize 2D Location Board
		char[][] p1LocationBoard = initBoard();
		char[][] p2LocationBoard = initBoard();

		// PLAYER 1's Location Board
		System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
		chooseCoordinates(p1LocationBoard, input, errorMessage);

		printBattleShip(p1LocationBoard);

		for (int i = 0; i <= 100; i++) {
			System.out.println("");
		}

		// PLAYER 2's Location Board
		System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
		chooseCoordinates(p2LocationBoard, input, errorMessage);

		printBattleShip(p2LocationBoard);

		for (int i = 0; i <= 100; i++) {
			System.out.println("");
		}


		/** Part 2: Play!  */

		
    
  }

	private static char[][] initBoard() {
		char[][] board = new char[5][5];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
					board[i][j] = '-';
				}
			}
		return board;
	}

	// Prompt user to enter ship location X 5
	private static void chooseCoordinates(char[][] board, Scanner input, String errorMessage) {
		int shipNum = 1;
		while (shipNum <= 5) {
			System.out.println("Enter ship " + shipNum + " location:");

			if (input.hasNextInt()) {
				int row = input.nextInt();
				if (input.hasNextInt()) {
					int col = input.nextInt();
					if (row >= 0 && row < board.length && col >= 0 && col < board[row].length) {
						if (board[row][col] == '-') {
							board[row][col] = '@';
							shipNum++;
						} else {
							System.out.println("You already have a ship there. Choose different coordinates.");
						}
					} else {
						System.out.println(errorMessage);
					}
				} else {
					System.out.println(errorMessage);
					// Move past the new line so that we can prompt the user to reenter the location.
					input.nextLine(); 
				}
			} else {
				System.out.println(errorMessage);
				// Move past the new line so that we can prompt the user to reenter the location.
				input.nextLine(); 
			}
		};
	}

    
    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}

}