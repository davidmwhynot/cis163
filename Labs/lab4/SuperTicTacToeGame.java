package lab4;

import java.awt.*;
import java.util.ArrayList;

public class SuperTicTacToeGame {
	private CellStatus[][] board;
	private GameStatus status;
	private int size;
	private CellStatus turn;
	private int connections;   // used in to do 4.


	public SuperTicTacToeGame(int size) {
		status = GameStatus.IN_PROGRESS;
		this.size = size;
		this.connections = 3;
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
		 *    TODO 3:
		 *    		Write code for a horizontal win of 3
		 *    		Complete a veritical win.
		 *          Complete the two  diagonal wins (upper left,  upper right)
		 */

		/*
		 *    TODO 4:
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
