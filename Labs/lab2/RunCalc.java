public void testToString() {
	SimpleCalculator sc5 = new SimpleCalculator();
	assertTrue(sc5.toString().equals("0.0"));

	SimpleCalculator sc6 = new SimpleCalculator(10);
	assertTrue(sc6.toString().equals("10.0"));

	SimpleCalculator sc7 = new SimpleCalculator(-10);
	assertTrue(sc7.toString().equals("-10.0"));

	SimpleCalculator sc8 = new SimpleCalculator(555);
	assertTrue(sc8.toString().equals("555.0"));
}
}
