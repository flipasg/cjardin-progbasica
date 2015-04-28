package ejarrays;

import java.io.IOException;

import consola.Consola;

public class Ejer5{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		float[] aFloats = new float[10];
		
		for(int i = 0; i<aFloats.length; i++){
			System.out.println("Dime un número");
			aFloats[i] = Consola.leeFloat();
			while(i>0 && aFloats[i]<aFloats[i-1]){
				System.out.println("Dime un número válido");
				aFloats[i] = Consola.leeFloat();
			}
		}
		
		for(int i = 0; i<aFloats.length; i++){
			System.out.print(aFloats[i]+" ");
		}
		System.out.println();
	}

}
