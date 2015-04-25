package edu.uwec.cs.ernste.threading;

public class Worker implements Runnable {

	private int n;		//identification number
	private Logger log; //log file
	
	public Worker(int n, Logger log) {
		this.n = n;
		this.log = log;
	}
	
	public void process() {
		//Log your start time
		log.log("start " + n);
		
		//Do some work
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Log your end time
		log.log("end " + n);
	}

	public void run() {
		process();
		
	}
	
}
