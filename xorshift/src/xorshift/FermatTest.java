package xorshift;

import java.math.BigInteger;

public class FermatTest {

	private static final BigInteger ONE = BigInteger.ONE;
	private XORShift random;
	public FermatTest(){
		this.random = new XORShift();
	}
	public FermatTest(XORShift r){
		this.random = r;
	}


	//Utiliza o teste de primalidade de Fermat para verificar se um número é ou não primo.
	//n - Numero para ser testado.
	//maxInteracao - Numero maximo de interações para chegar o numero testado.
	//Retorna true ou false.
	public boolean isPrime(BigInteger n, int maxInteracao){
		if(n.longValue() <= 1)
			return false;
		if(n.intValue() == 2)
			return true;
		//Numeros pares não são primos
		if(n.intValue() % 2 == 0)
			return false;
		BigInteger n1 = n.subtract(ONE), a = null;
		for(int i = 0; i < maxInteracao; i++){
			// Numero aleatório com nbits
			a = new BigInteger(n.bitLength(), random).abs();
			// a % (n-1) + 1 =&gt; Limita em [1, n-1]
			a = a.mod( n.subtract(ONE) ).add(ONE);
			// a ^ (n-1) % n != 1
			if(a.modPow(n1, n).compareTo(ONE) != 0)
				return false;
		}
		return true;
	}
}