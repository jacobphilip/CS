package edu.uwec.cs.stevende.threads;

import javax.swing.JLabel;

public class Timer implements Runnable {
	
	private boolean run;
	private JLabel display;
	
	public Timer(JLabel display) {
		this.display = display;
	}
	
	public void run() {
		run = true;		
		while (run) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int t = Integer.parseInt(display.getText());
			t++;
			display.setText(t+"");
			System.out.println(t);
		
		}

	}
	
	public Thread start() {
		Thread t = new Thread(this);
		t.start();
		
		return t;
	}
	
	public void stop() {
		run = false;
	}
}
