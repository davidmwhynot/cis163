package project1;

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
			// "12:13"
			StringTokenizer st = new StringTokenizer(startTime, ":");
			ArrayList<Integer> tokens = new ArrayList<Integer>();
			while(st.hasMoreTokens()) {
				tokens.add(Integer.parseInt(st.nextToken()));
			}
			if(tokens.size() == 1) {
				tryCreate(0, 0, tokens.get(0));
			} else if(tokens.size() == 2) {
				tryCreate(0, tokens.get(0), tokens.get(1));
			} else {
				tryCreate(tokens.get(0), tokens.get(1), tokens.get(2));
			}
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

	private static int convertDown(int min, int sec, int ms) {
		return (((min * 60) + sec) * 1000) + ms;
	}
	private static int[] convertUp(int ms) { // 61001 - min: 1, sec: 1, mil: 1
		int[] temp = {ms / 60000, (ms % 60000) / 1000, (ms % 60000) % 1000};
		return temp;
	}

	public void inc() {
		if(!suspended) {
			// if(milliseconds == 999) {
			// 	if(seconds == 59) {
			// 		milliseconds = 0;
			// 		seconds = 0;
			// 		++minutes;
			// 	} else {
			// 		milliseconds = 0;
			// 		++seconds;
			// 	}
			// } else {
			// 	++milliseconds;
			// }
			int[] temp = convertUp(convertDown(minutes, seconds, milliseconds) + 1);
			minutes = temp[0];
			seconds = temp[1];
			milliseconds = temp[2];
		}
	}
	public void dec() {
		if(!suspended) {
			if(milliseconds == 0) {
				if(seconds == 0) {
					if(minutes == 0) {
						throw new IllegalArgumentException();
					} else {
						--minutes;
						seconds = 59;
						milliseconds = 999;
					}
				} else {
					--seconds;
					milliseconds = 999;
				}
			} else {
				--milliseconds;
			}
		}
	}

	public void add(int ms) {
		if(!suspended) {
			if(ms > 0) {
				for(int x = 0; x < ms; ++x) {
					inc();
				}
			} else {
				throw new IllegalArgumentException();
			}
		}
	}
	public void add(StopWatch sw) {
		if(!suspended) {
			this.add(convertDown(sw.getMinutes(), sw.getSeconds(), sw.getMilliseconds()));
		}
	}

	public void sub(int ms) {
		if(!suspended) {
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
	}
	public void sub(StopWatch sw) {
		if(!suspended) {
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

	public void save(String fName) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fName)));
			out.println(this.toString());
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	public void load(String fName) {
		if(!suspended) {
			try {
				Scanner s = new Scanner(new File(fName));
			 	StopWatch temp = new StopWatch(s.nextLine());
				minutes = temp.getMinutes();
				seconds = temp.getSeconds();
				milliseconds = temp.getMilliseconds();
				s.close();
			} catch(IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
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
		if(!suspended) {
			minutes = n;
		}
	}
	public void setSeconds(int n) {
		if(!suspended) {
			seconds = n;
		}
	}
	public void setMilliseconds(int n) {
		if(!suspended) {
			milliseconds = n;
		}
	}

	public String toString() {
		return String.format("%d:%02d:%03d", minutes, seconds, milliseconds);
	}

}
