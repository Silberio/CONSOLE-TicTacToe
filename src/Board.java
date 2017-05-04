
public class Board {
	
	String[][] board = new String[3][3];
	String winner = " ";
	Boolean spaceOccupied = false;
	
	public void initializeBoard() {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = " ";
			}
		}
	}
	
	public void drawBoard() {
		System.out.println(
					"  1 " + "  2 " + "  3 " + "\n" +
					"A " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n" +
					"  --+---+--" + "\n" + 
					"B " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n" +
					"  --+---+--" + "\n" +
					"C " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "\n" 					
				);
		
	}

	public void setMarker(int row, int col, String marker) {
		board[row][col] = marker;
	}
	
	
	public void checkIfOccupied(int row, int col) {
		String space = board[row][col];
		if(space.equals(" ")) {
			spaceOccupied = false;
		} else
			spaceOccupied = true;
	} 
	
	public boolean occupiedBoolean() {
		if(spaceOccupied == true) {
			return true;
		} else 
			return false;
	}
	
	public void checkWin(int row, int col, String marker) {
		for (int i = 0; i < 3; i++) {
			if (board[row][i] != marker)
				break;
			if (i == 3 - 1) {
				winner = marker;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (board[i][col] != marker)
				break;
			if (i == 3 - 1) {
				winner = marker;
			}
		}
		
		if (row + col == 3 - 1) {
			for (int i = 0; i < 3; i++) {
				if (board[i][(3 - 1) - i] != marker)
					break;
				if (i == 3 - 1) {
					winner = marker;
				}
			}
		}
		
		if (row == col) {
			for (int i = 0; i < 3; i++) {
				if (board[i][i] != marker)
					break;
				if (i == 3 - 1) {
					winner = marker;
				}
			}
		}
		
	}

	
	public String getWinner() {
		return winner;
	}
	
	public String getSpace(int i, int j) {
		return board[i][j];
	}
}
