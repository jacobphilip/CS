package edu.uwec.cs.stevende.threads;

public class Foo2 implements Runnable {

	private int id;
	private Logger logger;
	
	public Foo2(int id, Logger logger) {
		this.id = id;
		this.logger = logger;
	}
	
	// act like a main
	public void run() {
		System.out.println(id + " started");
		
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
		
		logger.log("Process " + id + " completed");
		
		
		System.out.println(id + " stopped");
	}
	
	

}
