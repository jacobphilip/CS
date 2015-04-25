package edu.uwec.cs.kunseljp.rsa;

import java.math.BigInteger;

import javax.swing.JOptionPane;

public class RSACrackerBigIntegers {
	
	public static BigInteger[] answer = new BigInteger[4];
	public static BigInteger[] cipher;
	public static String plainText;
	public static BigInteger pq = new BigInteger("0");

	public static void findPrimes(BigInteger pq2) {
		BigInteger currNum = new BigInteger("3");
		BigInteger zero = new BigInteger("0");
		BigInteger two = new BigInteger("2");
		while(currNum.compareTo(pq2) == -1) {
			BigInteger divisor = new BigInteger("3");
			boolean isPrime = true;
			while(divisor.multiply(divisor).compareTo(currNum) <= -1) {
				if(currNum.remainder(divisor).compareTo(zero) == 0) {
					isPrime = false;
					break;
				}
				divisor = divisor.add(two);
			}
			if(isPrime) {
				if(pq2.remainder(currNum).compareTo(zero) == 0) {
					BigInteger predictedKey = pq2.divide(currNum);
					if(checkPrime(predictedKey)) {
						answer[0] = predictedKey;
						answer[1] = currNum;
						break;
					}
				}
			}
			currNum = currNum.add(two);
		}
	}
	
	public static boolean checkPrime(BigInteger n) {
	    BigInteger[] primes55 = new BigInteger[54];
		primes55[0] = new BigInteger("2");
		primes55[1] = new BigInteger("3");
		primes55[2] = new BigInteger("5");
		primes55[3] = new BigInteger("7");
		primes55[4] = new BigInteger("11");
		primes55[5] = new BigInteger("13");
		primes55[6] = new BigInteger("17");
		primes55[7] = new BigInteger("19");
		primes55[8] = new BigInteger("23");
		primes55[9] = new BigInteger("29");
		primes55[10] = new BigInteger("31");
		primes55[11] = new BigInteger("37");
		primes55[12] = new BigInteger("41");
		primes55[13] = new BigInteger("43");
		primes55[14] = new BigInteger("47");
		primes55[15] = new BigInteger("53");
		primes55[16] = new BigInteger("59");
		primes55[17] = new BigInteger("61");
		primes55[18] = new BigInteger("67");
		primes55[19] = new BigInteger("71");
		primes55[20] = new BigInteger("73");
		primes55[21] = new BigInteger("79");
		primes55[22] = new BigInteger("83");
		primes55[23] = new BigInteger("89");
		primes55[24] = new BigInteger("97");
		primes55[25] = new BigInteger("101");
		primes55[26] = new BigInteger("103");
		primes55[27] = new BigInteger("107");
		primes55[28] = new BigInteger("109");
		primes55[29] = new BigInteger("113");
		primes55[30] = new BigInteger("127");
		primes55[31] = new BigInteger("131");
		primes55[32] = new BigInteger("137");
		primes55[33] = new BigInteger("139");
		primes55[34] = new BigInteger("149");
		primes55[35] = new BigInteger("151");
		primes55[36] = new BigInteger("157");
		primes55[37] = new BigInteger("163");
		primes55[38] = new BigInteger("167");
		primes55[39] = new BigInteger("173");
		primes55[40] = new BigInteger("179");
		primes55[41] = new BigInteger("181");
		primes55[42] = new BigInteger("191");
		primes55[43] = new BigInteger("193");
		primes55[44] = new BigInteger("197");
		primes55[45] = new BigInteger("199");
		primes55[46] = new BigInteger("211");
		primes55[47] = new BigInteger("223");
		primes55[48] = new BigInteger("227");
		primes55[49] = new BigInteger("229");
		primes55[50] = new BigInteger("233");
		primes55[51] = new BigInteger("239");
		primes55[52] = new BigInteger("241");
		primes55[53] = new BigInteger("251");
		primes55[54] = new BigInteger("257");
 
	    for(int i=0;i<55;i++) {
		BigInteger zero = new BigInteger("0");
	    if (n.remainder(primes55[i]).compareTo(zero) == 0) {
			if (n.compareTo(primes55[i]) == 0) {
				return true;
			}
			else {
				return false;
			}
		}
	    }
	 
//		rewrite for BigIntegers
//	    for(int i=259; i<maxtest; i+=2)
//	        if (n%i == 0)
//	            return false;
	    return true;
	}
	
	public static void crackIt(BigInteger pq2) {
		long start = System.currentTimeMillis();
		findPrimes(pq2);
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
		BigInteger p = answer[0];
		BigInteger q = answer[1];
		BigInteger one = new BigInteger("1");
		BigInteger phiPQ = (p.subtract(one)).multiply((q.subtract(one)));
		//******************************************************************************
		// Find E
		//******************************************************************************
		BigInteger e = new BigInteger("2");
		while (phiPQ.gcd(e).compareTo(BigInteger.ONE) > 0) {
			e = e.add(BigInteger.ONE);
		}
		//******************************************************************************
		// Find D
		//******************************************************************************
		BigInteger d = e.modInverse(phiPQ);
		
		answer[2] = e;
		answer[3] = d;
	}

	public static void decrypt(BigInteger[] cipher2) {
		
		// decrypt with: message.modPow(d, n);
	    String decodedMessage = "";
	    BigInteger d = answer[3];
	    
	    for (int i=0; i<cipher.length; i++) {
	    	BigInteger c = cipher[i];
	    	BigInteger m = c.modPow(d, pq);
	    	decodedMessage += (char)(m.intValue());
	    }
	    
	    System.out.println(decodedMessage);
	    plainText = decodedMessage;
		
	}

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Please enter the RSA Key you wish to factor.");
		pq = new BigInteger(input);
		
		cipher = new BigInteger[11];
		cipher[0] = new BigInteger("10030613004288");
		cipher[1] = new BigInteger("4751482659291");
		cipher[2] = new BigInteger("7443142795696");
		cipher[3] = new BigInteger("7443142795696");
		cipher[4] = new BigInteger("2691910187051");
		cipher[5] = new BigInteger("34359738368");
		cipher[6] = new BigInteger("6986863722360");
		cipher[7] = new BigInteger("2691910187051");
		cipher[8] = new BigInteger("4317953005320");
		cipher[9] = new BigInteger("7443142795696");
		cipher[10] = new BigInteger("7784152703731");
		
		crackIt(pq);
	}

}