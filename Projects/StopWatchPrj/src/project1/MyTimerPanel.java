package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.util.*;
import java.awt.Color;

public class MyTimerPanel extends JPanel {
	private StopWatch sw;

	private Timer javaTimer;

	private TimerListener timer;

	private JLabel time_lbl;

	private JButton start_btn;
	private JButton stop_btn;
	private JButton save_btn;
	private JButton load_btn;
	private JButton inc_btn;
	private JButton dec_btn;
	private JButton add_btn;
	private JButton sub_btn;
	private JButton reset_btn;
	private JButton _btn;

	private JTextField addSub_inp;

	private JFileChooser fileChooser;
	private int fcReturnVal;

	private static final int INCREMENT = 50;

	public MyTimerPanel() {
		super();
		sw = new StopWatch();
		timer = new TimerListener();
		javaTimer = new Timer(INCREMENT, timer);

		time_lbl = new JLabel("0:00:000");

		start_btn = new JButton("Start");
		stop_btn = new JButton("Stop");
		save_btn = new JButton("Save");
		load_btn = new JButton("Load");
		inc_btn = new JButton("Increment");
		dec_btn = new JButton("Decrement");
		add_btn = new JButton("Add");
		sub_btn = new JButton("Sub");
		reset_btn = new JButton("Reset");

		addSub_inp = new JTextField("0:00:000", 10);

		fileChooser = new JFileChooser();

		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(200, 200));
		add(time_lbl);
		add(start_btn);
		add(stop_btn);
		add(reset_btn);
		add(save_btn);
		add(load_btn);
		add(inc_btn);
		add(dec_btn);
		add(add_btn);
		add(sub_btn);
		add(addSub_inp);

		start_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				javaTimer.start();
			}
		});
		stop_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				javaTimer.stop();
			}
		});
		stop_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				sw.setMinutes(0);
				sw.setSeconds(0);
				sw.setMilliseconds(0);
			}
		});
		save_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fcReturnVal = fileChooser.showDialog(
					 StopWatchDriver.this,
					 "Save"
				 );
				if(fcReturnVal == JFileChooser.APPROVE_OPTION) {
					sw.save(fileChooser.getSelectedFile().getPath());
					update();
				}
			}
		});
		load_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fcReturnVal = fileChooser.showDialog(
					StopWatchDriver.this,
					"Load"
				);
				if(fcReturnVal == JFileChooser.APPROVE_OPTION) {
					sw.load(fileChooser.getSelectedFile().getPath());
					update();
				}
			}
		});
		inc_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				sw.inc();
				update();
			}
		});
		dec_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					sw.dec();
					update();
				} catch(IllegalArgumentException e) {
					JOptionPane.showMessageDialog(
						null,
						"IllegalArgumentException"
					);
				}
			}
		});
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					sw.add(new StopWatch(addSub_inp.getText()));
					update();
				} catch(IllegalArgumentException e) {
					JOptionPane.showMessageDialog(
						null,
						"IllegalArgumentException"
					);
				}
			}
		});
		sub_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					sw.sub(new StopWatch(addSub_inp.getText()));
					update();
				} catch(IllegalArgumentException e) {
					JOptionPane.showMessageDialog(
						null,
						"IllegalArgumentException"
					);
				}
			}
		});

	}

	private void update() {
		time_lbl.setText(sw.toString());
	}

	public StopWatch getStopWatch() {
		return sw;
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			try {
				sw.add(INCREMENT);
				update();
			} catch(Exception e) {
				if(e instanceof IllegalArgumentException) {
					JOptionPane.showMessageDialog(
						null,
						"IllegalArgumentException"
					);
				} else if(e instanceof NumberFormatException) {
					JOptionPane.showMessageDialog(
						null,
						"NumberFormatException"
					);
				} else {
					e.printStackTrace();
				}
			}
		}
	}
}
