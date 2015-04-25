package edu.uwec.cs.kunseljp.rsa;

import javax.swing.JOptionPane;

public class RSACrackerLongs {
	
	public static long[] answer = new long[4];
	public static long[] cipher;
	public static String plainText;

	public static void findPrimes(long RSAKey) {
		long currNum = 3;
		while(currNum < RSAKey) {
			int divisor = 3;
			boolean isPrime = true;
			while(divisor * divisor <= currNum) {
				if(currNum % divisor == 0) {
					isPrime = false;
					break;
				}
				divisor = divisor + 2;
			}
			if(isPrime) {
				if(RSAKey % currNum == 0) {
					long predictedKey = RSAKey / currNum;
					if(checkPrime(predictedKey)) {
						answer[0] = predictedKey;
						answer[1] = currNum;
						break;
					}
				}
			}
			currNum = currNum + 2;
		}
	}
	
	public static boolean checkPrime(long n) {
	    int primes55[] = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,
	    73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,
	    181,191,193,197,199,211,223,227,229,233,239,241,251,257};
 
	    for(int i=0;i<55;i++) {
		if (n%primes55[i] == 0) {
			if (n == primes55[i]) {
				return true;
			}
			else {
				return false;
			}
		}
	    }
 
	    long maxtest = n/4;
 
	    for(int i=259; i<maxtest; i+=2)
	        if (n%i == 0)
	            return false;
	    return true;
	}
	
	public static void crackIt(long RSAKey) {
		long start = System.currentTimeMillis();
		findPrimes(RSAKey);
		long factEnd = System.currentTimeMillis();
		findED();
		decrypt(cipher);
		long crackEnd = System.currentTimeMillis();
		JOptionPane.showMessageDialog(null, 
				"P: " + answer[0] + 
				"\nQ: " + answer[1] + 
				"\nE: " + answer[2] + 
				"\nD: " + answer[3] + 
				"\nDecrypted Message: " + plainText +
				"\nPQ Factorization Time: " + ((double)(factEnd-start))/1000 + " seconds!!!" +
				"\nTotal Time Elapsed: " + ((double)(crackEnd-start))/1000 + " seconds!!!", 
				"RSA Cracked!", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void findED() {
		//******************************************************************************
		// Find PQ and phiPQ
		//******************************************************************************
		long p = answer[0];
		long q = answer[1];
		long phiPQ = (p - 1) * (q - 1);

		//******************************************************************************
		// Find E
		//******************************************************************************
		// Generate an E with the following properties:
		// 1.  1 < E < phiPQ
		// 2.  E and phiPQ are relatively prime
		//   --> the above constraint implies that gcd(E, phiPQ) == 1
		// 3.  There may be several candidates for E, so pick the smallest one (for consistency
		//       with the rest of the class -- there is no theoretical reason for this constraint)

		long e = 2;  // We will start at 2 and work our way up until we find an E that meets the constraints

		boolean foundE = false;
		while (!foundE) {

			// The following perform a standard GCD calculation -- Euclid's algorithm

			// Set the initial values of a and b to phiPQ and our current canidate for E
			long a = phiPQ;
			long b = e;

			long r = 1; // Initial starting value so we go through the loop at least once
			while (r != 0) { // When r reaches 0 then the gcd is the b value

				// Put the bigger of a and b into a and the smaller into b
				if (a < b) { // Swap them if they are in the wrong order
					long temp = a;
					a = b;
					b = temp;
				}

				r = a % b;  // Compute the remainder of the bigger / smaller
				a = r; // Replace a with the remainder -- b stays the same
			}
			// Recall the gcd is stored in b at this point
			if (b == 1) { // We are done if the gcd was 1
				foundE = true;
			} else { // Keep looking for an E value that works
				e++;
			}
		}

		//******************************************************************************
		// Find D
		//******************************************************************************
		// Generate D with the following properties:
		// 1.  0 < D <= PQ
		// 2.  (DE-1) is evenly divisible by phiPQ
		//    --> That is count up for D until we find a (DE-1)%phiPQ that equals 0

		long d = 1;  // Init to the starting range of possible D values
		
		// Keep looking until we find a D value that fits the constraints above
		while ((((d * e) - 1) % phiPQ) != 0) {
			d++;
		}
		
		answer[2] = e;
		answer[3] = d;
	}

	public static void decrypt(long[] cipherTextMessage) {
		// To decode we need this cipherTextMessage as well as the private key, (d, n)
		String decodedTextMessage = "";

		// Encrypt each character of the message, one at a time
		for (int i = 0; i < cipherTextMessage.length; i++) {
			// Get the current character to encode and obtain its unicode (int) value
			long cipherValue = cipherTextMessage[i];
			
			// Compute (cipherValue ^ D) mod (PQ)
			// Again this is a problem with blowing the top off the range so we do the same
			//   thing as above.

			long tempD = answer[3];
			long decodedValue = 1;
			while (tempD > 0) {
				
				// If D is odd
				if ( (tempD % 2) == 1 ) {
					decodedValue *= cipherValue;
					decodedValue %= answer[0]*answer[1];
				}
				tempD /= 2;  // Integer division
				cipherValue *= cipherValue;
				cipherValue %= answer[0]*answer[1];
			}
		

			// And then pretend the int is a unicode character and produce a char from it to add to our cipher string
			char decodedCharacter = (char) decodedValue;
			decodedTextMessage += decodedCharacter;
			plainText = decodedTextMessage;
		}
	}

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Please enter the RSA Key you wish to factor.");
		long key = Long.parseLong(input);
		
		// Encrypted Message (using PQ = 82222957)
		cipher = new long[11];
		cipher[0] = 373248;
		cipher[1] = 1030301;
		cipher[2] = 1259712;
		cipher[3] = 1259712;
		cipher[4] = 1367631;
		cipher[5] = 32768;
		cipher[6] = 658503;
		cipher[7] = 1367631;
		cipher[8] = 1481544;
		cipher[9] = 1259712;
		cipher[10] = 1000000;
		
		crackIt(key);
	}

}