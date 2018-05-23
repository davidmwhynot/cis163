package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;

public class StopWatchDriver {
	private JFrame mainFrame;
	private StopWatch mostRecentlyAddedSW;

	private Container con;

	private JPanel swPanel;
	private JPanel btnPanel;

	private JButton addNewSW_btn;
	private JButton suspend_btn;

	private boolean suspendState = false;

	public StopWatchDriver() {
		mainFrame = new JFrame("StopWatch | Project 1 | CIS 163");

		con = mainFrame.getContentPane();

		btnPanel = new JPanel();
		swPanel = new JPanel();

		addNewSW_btn = new JButton("Add New StopWatch");
		suspend_btn = new JButton("Toggle Suspend");


	    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    mainFrame.setVisible(true);
	    mainFrame.setResizable(true);
	    mainFrame.setLayout(new FlowLayout());
		mainFrame.setMinimumSize(new Dimension(800, 600));
		mainFrame.setPreferredSize(new Dimension(1000, 800));
		mainFrame.setMaximumSize(new Dimension(1200, 1000));
		con.add(btnPanel);
		con.add(swPanel);

		btnPanel.setLayout(new FlowLayout());
		btnPanel.setPreferredSize(new Dimension(1000, 100));
		btnPanel.add(addNewSW_btn);
		btnPanel.add(suspend_btn);

		swPanel.setLayout(new FlowLayout());
		swPanel.setPreferredSize(new Dimension(1000, 700));
		addNewSW_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				MyTimerPanel newTimer = new MyTimerPanel();
				mostRecentlyAddedSW = newTimer.getStopWatch();
				swPanel.add(new MyTimerPanel());
				mainFrame.pack();
			}
		});
		suspend_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				suspendState = !suspendState;
				mostRecentlyAddedSW.suspend(suspendState);
			}
		});

		mainFrame.pack();
	}
	public static void main(String[] args) {
		// main method -- thread controller
		StopWatchDriver swd = new StopWatchDriver();
	}
}
