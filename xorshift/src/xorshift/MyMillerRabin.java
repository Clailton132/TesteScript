package xorshift;

import java.math.BigInteger;
import java.util.Random;

public class MyMillerRabin {

	//Metodo usado para testar se o número é primo.
	//n - Número a ser testado.
	private static boolean MyMillerRabin(BigInteger n, Random r) {
		BigInteger temp = BigInteger.ZERO;
		do {
			temp = new BigInteger(n.bitLength()-1, r);
		} while (temp.compareTo(BigInteger.ONE) <= 0);

		if (!n.gcd(temp).equals(BigInteger.ONE)) return false;

		BigInteger base = n.subtract(BigInteger.ONE);
		BigInteger TWO = new BigInteger("2");

		int k=0;
		while ( (base.mod(TWO)).equals(BigInteger.ZERO)) {
			base = base.divide(TWO);
			k++;
		}

		BigInteger curValue = temp.modPow(base,n);

		if (curValue.equals(BigInteger.ONE))
			return true;

		for (int i=0; i<k; i++) {
			if (curValue.equals(n.subtract(BigInteger.ONE)))
				return true;
			else
				curValue = curValue.modPow(TWO, n);
		} 
		return false;
	}

	public static boolean MillerRabin(BigInteger n, int numTimes) {

		Random r = new Random();
		// Run Miller-Rabin numTimes number of times.
		for (int i=0; i<numTimes; i++) 
			if (!MyMillerRabin(n,r)) return false;

		// If we get here, we assume n is prime. This will be incorrect with
		// a probability no greater than 1/4^numTimes.
		return true;
	}
}
