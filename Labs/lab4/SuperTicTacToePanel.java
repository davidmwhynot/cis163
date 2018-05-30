package lab4;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import lab4.SuperTicTacToeGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperTicTacToePanel extends JPanel {

	private JButton[][] board;
	private CellStatus[][] iBoard;
	private JLabel xWon;
	private JLabel oWon;
	private JButton quitButton;
	private JButton undoButton;

    private JMenuItem gameItem;
    private JMenuItem quitItem;

	private SuperTicTacToeGame game;

    private ImageIcon emptyIcon;
    private ImageIcon xIcon;
    private ImageIcon oIcon;


	public SuperTicTacToePanel(JMenuItem pquitItem, JMenuItem pgameItem) {

        gameItem = pgameItem;
        quitItem = pquitItem;

		JPanel bottom = new JPanel();
		JPanel center = new JPanel();

		// create game, listeners
		ButtonListener listener = new ButtonListener();

		game = new SuperTicTacToeGame(3);


		// create Undo and quit buttons.
		quitButton = new JButton("Quit");
		quitButton.addActionListener(listener);
		undoButton = new JButton("Undo");
		undoButton.addActionListener(listener);

		// create the board
        center.setLayout(new GridLayout(3,3,3,2));
        Dimension temp = new Dimension(60,60);
        board = new JButton[3][3];

        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {

                Border thickBorder = new LineBorder(Color.blue, 2);

                board[row][col] = new JButton (" ");
                board[row][col].setBorder(thickBorder);

                board[row][col].addActionListener(listener);
                center.add(board[row][col]);
            }

		displayBoard();
        /*
         *    TODO 1:
         *    		From this point on... replace all board sizes (i.e., 3 in loops
         *    		that iterate over the board) to board.length
         */

        bottom.setLayout (new GridLayout(3,2));

        /*
         *    TODO 2:
         *    		Find online 3 different images (*.jpg) to represent a blank, X and O
         *    		Create 3 files and save them in the project folder
         *         	Continue this TODO below by replacing the JButton text with the icons
         */

        JLabel labxWins = new JLabel ("X Wins: ");
        JLabel laboWins = new JLabel ("O Wins: ");
        xWon = new JLabel ("0");
        oWon = new JLabel ("0");

        bottom.add(labxWins);
        bottom.add(xWon);
        bottom.add(laboWins);
        bottom.add(oWon);
        bottom.add(quitButton);
        bottom.add(undoButton);

		// add all to contentPane

		add (new JLabel("!!!!!!  Super TicTacToe  !!!!"), BorderLayout.NORTH);
		add (center, BorderLayout.CENTER);
		add (bottom, BorderLayout.SOUTH);

	}

	private void displayBoard() {
        System.out.println(GameStatus.O_WON);
		iBoard = game.getBoard();

		for (int r = 0; r < 3; r++)
			for (int c = 0; c < 3; c++) {

                /*
                 *    TODO 2:  (continued)
                 *    		Change these lines of code to set the Icon for each JButton
                 */

				board[r][c].setText( "_");
				if (iBoard[r][c] == CellStatus.O)
					board[r][c].setText("O");

				else if (iBoard[r][c] == CellStatus.X)
					board[r][c].setText("X");

				else if (iBoard[r][c] == CellStatus.EMPTY)
					board[r][c].setText("  ");
			}

	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (quitButton == e.getSource())
				System.exit(0);

			for (int r = 0; r < 3; r++)
				for (int c = 0; c < 3; c++)
					if (board[r][c] == e.getSource() && game.getOK(r,c))
						game.select (r,c);


			displayBoard();

			// Note: This code only checks if O wins-- no other win conditions
			// The other win conditions should be added later
			if (game.getGameStatus() == GameStatus.O_WON) {
				JOptionPane.showMessageDialog(null, "O won and X lost!\n The game will reset");
				game.reset();
				displayBoard();
				oWon.setText(""+(Integer.parseInt(oWon.getText()) + 1));
			}
		}
	}
}
