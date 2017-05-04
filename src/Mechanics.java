import java.util.Scanner;

public class Mechanics {

	String coord;
	String input;
	Board board;
	Scanner scanner = new Scanner(System.in);
	Player player1 = new Player("DEFAULT");
	Player player2 = new Player("DEFAULT");
	Player playerCurrent = new Player("DEFAULT");
	boolean spaceOccupied = false;
	boolean gameRunning = true;
	int row = 0;
	int col = 0;
	int gameCounter = 0;

	public void startGame() {
		gameRunning = true;
		gameCounter = 0;
		System.out.println("Welcome to Tic-Tac-Toe!!!" + "\n" + "- - - - - - -");
		initBoard();
		initPlayers();
		runGame();
	}

	public void runGame() {
		do {
			do {
				askCoord();
				setRowCol();
				checkIfOccupied(row, col);
			} while (spaceOccupied == true);
			setMarker();
			checkWinner();
			checkDraw();
			changePlayer();

		} while (gameRunning == true);
		if (gameRunning == false) {
			playAgain();
		}

	}

	/*
	 * PLAYER INTERFACE
	 */
	public void initPlayers() {
		System.out.println("Player 1 name?");
		player1.setName(scanner.nextLine());
		player1.setMarker("X");
		System.out.println("Welcome, " + player1.getName() + "! \n");

		System.out.println("Player 2 name?");
		player2.setName(scanner.nextLine());
		player2.setMarker("O");
		System.out.println("Welcome, " + player2.getName() + "! \n");

		playerCurrent = player1;
	}

	/*
	 * BOARD MECHANICS
	 */

	public void askCoord() {
		System.out.println("Where do you wish to place, " + playerCurrent.getName() + "?");
		input = scanner.nextLine();
		coord = input.toUpperCase();
	}

	public void initBoard() {
		board = new Board();
		board.initializeBoard();
	}

	public void setRowCol() {

		switch (coord) {
		// top row
		case "1A":
		case "A1":
			row = 0;
			col = 0;
			break;

		case "2A":
		case "A2":
			row = 0;
			col = 1;
			break;

		case "3A":
		case "A3":
			row = 0;
			col = 2;
			break;

		// middle row
		case "1B":
		case "B1":
			row = 1;
			col = 0;
			break;

		case "2B":
		case "B2":
			row = 1;
			col = 1;
			break;

		case "3B":
		case "B3":
			row = 1;
			col = 2;
			break;

		// bottom row
		case "1C":
		case "C1":
			row = 2;
			col = 0;
			break;

		case "2C":
		case "C2":
			row = 2;
			col = 1;
			break;

		case "3C":
		case "C3":
			row = 2;
			col = 2;
			break;
		default:
			System.out.println("Wrong coordinates!!!");
			runGame();
		}

	}

	public void setMarker() {
		board.setMarker(row, col, playerCurrent.getMarker());
		board.drawBoard();
		gameCounter++;
	}

	public void changePlayer() {
		if (playerCurrent == player1) {
			playerCurrent = player2;
		} else
			playerCurrent = player1;
	}

	public void checkIfOccupied(int row, int col) {
		board.checkIfOccupied(row, col);
		spaceOccupied = board.occupiedBoolean();
	}

	/*
	 * WIN OR LOSS MECHANIC
	 */

	public void checkWinner() {
		board.checkWin(row, col, playerCurrent.getMarker());
		String winner = board.getWinner();
		if (winner != " ") {
			gameRunning = false;
			reportWinner(playerCurrent.getName());
		}
	}

	public void reportWinner(String winner) {
		System.out.println("Player " + winner + " wins!!!");
	}

	public void playAgain() {
		System.out.println("Do you wish to play again? (Y/N)");
		input = scanner.nextLine();
		input = input.toUpperCase();

		if (input.equals("N") || input.equals("NO")) {
			System.out.println("Thank you for playing!!!");
			System.exit(0);
		} else if (input.equals("Y") || input.equals("YES")) {
			startGame();
		} else 
			System.out.println("Wrong answer?");
		return;
	}

	public void checkDraw() {
		if (gameRunning == true && gameCounter == 9) {
			System.out.println("It's a Draw!");
			gameRunning = false;
		}

	}

}
