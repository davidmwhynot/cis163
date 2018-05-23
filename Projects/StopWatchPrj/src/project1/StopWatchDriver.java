package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;

public class StopWatchDriver {
	private JFrame ui;
	private JButton addNewSW_btn = new JButton("Add New StopWatch");
	public StopWatchDriver() {
		JFrame mainFrame = new JFrame(
			"StopWatch | Project 1 | CIS 163"
		);
	    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    mainFrame.setVisible(true);
	    mainFrame.setResizable(true);
	    mainFrame.setLayout(new FlowLayout());
		mainFrame.setPreferredSize(new Dimension(800, 600));
		Container con = mainFrame.getContentPane();
		con.add(addNewSW_btn);
		// addNewSW_btn.addActionListener(new ActionListener(ActionEvent e) {
		//
		// });
		mainFrame.pack();
	}
	public static void main(String[] args) {
		// main method -- thread controller
		System.out.println("testing");
		StopWatch sw1 = new StopWatch("1:0:0");
		StopWatch sw2 = new StopWatch("1:0");
		sw1.add(sw2);
		System.out.println(sw1.toString());

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new StopWatchDriver();
			}
		});
		// StopWatchDriver swd = new StopWatchDriver();
	}
	private JPanel stopWatchPanelFactory() {
		return new JPanel();
	}
}
