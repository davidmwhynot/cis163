package lab2;

public class SimpleCalculator {
	int number;

	public SimpleCalculator() {
		number = 0;
	}

	public SimpleCalculator(int number) {
		this.number = number;
	}

	public double divideByTen() {
		double result = (double)number / 10;
		return result;
	}

	public String toString() {
		String numberString = "" + number;
		System.out.println(numberString);
		return numberString;
	}
}
