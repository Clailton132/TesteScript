package xorshift;

import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class MultiplyWithCarry extends SecureRandom{

	private long x;
	//valor pr�-definido no exemplo base 
	private final long a = 0xffffda61L;

	//Construtor que utuliza o SecureRandom para "coleta" do n�mero
	public MultiplyWithCarry() {
		SecureRandom sc = new SecureRandom();
		byte[] gs = sc.generateSeed(8);
		ByteBuffer buffer = ByteBuffer.wrap(gs);
		this.x = buffer.getLong();
	}

	public MultiplyWithCarry(long seed) {
		this.x = seed;
	}

	//Metodo ir� gerar n�meros inteiros aleat�rio.
	protected int nextTest(int nbits) {
		long y = this.x & 0xffffffffL;
		y = (a * (y & 0xffffffffL)) + (y >>> 32);
		return (int) y;
	}
}
