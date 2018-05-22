package project1;

public class StopWatchDriver {
	public static void main(String[] args) throws InterruptedException {
		StopWatch sw = new StopWatch("20:10:8");
		System.out.println(sw.toString());
		// try {
		// 	sw.save("file1");
		// } catch(IllegalArgumentException e) {
		// 	e.printStackTrace();
		// 	System.exit(1);
		// }
	}
}
