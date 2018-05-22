// package project1;

public class StopWatchDriver {
	public static void main(String[] args) throws InterruptedException {
		StopWatch sw = new StopWatch();
		try {
			long startTime = System.currentTimeMillis();
			long lastTime = System.currentTimeMillis();
			Thread.sleep(1);
			int delta = 1;
			for(int i = 0; i < 100; ++i) {
				for(int j = 0; j < 50; ++j) {
					Thread.sleep(1);
					long newTime = System.currentTimeMillis();
					delta = (int)(newTime - lastTime);
					sw.add(delta);
					lastTime = newTime;
				}
				System.out.println("\t" + sw.toString());
				System.out.println(delta);
			}
			System.out.println("delta: " + (lastTime - startTime));
			System.out.println("done");
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
