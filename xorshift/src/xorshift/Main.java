package xorshift;

import java.math.BigInteger;

public class Main{
	
	public static void main(String arg[]){
		XORShift xor = new XORShift();
		long initialTime = System.currentTimeMillis(); //inicia a contagem do tempo
		MultiplyWithCarry mwc = new MultiplyWithCarry();
		FermatTest ft = new FermatTest();
		MyMillerRabin mr = new MyMillerRabin();
		boolean test = false;
		BigInteger val = null;
		
		int[] valores = {40, 56, 128, 168, 224, 256, 1024, 2048, 4096};
		//int[] valores = {2,3};
		/*for(int cont = 0; cont < valores.length; cont++){
			System.out.println(new BigInteger(valores[cont], xor));
		}*/
		/*for(int cont = 0; cont < valores.length; cont++){
			System.out.println(new BigInteger(valores[cont], mwc));
		}*/
		 
		int contador = 0;
		for(int cont = 0; cont < valores.length; cont++){
			while(!test){
				val = new BigInteger(valores[cont], xor);
				test = mr.MillerRabin(val, 2);
				//System.out.println(test);
				contador = (contador+1);
			}
			System.out.println(val);
			System.out.println(test);
			System.out.println(contador);
			test = false;
		}
		
		long endTime = System.currentTimeMillis(); //finaliza a contagem do tempo

	    //O tempo total decorrido será o tempo final menos o tempo inicial
	    System.out.println("Tempo total em milessegundos: " + (endTime - initialTime)); 
	    System.out.println("Tempo total em segundos: " + (endTime - initialTime)/1000);

		
	}
}
