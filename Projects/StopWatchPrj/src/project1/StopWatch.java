// package project1;

import java.util.*;

public class StopWatch {
	private int minutes;
	private int seconds;
	private int milliseconds;
	private static boolean suspended = false;

	public StopWatch() {
		super();
		minutes = 0;
		seconds = 0;
		milliseconds = 0;
	}
	public StopWatch(String startTime) { // "00:00:00", ":a:a"
		super();
		if(startTime.matches("^(\\d+?:){0,2}\\d+?$")) {
			// process input
			StringTokenizer st = new StringTokenizer(startTime, ":");
			while(st.hasMoreTokens()) {
				System.out.println(st.nextToken());
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
	public StopWatch(int ms) {
		super();
		milliseconds = ms;
	}
	public StopWatch(int sec, int ms) {
		super();
		seconds = sec;
		milliseconds = ms;
	}
	public StopWatch(int min, int sec, int ms) {
		super();
		minutes = min;
		seconds = sec;
		milliseconds = ms;
	}

	private boolean tryCreate(int min, int sec, int ms) {
		return true;
	}

	public void inc() {

	}
	public void dec() {

	}


	public void add(int ms) {

	}
	public void add(StopWatch sw) {

	}

	public void sub(int ms) {

	}
	public void sub(StopWatch sw) {

	}


	public boolean equals(Object o) {
		if(o != null && o instanceof StopWatch) {
			return true;
		} else {
			throw new IllegalArgumentException();
		}
	}
	public static boolean equals(Object sw1, Object sw2) {
		if((sw1 != null) && (sw2 != null) && (sw1 instanceof StopWatch) && (sw2 instanceof StopWatch)) {
			return true;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int compareTo(Object o) {
		if(o != null && o instanceof StopWatch) {
			return 0;
		} else {
			throw new IllegalArgumentException();
		}
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
		return "";
	}

}
