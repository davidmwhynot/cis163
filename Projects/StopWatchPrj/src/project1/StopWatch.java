// package project1;

import java.io.*;
import java.util.*;

public class StopWatch {
	private int minutes;
	private int seconds;
	private int milliseconds;
	private static boolean suspended = false;

	public StopWatch() {
		super();
		tryCreate(0, 0, 0);
	}
	public StopWatch(int ms) {
		super();
		tryCreate(0, 0, ms);
	}
	public StopWatch(int sec, int ms) {
		super();
		tryCreate(0, sec, ms);
	}
	public StopWatch(int min, int sec, int ms) {
		super();
		tryCreate(min, sec, ms);
	}
	public StopWatch(String startTime) { // "00:00:00", ":a:a"
		super();
		if(startTime.matches("^(\\d+?:){0,2}\\d+?$")) {
			// process input
			StringTokenizer st = new StringTokenizer(startTime, ":");
			int ms = 0;
			int sec = 0;
			int min = 0;
			if(st.hasMoreTokens()) {
				ms = Integer.parseInt(st.nextToken());
			}
			if(st.hasMoreTokens()) {
				sec = Integer.parseInt(st.nextToken());
			}
			if(st.hasMoreTokens()) {
				min = Integer.parseInt(st.nextToken());
			}
			tryCreate(min, sec, ms);
		} else {
			throw new IllegalArgumentException();
		}
	}

	private void tryCreate(int min, int sec, int ms) {
		if(0 <= ms && ms <= 999) {
			milliseconds = ms;
		} else {
			throw new IllegalArgumentException();
		}
		if(0 <= sec && sec <= 59) {
			seconds = sec;
		} else {
			throw new IllegalArgumentException();
		}
		if(0 <= min) {
			minutes = min;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static int convertDown(int min, int sec, int ms) {
		return (((min * 60) + sec) * 1000) + ms;
	}
	public static int[] convertUp(int ms) {
		int[] temp = {ms / 60000, (ms % 60000) / 1000, (ms % 60000) % 1000};
		return temp;
	}

	public void inc() {
		int[] temp = convertUp(convertDown(minutes, seconds, milliseconds) + 1);
		minutes = temp[0];
		seconds = temp[1];
		milliseconds = temp[2];
	}
	public void dec() {
		int newMS = convertDown(minutes, seconds, milliseconds) - 1;
		if(newMS >= 0) {
			int[] temp = convertUp(newMS);
			minutes = temp[0];
			seconds = temp[1];
			milliseconds = temp[2];
		} else {
			throw new RuntimeException();
		}
	}

	public void add(int ms) {
		if(ms > 0) {
			int[] temp = convertUp(convertDown(minutes, seconds, milliseconds) + ms);
			minutes = temp[0];
			seconds = temp[1];
			milliseconds = temp[2];
		} else {
			throw new IllegalArgumentException();
		}
	}
	public void add(StopWatch sw) {
		int[] temp = convertUp(convertDown(minutes, seconds, milliseconds) + convertDown(sw.getMinutes(), sw.getSeconds(), sw.getMilliseconds()));
		minutes = temp[0];
		seconds = temp[1];
		milliseconds = temp[2];
	}

	public void sub(int ms) {
		if(ms > 0) {
			int newMS = convertDown(minutes, seconds, milliseconds) - ms;
			if(newMS >= 0) {
				int[] temp = convertUp(newMS);
				minutes = temp[0];
				seconds = temp[1];
				milliseconds = temp[2];
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
	public void sub(StopWatch sw) {
		int newMS = convertDown(minutes, seconds, milliseconds) - convertDown(sw.getMinutes(), sw.getSeconds(), sw.getMilliseconds());
		if(newMS >= 0) {
			int[] temp = convertUp(newMS);
			minutes = temp[0];
			seconds = temp[1];
			milliseconds = temp[2];
		} else {
			throw new IllegalArgumentException();
		}
	}


	public boolean equals(Object o) {
		if(o != null && o instanceof StopWatch) {
			return (((StopWatch) o).getMinutes() == minutes) && (((StopWatch) o).getSeconds() == seconds) && (((StopWatch) o).getMilliseconds() == milliseconds);
		} else {
			throw new IllegalArgumentException();
		}
	}
	public static boolean equals(Object sw1, Object sw2) {
		if((sw1 != null) && (sw2 != null) && (sw1 instanceof StopWatch) && (sw2 instanceof StopWatch)) {
			return (((StopWatch) sw1).getMinutes() == ((StopWatch) sw2).getMinutes()) && (((StopWatch) sw1).getSeconds() == ((StopWatch) sw2).getSeconds()) && (((StopWatch) sw1).getMilliseconds() == ((StopWatch) sw2).getMilliseconds());
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int compareTo(Object o) {
		if(o != null && o instanceof StopWatch) {
			int otherMS = convertDown(((StopWatch) o).getMinutes(), ((StopWatch) o).getSeconds(), ((StopWatch) o).getMilliseconds());
			int thisMS = convertDown(minutes, seconds, milliseconds);
			if(otherMS < thisMS) {
				return 1;
			} else if(otherMS > thisMS) {
				return -1;
			} else {
				return 0;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void save(String fName) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fName)));
		out.println(this.toString());
		out.close();
	}
	public void load(String fName) throws IOException {
		Scanner s = new Scanner(new File(fName));
	 	StopWatch temp = new StopWatch(s.nextLine());
		minutes = temp.getMinutes();
		seconds = temp.getSeconds();
		milliseconds = temp.getMilliseconds();
		s.close();
	}

	public static void suspend(boolean flag) {
		suspended = flag;
	}

	public int getMinutes() {
		return minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public int getMilliseconds() {
		return milliseconds;
	}

	public void setMinutes(int n) {
		minutes = n;
	}
	public void setSeconds(int n) {
		seconds = n;
	}
	public void setMilliseconds(int n) {
		milliseconds = n;
	}

	public String toString() {
		return String.format("%d:%02d:%03d", minutes, seconds, milliseconds);
	}

}
