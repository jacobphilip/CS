package edu.uwec.cs.stevende.threads;

public class ThreadTester {
	
	public ThreadTester() {
		Foo f = new Foo();
		//f.run();  // calls 'run' in the current thread
		Thread t = new Thread(f);
		
		t.start();  // fork off a new thread

//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("main");
		System.out.println("main2");
		
		
	}

	public static void main(String[] args) {
		new ThreadTester();
	}
}
