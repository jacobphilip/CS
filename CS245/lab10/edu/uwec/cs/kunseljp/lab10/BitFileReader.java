package edu.uwec.cs.kunseljp.lab10;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class BitFileReader {
	
	DataInputStream dis;
		
	public BitFileReader(String fileName) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		dis = new DataInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		
	}
	
	public String read() throws IOException {
		BufferedInputStream bis = new BufferedInputStream(dis);
		int data = dis.read();
		
		return Integer.toString(data);
		
		
	}
	
	public void close() throws IOException {
		dis.close();
	}
	
	
}
