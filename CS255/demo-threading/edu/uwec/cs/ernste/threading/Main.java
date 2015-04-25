package edu.uwec.cs.ernste.threading;

import java.util.concurrent.Semaphore;

public class Main {

	
	public static void main(String[] args) {
		System.out.println("start");
		Logger log = new Logger();
		
		Worker w1 = new Worker(3, log);
		Worker w2 = new Worker(4, log);
		Worker w3 = new Worker(5, log);
		
		Thread th1 = new Thread(w1);
		th1.start(); // forks off the new thread
		
		Thread th2 = new Thread(w2);
		th2.start(); // forks off the new thread
		
		Thread th3 = new Thread(w3);
		th3.start(); // forks off the new thread

		try {
			th1.join();  // Blocks until th1 finishes
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Do not do until all 3 threads have finished
		log.close();
		System.out.println("end");
		
//		// Create a semaphore with 1 permit
//		Semaphore s = new Semaphore(1);
//		
//		// Try to acquire a single permit
//		// Block if we can't get one
//		try {
//			s.acquire(2);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// Release a permit back to the sema
//		s.release(1);
		
	}

}
