package project1;

import java.io.*;
import java.util.*;

/***********************************************************************
Implementation of a StopWatch for project 1 in CIS 163. Tracks
time in minutes, seconds, and milliseconds.

@author David Whynot, Daniel
@version 1.1.0
***********************************************************************/

public class StopWatch {

	/** current number of minutes on the stopwatch */
	private int minutes;

	/** current number of seconds on the stopwatch */
	private int seconds;

	/** current number of milliseconds on the stopwatch */
	private int milliseconds;

	/** state of the stopwatch. if true, mutation of the above fields
	is not allowed! */
	private static boolean suspended = false;


	/*******************************************************************
	 * Create a default stopwatch
	 * @author David Whynot
	*******************************************************************/
	public StopWatch() {
		super();
		tryCreate(0, 0, 0);
	}

	/*******************************************************************
	 * Creates a stopwatch with given milliseconds value.
	 * @author David Whynot
	 * @param ms
	*******************************************************************/
	public StopWatch(int ms) {
		super();
		tryCreate(0, 0, ms);
	}

	/*******************************************************************
	 * Creates a stopwatch with given seconds and milliseconds values.
	 * @author David Whynot
	 * @param sec
	 * @param ms
	*******************************************************************/
	public StopWatch(int sec, int ms) {
		super();
		tryCreate(0, sec, ms);
	}

	/*******************************************************************
	 * Creates a stopwatch with given minutes, seconds, and milliseconds
	 * values.
	 * @author David Whynot
	 * @param min
	 * @param sec
	 * @param ms
	*******************************************************************/
	public StopWatch(int min, int sec, int ms) {
		super();
		tryCreate(min, sec, ms);
	}

	/*******************************************************************
	 * Creates a stopwatch from a time string.
	 * @author David Whynot
	 * @param startTime
	*******************************************************************/
	public StopWatch(String startTime) {
		super();
		if (startTime.matches("^(\\d+?:){0,2}\\d+?$")) {
			StringTokenizer st = new StringTokenizer(startTime, ":");
			ArrayList<Integer> tokens = new ArrayList<Integer>();

			// process input string
			while(st.hasMoreTokens()) {
				tokens.add(Integer.parseInt(st.nextToken()));
			}

			// create stopwatch object with given parameters
			if (tokens.size() == 1) {
				tryCreate(0, 0, tokens.get(0));
			} else if (tokens.size() == 2) {
				tryCreate(0, tokens.get(0), tokens.get(1));
			} else {
				tryCreate(tokens.get(0), tokens.get(1), tokens.get(2));
			}
		} else {
			throw new IllegalArgumentException();
		}
	}


	/*******************************************************************
	 * Trys to create a with the given values.
	 * @author David Whynot
	 * @param min
	 * @param sec
	 * @param ms
	*******************************************************************/
	private void tryCreate(int min, int sec, int ms) {

		/* set the fields to the given values if they are within the
		proper boundaries */
		if (0 <= ms && ms <= 999) {
			milliseconds = ms;
		} else {
			throw new IllegalArgumentException();
		}
		if (0 <= sec && sec <= 59) {
			seconds = sec;
		} else {
			throw new IllegalArgumentException();
		}
		if (0 <= min) {
			minutes = min;
		} else {
			throw new IllegalArgumentException();
		}
	}


	/*******************************************************************
	 * Converts the given stopwatch paramaters down to milliseconds
	 * @author David Whynot
	 * @param min
	 * @param sec
	 * @param ms
	 * @return time in milliseconds
	*******************************************************************/
	private static int convertDown(int min, int sec, int ms) {

		// Example:
		// min: 1, sec: 1, mil: 1 - 61001
		return (((min * 60) + sec) * 1000) + ms;
	}

	/*******************************************************************
	 * Converts a given value in milliseconds up to an array of values.
	 * @author David Whynot
	 * @param ms
	 * @return array with elements 0, 1, and 2 being mins, secs, and ms
	 * respectively
	*******************************************************************/
	private static int[] convertUp(int ms) {

		// Example:
		// 61001 - min: 1, sec: 1, mil: 1
		int[] temp = {
			ms / 60000,
			(ms % 60000) / 1000,
			(ms % 60000) % 1000
		};

		return temp;
	}


	/*******************************************************************
	 *
	 * @author David Whynot
	*******************************************************************/
	public void inc() {
		if (!suspended) {
			if (milliseconds == 999) {
				if (seconds == 59) {
	        		milliseconds = 0;
					seconds = 0;
					++minutes;
				} else {
					milliseconds = 0;
					++seconds;
				}
			} else {
				++milliseconds;
			}
		}
	}

	/*******************************************************************
	 *
	 * @author David Whynot
	*******************************************************************/
	public void dec() {
		if (!suspended) {
			if (milliseconds == 0) {
				if (seconds == 0) {
					if (minutes == 0) {
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


	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param ms
	*******************************************************************/
	public void add(int ms) {
		if (!suspended) {
			if (ms > 0) {
				for(int x = 0; x < ms; ++x) {
					inc();
				}
			} else {
				throw new IllegalArgumentException();
			}
		}
	}

	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param sw
	*******************************************************************/
	public void add(StopWatch sw) {
		if (!suspended) {
			this.add(convertDown(
				sw.getMinutes(),
				sw.getSeconds(),
				sw.getMilliseconds()
			));
		}
	}


	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param ms
	*******************************************************************/
	public void sub(int ms) {
		if (!suspended) {
			if (ms > 0) {
				int newMS =
					convertDown(minutes, seconds, milliseconds) - ms;
				if (newMS >= 0) {
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

	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param sw
	*******************************************************************/
	public void sub(StopWatch sw) {
		if (!suspended) {
			int newMS =
				convertDown(minutes, seconds, milliseconds) -
				convertDown(
					sw.getMinutes(),
					sw.getSeconds(),
					sw.getMilliseconds()
				);
			if (newMS >= 0) {
				int[] temp = convertUp(newMS);
				minutes = temp[0];
				seconds = temp[1];
				milliseconds = temp[2];
			} else {
				throw new IllegalArgumentException();
			}
		}
	}



	/*******************************************************************
	 * @author David Whynot
	 * @see java.lang.Object#equals(java.lang.Object)
	*******************************************************************/
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof StopWatch) {
			return (
					((StopWatch) o).getMinutes() == minutes
				) && (
					((StopWatch) o).getSeconds() == seconds
				) && (
					((StopWatch) o).getMilliseconds() == milliseconds
				);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param sw1
	 * @param sw2
	 * @return
	*******************************************************************/
	public static boolean equals(Object sw1, Object sw2) {
		if (
			(sw1 != null) &&
			(sw2 != null) &&
			(sw1 instanceof StopWatch) &&
			(sw2 instanceof StopWatch)
		) {
			return (
					((StopWatch) sw1).getMinutes() ==
					((StopWatch) sw2).getMinutes()
				) && (
					((StopWatch) sw1).getSeconds() ==
					((StopWatch) sw2).getSeconds()
				) && (
					((StopWatch) sw1).getMilliseconds() ==
					((StopWatch) sw2).getMilliseconds()
				);
		} else {
			throw new IllegalArgumentException();
		}
	}


	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param o
	 * @return
	*******************************************************************/
	public int compareTo(Object o) {
		if (o != null && o instanceof StopWatch) {
			int otherMS = convertDown(
				((StopWatch) o).getMinutes(),
				((StopWatch) o).getSeconds(),
				((StopWatch) o).getMilliseconds()
			);
			int thisMS = convertDown(minutes, seconds, milliseconds);
			if (otherMS < thisMS) {
				return 1;
			} else if (otherMS > thisMS) {
				return -1;
			} else {
				return 0;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}


	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param fName
	*******************************************************************/
	public void save(String fName) {
		try {
			PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter(fName))
			);
			out.println(this.toString());
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param fName
	*******************************************************************/
	public void load(String fName) {
		if (!suspended) {
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


	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param flag
	*******************************************************************/
	public static void suspend(boolean flag) {
		suspended = flag;
	}


	/*******************************************************************
	 *
	 * @author David Whynot
	 * @return
	*******************************************************************/
	public int getMinutes() {
		return minutes;
	}

	/*******************************************************************
	 *
	 * @author David Whynot
	 * @return
	*******************************************************************/
	public int getSeconds() {
		return seconds;
	}

	/*******************************************************************
	 *
	 * @author David Whynot
	 * @return
	*******************************************************************/
	public int getMilliseconds() {
		return milliseconds;
	}


	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param n
	*******************************************************************/
	public void setMinutes(int n) {
		if (!suspended) {
			minutes = n;
		}
	}

	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param n
	*******************************************************************/
	public void setSeconds(int n) {
		if (!suspended) {
			seconds = n;
		}
	}

	/*******************************************************************
	 *
	 * @author David Whynot
	 * @param n
	*******************************************************************/
	public void setMilliseconds(int n) {
		if (!suspended) {
			milliseconds = n;
		}
	}



	/*******************************************************************
	 *
	 * @author David Whynot
	 * @see java.lang.Object#toString()
	*******************************************************************/
	@Override
	public String toString() {
		return String.format(
				"%d:%02d:%03d",
				minutes,
				seconds,
				milliseconds
			);
	}

}
