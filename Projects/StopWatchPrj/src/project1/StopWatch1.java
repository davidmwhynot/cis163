// package project1;

public class StopWatch {
	private int minutes;
	private int seconds;
	private int milliseconds;

	public StopWatch() {
		// super();
	}
	public StopWatch(String startTime) {
		 System.out.println("todo");
	}
	public StopWatch(int milliseconds) {
		// super();
		this.milliseconds = milliseconds;
	}
	public StopWatch(int seconds, int milliseconds) {
		// super();
		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}
	public StopWatch(int minutes, int seconds, int milliseconds) {
		// super();
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}


	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}


}
