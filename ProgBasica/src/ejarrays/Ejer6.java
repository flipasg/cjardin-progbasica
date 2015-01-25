package ejarrays;

import java.io.IOException;

import consola.Consola;

public class Ejer6{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		
		//declaramos los tres arrays de enteros
		int[] aint1 = new int[10];
		int[] aint2 = new int[10];
		int[] aint3 = new int[aint1.length+aint2.length];
		
		//cargamos el primer array de enteros
		System.out.println("Primer array:");
		for(int i = 0; i<aint1.length; i++){
			System.out.println("Dime un número");
			aint1[i] = Consola.leeInt();
			while(i>0 && aint1[i]<aint1[i-1]){
				System.out.println("Dime un número válido");
				aint1[i] = Consola.leeInt();
			}
		}
		
		//mostramos el array
		for(int i = 0; i<aint1.length; i++){
			System.out.print(aint1[i]+" ");
		}
		System.out.println();
		
		//cargamos el segundo array de enteros
		System.out.println("Segundo array:");
		for(int i = 0; i<aint2.length; i++){
			System.out.println("Dime un número");
			aint2[i] = Consola.leeInt();
			while(i>0 && aint2[i]<aint2[i-1]){
				System.out.println("Dime un número válido");
				aint2[i] = Consola.leeInt();
			}
		}
		
		//mostramos el array
		for(int i = 0; i<aint2.length; i++){
			System.out.print(aint2[i]+" ");
		}
		System.out.println();
		
		//cargamos el array mezcla
		int i1 = 0;
		int i2 = 0;
		for(int i = 0; i<aint3.length; ){
			while(i1<aint1.length && i2<aint2.length){
				if(aint1[i1]<=aint2[i2]){
					aint3[i] = aint1[i1];
					i1++;
				}else{
					aint3[i] = aint2[i2];
					i2++;
				}
				i++;
			}
			if(i1>=aint1.length){
				aint3[i] = aint2[i2];
				i2++;
			}else{
				aint3[i] = aint1[i1];
				i1++;
			}
			i++;
		}
		
		//visualizamos la mezcla
		for(int i = 0; i<aint3.length; i++){
			System.out.print(aint3[i]+" ");
		}
		System.out.println();
	}

}
