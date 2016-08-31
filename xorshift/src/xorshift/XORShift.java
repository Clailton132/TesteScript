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

	//Função responsável por gerar numeros aleatorios.
	//btis - numero de bits do numero gerado.
	protected int nextTest(int bits) {
		long x = this.nextLong();
		//Deslocamento em bits
		x &= ((1L << bits) -1);
		//Inteiro aleatório com n bits
		return (int) x;
	}

	//Gera um numero long aleatório usando o método XORShift
	@Override
	public long nextLong(){
		x ^= (x << 21);
		x ^= (x >>> 35);
		x ^= (x << 4);
		//Retona um número aleatório.
		return x;
	}
}