package xorshift;

import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class XORShift extends SecureRandom {

	private long x;

	public XORShift(){
		SecureRandom sc = new SecureRandom();
		byte[] gs = sc.generateSeed(8);
		ByteBuffer buffer = ByteBuffer.wrap(gs);
		this.x = buffer.getLong();
	}

	public XORShift(long seed){
		this.x = seed;
	}

	//Fun��o respons�vel por gerar numeros aleatorios.
	//btis - numero de bits do numero gerado.
	protected int nextTest(int bits) {
		long x = this.nextLong();
		//Deslocamento em bits
		x &= ((1L << bits) -1);
		//Inteiro aleat�rio com n bits
		return (int) x;
	}

	//Gera um numero long aleat�rio usando o m�todo XORShift
	@Override
	public long nextLong(){
		x ^= (x << 21);
		x ^= (x >>> 35);
		x ^= (x << 4);
		//Retona um n�mero aleat�rio.
		return x;
	}
}