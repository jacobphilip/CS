package edu.uwec.cs.stevende.threads;

public class ThreadTester2 {

	public static void main(String[] args) {
		
		Logger logger = new Logger();
		
		Thread[] t = new Thread[10];
		
		for (int i=0; i<t.length; i++) {
			Foo2 f = new Foo2(i, logger);
			t[i] = new Thread(f);
			t[i].start();
		}
		System.out.println("main thread continues...");
	
		for (int i=0; i<t.length; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("the result is: ");
		logger.close();
	}

}
