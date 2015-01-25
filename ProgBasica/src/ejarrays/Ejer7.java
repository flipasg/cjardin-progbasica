package ejarrays;

import java.io.IOException;

import consola.Consola;

public class Ejer7{
	
	public static void inicializar(int[] aint) throws IOException{
		for(int i = 0; i<aint.length; i++){
			System.out.println("Dime un número");
			aint[i] = Consola.leeInt();
			while(i>0 && aint[i]<aint[i-1]){
				System.out.println("Dime un número válido");
				aint[i] = Consola.leeInt();
			}
		}
	}
	
	public static void mezclar(int[] aint, int[] aint1, int[] aint2){
		int i1 = 0;
		int i2 = 0;
		for(int i = 0; i<aint.length; ){
			while(i1<aint1.length && i2<aint2.length){
				if(aint1[i1]<=aint2[i2]){
					aint[i] = aint1[i1];
					i1++;
				}else{
					aint[i] = aint2[i2];
					i2++;
				}
				i++;
			}
			if(i1>=aint1.length){
				aint[i] = aint2[i2];
				i2++;
			}else{
				aint[i] = aint1[i1];
				i1++;
			}
			i++;
		}
	}
	
	public static void visualizar(int[] aint){
		for(int i = 0; i<aint.length; i++){
			System.out.print(aint[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		int[] a1 = new int[10];
		int[] a2 = new int[10];
		int[] a3 = new int[20];
		
		inicializar(a1);
		visualizar(a1);
		inicializar(a2);
		visualizar(a2);
		mezclar(a3,a1,a2);
		visualizar(a3);
	}

}
