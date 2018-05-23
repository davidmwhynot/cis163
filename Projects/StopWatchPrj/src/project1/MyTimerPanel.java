package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;

public class MyTimerPanel extends JPanel {
	private StopWatch sw;
	private Timer javaTimer;
	private JLabel time = new JLabel("0:00:000");
	private JButton start = new JButton("Start");
	private boolean countingUp = false;
	private boolean countingDown = false;
	private Container con;
	public MyTimerPanel() {
		super();
		nw = new StopWatch();
		con = nw.getContentPane();
		con.setLayout(new FlowLayout());
		con.add(time);
		con.add(start);
		con.pack();
	}
	private void countUp() {
		System.out.println("Start called");
		countingUp = true;
		Thread timeThread = new Thread() {
			@Override
			private void countUp() {
				while(countingUp) {
					long startTime = System.currentTimeMillis();
					for(int i = 0; i < 100; ++i) {
						for(int j = 0; j < 100; ++j) {
							Thread.sleep(1);
						}
					}
					long endTime = System.currentTimeMillis();
					int delta = endTime - startTime();
					sw.add(delta);
				}
			}
		};
		Thread guiUpdateThread = new Thread() {
			@Override
			private void countUp() {

			}
		};
	}
}
