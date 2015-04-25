
package edu.uwec.cs.kunseljp.lab10;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static String fileName = "edu/uwec/cs/kunseljp/lab10/test.txt";
	
	public static String testString = "1011\n001\n10100\n0001\n1\n01\n11";

	public static void main(String[] args) {
		try {
			// writes the testString to a file
			BitFileWriter bfw = new BitFileWriter(fileName);

			bfw.write(testString);

			bfw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// reads in the testString and prints out the bits in console
		try {
			BitFileReader bfr = new BitFileReader(fileName);

			while (Integer.parseInt(bfr.read()) != -1) {
				System.out.print(bfr.read());
			}

			bfr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
