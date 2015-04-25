package edu.uwec.cs.kunseljp.lab10;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class BitFileWriter {
	
	DataOutputStream dos;
	
	public BitFileWriter(String outputFileName) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream(outputFileName);
		dos = new DataOutputStream(fos);
	}
	
	//method that writes a String of bits
	public void write(String bits) throws IOException {
		String b = bits;
		dos.writeBytes(b);
		
	}
	
	public void close() throws IOException {
		dos.close();
	}

}
