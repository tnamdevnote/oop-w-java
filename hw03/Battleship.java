package hw03;

import java.util.*;
import java.io.*;

public class Battleship {
	public static void main(String[] args) {
    System.out.println("Welcome to Battleship!");
		Scanner input = new Scanner(System.in);

		String errorMessage = "Invalid coordinates. Choose different coordinates.";
		
		/** Part 1: Set up */
		// Initialize 2D Location Board
		char[][] p1LocationBoard = initBoard();
		char[][] p2LocationBoard = initBoard();

		// PLAYER 1: Enter Ship Locations
		System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
		chooseCoordinates(p1LocationBoard, input, errorMessage);

		printBattleShip(p1LocationBoard);

		for (int i = 0; i <= 100; i++) {
			System.out.println("");
		}

		// PLAYER 2: Enter Ship Locations
		System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
		chooseCoordinates(p2LocationBoard, input, errorMessage);

		printBattleShip(p2LocationBoard);

		for (int i = 0; i <= 100; i++) {
			System.out.println("");
		}

		// Use this to keep track of each player's ship count.
		int p1ShipCount = 5;
		int p2ShipCount = 5;

		char[][] p1TargetHistoryBoard = initBoard();
		char[][] p2TargetHistoryBoard = initBoard();


		/** Part 2: Play!  */

		
		// Keep playing until one player's ships get eliminated.
		boolean isPlayer1 = true;
		do {

			int currPlayerNum = isPlayer1 ? 1 : 2;
			int opponentNum = isPlayer1 ? 2 : 1;
			char[][] currentLocationBoard = isPlayer1 ? p2LocationBoard : p1LocationBoard;
			char[][] currentTargetHistoryBoard = isPlayer1 ? p1TargetHistoryBoard : p2TargetHistoryBoard;

			System.out.println("Player " + currPlayerNum + ", enter hit row/column:");
			if (input.hasNextInt()) {
				int row = input.nextInt();
				if (input.hasNextInt()) {
					int col = input.nextInt();
					if (row >= 0 && row < currentLocationBoard.length && col >= 0 && col < currentLocationBoard[row].length) {
						switch (currentLocationBoard[row][col]) {
							case '@':
								currentTargetHistoryBoard[row][col] = 'X';
								currentLocationBoard[row][col] = 'X';
								if (isPlayer1) {
									p2ShipCount--;
								} else {
									p1ShipCount--;
								}
								isPlayer1 = !isPlayer1;
								System.out.println("PLAYER " + currPlayerNum + " HIT PLAYER " + opponentNum + "'s SHIP!");
								printBattleShip(currentTargetHistoryBoard);
								System.out.println("");
								break;
							case 'X':
								System.out.println("You already fired on this spot. Choose different coordinates.");
								break;
							case 'O':
								System.out.println("You already fired on this spot. Choose different coordinates.");
								break;
							default:
								currentTargetHistoryBoard[row][col] = 'O';
								currentLocationBoard[row][col] = 'O';
								isPlayer1 = !isPlayer1;
								System.out.println("PLAYER " + currPlayerNum + " MISSED!");
								printBattleShip(currentTargetHistoryBoard);
								System.out.println("");
								break;
						}
					} else {
						System.out.println(errorMessage);
						input.nextLine();
					}
				}
			} else {
				System.out.println(errorMessage);
				input.nextLine();
			}
		} while (p1ShipCount != 0 && p2ShipCount != 0);

		System.out.println("PLAYER " + (isPlayer1 ? 2 : 1) + " WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS! ");
		System.out.println("");
		System.out.println("Final boards:");
		System.out.println("");
		printBattleShip(p1LocationBoard);
		System.out.println("");
		printBattleShip(p2LocationBoard);
    
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
	private static void chooseCoordinates(char[][] board, Scanner scannerInput, String errorMessage) {
		int shipNum = 1;
		do {
			System.out.println("Enter ship " + shipNum + " location:");

			if (scannerInput.hasNextInt()) {
				int row = scannerInput.nextInt();
				if (scannerInput.hasNextInt()) {
					int col = scannerInput.nextInt();
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
					scannerInput.nextLine(); 
				}
			} else {
				System.out.println(errorMessage);
				// Move past the new line so that we can prompt the user to reenter the location.
				scannerInput.nextLine(); 
			}
		} while (shipNum <= 5);
	}

  private static void updateBoards(int currPlayerNum, int opponentNum, char[][] locationBoard, char[][] targetHistoryBoard, int row, int col) {
		switch (locationBoard[row][col]) {
			case '@':
				targetHistoryBoard[row][col] = 'X';
				locationBoard[row][col] = 'X';
				System.out.println("PLAYER " + currPlayerNum + " HIT PLAYER " + opponentNum + "'s SHIP!");
				break;
			case 'X':
				System.out.println("You already fired on this spot. Choose different coordinates.");
				break;
			case 'O':
				System.out.println("You already fired on this spot. Choose different coordinates.");
				break;
			default:
				targetHistoryBoard[row][col] = 'O';
				locationBoard[row][col] = 'O';
				System.out.println("PLAYER " + currPlayerNum + " MISSED!");
				break;
		}
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