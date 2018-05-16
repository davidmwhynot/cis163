package lab2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSimpleCalculator {

	@Test
	public void testDivideByTen() {
		SimpleCalculator sc1 = new SimpleCalculator();
		assertTrue(sc1.divideByTen() == 0);

		SimpleCalculator sc2 = new SimpleCalculator(10);
		assertTrue(sc2.divideByTen() == 1);

		SimpleCalculator sc3 = new SimpleCalculator(-10);
		assertTrue(sc3.divideByTen() == -1);

		SimpleCalculator sc4 = new SimpleCalculator(555);
		assertTrue(sc4.divideByTen() == 55.5);
	}

	@Test
	public void testToString() {
		SimpleCalculator sc5 = new SimpleCalculator();
		assertTrue(sc5.toString().equals("0"));

		SimpleCalculator sc6 = new SimpleCalculator(10);
		assertTrue(sc6.toString().equals("10"));

		SimpleCalculator sc7 = new SimpleCalculator(-10);
		assertTrue(sc7.toString().equals("-10"));

		SimpleCalculator sc8 = new SimpleCalculator(555);
		assertTrue(sc8.toString().equals("555"));
	}

}
