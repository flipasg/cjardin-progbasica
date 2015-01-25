package arrays;

import java.io.IOException;

import consola.Consola;

public class unidimensional {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Dime la longitud: ");
		final int n = Consola.leeInt();
		float arrayFloat[] = new float[n];
		
		for(int i = 0; i<arrayFloat.length; i++) {
			System.out.println("Dime el elemento "+(i+1)+" del array");
			arrayFloat[i] = Consola.leeFloat();
		}
		for(int i = 0; i<arrayFloat.length; i++){
			System.out.print(arrayFloat[i]+" ");
		}
		System.out.println();
		
		for(int i = arrayFloat.length-1; i>=0; i--){
			System.out.print(arrayFloat[i]+" ");
		}
		System.out.println();

	}

}
