package edu.uwec.cs.stevende.threads;

public class Foo implements Runnable {

	// act like a main
	public void run() {
		System.out.println("Thread started");
		
		// Busy wait
//		for (int i=0; i<1000000000; i++) {
//			// do nothing
//		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread stopped");
	}
	
	

}
