package edu.uwec.cs.ernste.threading;

import java.io.*;
import java.util.Date;

public class Logger {
	
	private BufferedWriter bw;
	
	public Logger() {
		try {
			FileWriter fw = new FileWriter("C:/log.txt");
			bw = new BufferedWriter(fw); 
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
	
	public synchronized void log(String s) {
		try {
			bw.write(s + "\t");
			bw.write(new Date() + "");
			bw.newLine();
			//bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
