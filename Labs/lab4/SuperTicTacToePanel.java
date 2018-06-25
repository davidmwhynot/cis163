package lab4;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import lab4.SuperTicTacToeGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
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

	private final int BOARD_SIZE = 4;

	public SuperTicTacToePanel(JMenuItem pquitItem, JMenuItem pgameItem) {

		gameItem = pgameItem;
		quitItem = pquitItem;

		JPanel bottom = new JPanel();
		JPanel center = new JPanel();

		// create game, listeners
		ButtonListener listener = new ButtonListener();

		game = new SuperTicTacToeGame(BOARD_SIZE);

		// create Undo and quit buttons.
		quitButton = new JButton("Quit");
		quitButton.addActionListener(listener);
		undoButton = new JButton("Undo");
		undoButton.addActionListener(listener);
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		emptyIcon = new ImageIcon("lab4/blank.jpg");
		emptyIcon = new ImageIcon(getScaledImage(emptyIcon.getImage(), 40, 40));
		xIcon = new ImageIcon("lab4/x.jpg");
		xIcon = new ImageIcon(getScaledImage(xIcon.getImage(), 40, 40));
		oIcon = new ImageIcon("lab4/o.jpg");
		oIcon = new ImageIcon(getScaledImage(oIcon.getImage(), 40, 40));
		// create the board
		center.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE, 3, 2));
		board = new JButton[BOARD_SIZE][BOARD_SIZE];
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board.length; col++) {

				Border thickBorder = new LineBorder(Color.blue, 2);

				board[row][col] = new JButton(" ");
				board[row][col].setBorder(thickBorder);
				board[row][col].setPreferredSize(new Dimension(50, 50));

				board[row][col].addActionListener(listener);
				center.add(board[row][col]);
			}

		displayBoard();
		/*
		 * TODO: 1 From this point on... replace all board sizes (i.e., 3 in loops that
		 * iterate over the board) to board.length
		 */

		bottom.setLayout(new GridLayout(3, 2));

		/*
		 * TODO: 2 Find online 3 different images (*.jpg) to represent a blank, X and O
		 * Create 3 files and save them in the project folder Continue this TODO below
		 * by replacing the JButton text with the icons
		 */

		JLabel labxWins = new JLabel("X Wins: ");
		JLabel laboWins = new JLabel("O Wins: ");
		xWon = new JLabel("0");
		oWon = new JLabel("0");

		bottom.add(labxWins);
		bottom.add(xWon);
		bottom.add(laboWins);
		bottom.add(oWon);
		bottom.add(quitButton);
		bottom.add(undoButton);

		// add all to contentPane

		add(new JLabel("!!!!!!  Super TicTacToe  !!!!"), BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);

	}

	private void displayBoard() {
		iBoard = game.getBoard();

		for (int r = 0; r < board.length; r++)
			for (int c = 0; c < board.length; c++) {

				/*
				 * TODO: 2 (continued) Change these lines of code to set the Icon for each
				 * JButton
				 */

				board[r][c].setIcon(emptyIcon);
				if (iBoard[r][c] == CellStatus.O)
					board[r][c].setIcon(oIcon);

				else if (iBoard[r][c] == CellStatus.X)
					board[r][c].setIcon(xIcon);

				else if (iBoard[r][c] == CellStatus.EMPTY)
					board[r][c].setIcon(emptyIcon);
			}

	}

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (quitButton == e.getSource())
				System.exit(0);

			for (int r = 0; r < board.length; r++)
				for (int c = 0; c < board.length; c++)
					if (board[r][c] == e.getSource() && game.getOK(r, c))
						game.select(r, c);

			displayBoard();

			// NOTE: This code only checks if O wins-- no other win conditions
			// The other win conditions should be added later
			if (game.getGameStatus() == GameStatus.O_WON) {
				JOptionPane.showMessageDialog(null, "O won and X lost!\n The game will reset");
				game.reset();
				displayBoard();
				oWon.setText("" + (Integer.parseInt(oWon.getText()) + 1));
			}
		}
	}
}
