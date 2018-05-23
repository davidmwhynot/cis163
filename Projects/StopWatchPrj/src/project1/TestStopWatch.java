package project1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/*********************************************************************
 *
 * The following are simple random JUnit test cases... After talking with your
 * instructor, create many, many more that shows that your code is functioning
 * correctly.
 *
 */
// TODO: add test case that tries to save to permission restricted directory (ie
// /root, /system, etc.)
// default constructor test

/************************************************************************
 * CIS 163 Project 1- StopWatch Shared Test Cases
 * 
 * @author Nate Tubergen, Gabe Guilbee Due: 5/23/18
 ************************************************************************/

public class TestStopWatch {

	@Test
	public void testConstructorS() {
		StopWatch s = new StopWatch(5, 10, 300);
		assertEquals(s.toString(), "5:10:300");

		s = new StopWatch("20:10:8");
		assertEquals(s.toString(), "20:10:008");

		s = new StopWatch("20:8");
		assertEquals(s.toString(), "0:20:008");

		s = new StopWatch("8");
		assertEquals(s.toString(), "0:00:008");

	}

	@Test
	public void testAddMethodS() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		s1.add(2000);
		assertEquals(s1.toString(), "6:01:300");

		s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(2, 2, 300);
		s1.add(s2);
		System.out.println(s1);
		assertEquals(s1.toString(), "8:01:600");

		for (int i = 0; i < 15000; i++)
			s1.inc();
		System.out.println(s1);
		assertEquals(s1.toString(), "8:16:600");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testContuctor() {
		@SuppressWarnings("unused")
		StopWatch d1 = new StopWatch("2,-3,-3");
	}

	@Test
	public void testEqualS() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(6, 01, 200);
		StopWatch s3 = new StopWatch(5, 50, 200);
		StopWatch s4 = new StopWatch(5, 59, 300);

		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s4));

		assertTrue(s2.compareTo(s1) > 0);
		assertTrue(s3.compareTo(s1) < 0);
		assertTrue(s1.compareTo(s4) == 0);

	}

	@Test
	public void testEqual2() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(6, 01, 200);
		StopWatch s3 = new StopWatch(5, 50, 200);
		StopWatch s4 = new StopWatch(5, 59, 300);

		assertFalse(StopWatch.equals(s1, s2));
		assertFalse(StopWatch.equals(s1, s3));
		assertTrue(StopWatch.equals(s1, s4));
		assertFalse(StopWatch.equals(s2, s3));
		assertFalse(StopWatch.equals(s2, s4));
		assertFalse(StopWatch.equals(s3, s4));

	}

	@Test
	public void testCompareToS() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(6, 01, 200);
		StopWatch s3 = new StopWatch(5, 50, 200);
		StopWatch s4 = new StopWatch(5, 59, 300);

		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s4));

		assertTrue(s2.compareTo(s1) > 0);
		assertTrue(s3.compareTo(s1) < 0);
		assertTrue(s1.compareTo(s4) == 0);

	}

	@Test
	public void testLoadSaveS() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		assertEquals(s1.toString(), "5:59:300");

		s1.save("file1");
		s1 = new StopWatch();
		assertEquals(s1.toString(), "0:00:000");

		s1.load("file1");
		assertEquals(s1.toString(), "5:59:300");

	}

	@Test
	public void testToString() {
		StopWatch s1 = new StopWatch();
		assertEquals(s1.toString(), "0:00:000");

		StopWatch s2 = new StopWatch(1234, 53, 867);
		assertEquals(s2.toString(), "1234:53:867");

		StopWatch s3 = new StopWatch(0, 0, 0);
		assertEquals(s3.toString(), "0:00:000");

		StopWatch s4 = new StopWatch(1, 1, 1);
		assertEquals(s4.toString(), "1:01:001");

		StopWatch s5 = new StopWatch(22, 30, 900);
		assertEquals(s5.toString(), "22:30:900");
	}

	@Test
	public void testDefaultConstructorS() {
		StopWatch s = new StopWatch();
		assertEquals(s.toString(), "0:00:000");
	}

	@Test
	public void testConstructorMin() {
		StopWatch s = new StopWatch(0, 0, 0);
		assertEquals(s.toString(), "0:00:000");

		s = new StopWatch(1, 0, 0);
		assertEquals(s.toString(), "1:00:000");

		s = new StopWatch(1, 1, 0);
		assertEquals(s.toString(), "1:01:000");

		s = new StopWatch(1, 1, 1);
		assertEquals(s.toString(), "1:01:001");

		s = new StopWatch(23, 59, 999);
		assertEquals(s.toString(), "23:59:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorMin1() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(0, 0, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorMin2() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(0, -1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorMin3() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(-1, 0, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorMin4() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(-1, -1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorMin5() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(99, 1, 1000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorMin6() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(99, 1, 1001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorMin7() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(99, 60, 999);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorMin8() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(99, 61, 999);
	}

	@Test
	public void testConstructorSec() {
		StopWatch s = new StopWatch(0, 0);
		assertEquals(s.toString(), "0:00:000");

		s = new StopWatch(1, 0);
		assertEquals(s.toString(), "0:01:000");

		s = new StopWatch(1, 1);
		assertEquals(s.toString(), "0:01:001");

		s = new StopWatch(59, 999);
		assertEquals(s.toString(), "0:59:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorSec1() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(0, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorSec2() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(-1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorSec3() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(1, 1000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorSec4() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(1, 1001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorSec5() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(60, 999);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorSec6() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(61, 999);
	}

	@Test
	public void testConstructorMilli() {
		StopWatch s = new StopWatch(0);
		assertEquals(s.toString(), "0:00:000");

		s = new StopWatch(1);
		assertEquals(s.toString(), "0:00:001");

		s = new StopWatch(999);
		assertEquals(s.toString(), "0:00:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorMilli1() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorMilli2() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(1000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorMilli3() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch(1001);
	}

	@Test
	public void testConstructorString() {
		StopWatch s = new StopWatch("0:0:0");
		assertEquals(s.toString(), "0:00:000");

		s = new StopWatch("1:1:1");
		assertEquals(s.toString(), "1:01:001");

		s = new StopWatch("9999:59:999");
		assertEquals(s.toString(), "9999:59:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorString1() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch("0:0:-1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorString2() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch("0:-1:0");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorString3() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch("-1:0:0");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorString4() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch("-1:-1:-1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorString5() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch("0:0:1000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorString6() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch("0:0:1001");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorString7() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch("0:60:0");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorString8() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch("0:61:0");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testErrorString9() {
		@SuppressWarnings("unused")
		StopWatch s = new StopWatch("654:654:654");
	}

	/************************************************************************
	 * CIS 163 Project 1- StopWatch
	 * 
	 * @author Daniel Pfahler, David Whynot Due: 5/23/18
	 ************************************************************************/
	@Test
	public void testDefaultConstructor() {
		StopWatch s = new StopWatch();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}

	@Test
	public void testConstructor3Parameters() {
		StopWatch s = new StopWatch(2, 3, 4);
		assertTrue(s.getMinutes() == 2);
		assertTrue(s.getSeconds() == 3);
		assertTrue(s.getMilliseconds() == 4);
	}

	@Test
	public void testConstructor3Parameters2() {
		StopWatch s = new StopWatch(05, 04, 04);
		assertTrue(s.getMinutes() == 5);
		assertTrue(s.getSeconds() == 4);
		assertTrue(s.getMilliseconds() == 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3e2Parameters() {
		StopWatch s = new StopWatch(12, 67, 14);
	}

	@Test
	public void testConstructor1() {
		StopWatch s = new StopWatch(5, 10, 300);
		assertEquals(s.toString(), "5:10:300");
	}

	@Test
	public void testConstructor2() {
		StopWatch s = new StopWatch("20:10:8");
		assertEquals(s.toString(), "20:10:008");
	}

	@Test
	public void testConstructor3() {
		StopWatch s = new StopWatch("20:8");
		assertEquals(s.toString(), "0:20:008");
	}

	@Test
	public void testConstructor4() {
		StopWatch s = new StopWatch("8");
		assertEquals(s.toString(), "0:00:008");
	}

	// There can only be one test here
	// no more lines of code after "new StopWatch("-2");"
	@Test(expected = IllegalArgumentException.class)
	public void testNegSingleInput2() {
		new StopWatch(-2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegDouble1Input() {
		new StopWatch("-59:-23");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegDouble2aInput() {
		new StopWatch("2:-2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAlphaInput() {
		new StopWatch("a");
	}

	@Test
	public void testAddMethod() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		s1.add(2000);
		assertEquals(s1.toString(), "6:01:300");

		s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(2, 2, 300);
		s1.add(s2);
		System.out.println(s1);
		assertEquals(s1.toString(), "8:01:600");

		for (int i = 0; i < 15000; i++)
			s1.inc();
		System.out.println(s1);
		assertEquals(s1.toString(), "8:16:600");
	}

	@Test
	public void testEqual() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(6, 01, 200);
		StopWatch s3 = new StopWatch(5, 50, 200);
		StopWatch s4 = new StopWatch(5, 59, 300);

		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s4));

		assertTrue(s2.compareTo(s1) > 0);
		assertTrue(s3.compareTo(s1) < 0);
		assertTrue(s1.compareTo(s4) == 0);

	}

	@Test
	public void testCompareTo() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(6, 01, 200);
		StopWatch s3 = new StopWatch(5, 50, 200);
		StopWatch s4 = new StopWatch(5, 59, 300);

		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s4));

		assertTrue(s2.compareTo(s1) > 0);
		assertTrue(s3.compareTo(s1) < 0);
		assertTrue(s1.compareTo(s4) == 0);

	}

	@Test
	public void testLoadSave() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);

		s1.save("file1");
		s1 = new StopWatch(); // resets to zero

		s1.load("file1");
		assertTrue(s1.equals(s2));
	}

	@Test
	public void testMutate() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);

		StopWatch.suspend(true);
		s1.add(1000);
		assertTrue(s1.equals(s2));
		StopWatch.suspend(false);
	}

	@Test
	public void equalsTest() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);

		assertEquals(s1, s2);
	}

	@Test
	public void testInc() {
		StopWatch sw = new StopWatch();
		for (int i = 0; i > 0; i++) {
			for (int g = 0; g < 99999; g++) {
				sw.inc();
			}
		}
	}
}
