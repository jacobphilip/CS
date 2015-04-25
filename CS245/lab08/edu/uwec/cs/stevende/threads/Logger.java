package edu.uwec.cs.stevende.threads;

import java.io.*;

public class Logger {
	private BufferedWriter bw;
	
	public Logger() {
		try {
			FileWriter fw = new FileWriter("C:\\log.txt");
			bw = new BufferedWriter(fw);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void log(String msg) {
		try {
			bw.write(msg);
			bw.write("\t");
			bw.write("at: ");
			bw.write((new java.util.Date()).toString());
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
