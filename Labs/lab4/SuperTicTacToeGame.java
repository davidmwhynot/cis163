package lab4;

public class SuperTicTacToeGame {
	private CellStatus[][] board;
	private GameStatus status;
	private int size;
	private CellStatus turn;
	private int connections;   // used in to do 4.


	public SuperTicTacToeGame(int size) {
		status = GameStatus.IN_PROGRESS;
		this.size = size;
		this.connections = size;
		board = new CellStatus[size][size];
		turn = CellStatus.X;
		reset();
	}

	public CellStatus[][] getBoard() {
		return board;
	}

	public void select(int row, int col) {
		if (board[row][col] != CellStatus.EMPTY)
			return;

		board[row][col] = turn;

		if (turn == CellStatus.O)
			turn = CellStatus.X;
		else
			turn = CellStatus.O;
		status = isWinner();
	}

	private GameStatus isWinner() {

		/*
		 *    TODO: 3
		 *    		Write code for a horizontal win of 3
		 *    		Complete a veritical win.
		 *          Complete the two  diagonal wins (upper left,  upper right)
		 */
		System.out.println("\n\nisWinner");
		for(int x = 0; x < size; ++x) {
			System.out.println("\nx");
			System.out.println(x);
			for(int y = 0; y < size; ++y) {
				System.out.println("y");
				System.out.println(y);
				System.out.println("\nboard");
				System.out.println(board[x][y]);
				if(board[x][y] != CellStatus.EMPTY) {
					int consecutive = 1;
					// check for row win
					for(int i = 1; i <= size - x; ++i) {
						System.out.println("\ni");
						System.out.println(i);
						System.out.println("consecutive");
						System.out.println(consecutive);
						if(board[x][y] != board[x + i][y]) {
							break;
						} else {
							++consecutive;
							if(consecutive >= connections) {
								if(board[x][y] == CellStatus.X) {
									return GameStatus.X_WON;
								} else if(board[x][y] == CellStatus.O) {
									return GameStatus.O_WON;
								}
							}
						}
					}
					// check for col win
					for(int i = 1; i < size - y; ++i) {
						System.out.println("\ni");
						System.out.println(i);
						System.out.println("consecutive");
						System.out.println(consecutive);
						if(board[x][y] != board[x][y + i]) {
							break;
						} else {
							++consecutive;
							if(consecutive >= connections) {
								if(board[x][y] == CellStatus.X) {
									return GameStatus.X_WON;
								} else if(board[x][y] == CellStatus.O) {
									return GameStatus.O_WON;
								}
							}
						}
					}
				}
			}
		}
		/*
		 *    TODO: 4
		 *          Change all code to allow any size board (i.e., not just 3)
		 *          Change the code from TODO 3 to allow a horizontal win of any length,
		 *          defined by 'this.connections' (see above) (Hint: you will also need
		 *          to think about how this.connections should be set)
		 */

		return GameStatus.IN_PROGRESS;

	}

	/*
	 *  TO DO 5, if you have the time...
	 *
	 *  Make an Undo feature.
	 */

	public boolean undo () {
		return false;
	}

	public GameStatus getGameStatus() {
		return status;
	}

	public void reset() {
		for (int r = 0; r < size; r++)
			for (int c = 0; c < size; c++)
				board[r][c] = CellStatus.EMPTY;
	}

	public boolean getOK(int r, int c) {
        return board[r][c] == CellStatus.EMPTY;
	}
}
