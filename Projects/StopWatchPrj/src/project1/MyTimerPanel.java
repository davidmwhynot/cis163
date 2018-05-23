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
}
