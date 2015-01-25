package ejarrays;

import java.io.IOException;

import consola.Consola;

public class Ejer1{
	
	static int calcularMedia(int array[]){
		int suma = 0;
		
		for(int i = 0; i<array.length; i++){
			suma+=array[i];
		}
		
		return suma/array.length;
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		int edades[] = new int[10];
		int cont = 0;
		int edad;
		
		for(int i = 0; i<edades.length; i++){
			System.out.println("Dime una edad");
			edad = Consola.leeInt();
			while(edad<0 || edad>100){
				System.out.println("Dime una edad válida");
				edad = Consola.leeInt();
			}
			edades[i] = edad;
		}
		for(int i = 0; i<edades.length; i++){
			System.out.print(edades[i]+" ");
		}
		System.out.println();
		
		int media = calcularMedia(edades);
		System.out.println("La media de las edades es "+media);
		
		int contMayorMedia = 0;
		for(int i = 0; i<edades.length; i++){
			if(edades[i]>media){
				contMayorMedia++;
			}
		}
		System.out.println("Hay "+contMayorMedia+" edades mayores a la media");
		
		int maximo = -5;
		for(int i = 0; i<edades.length; i++){
			if(edades[i]>maximo){
				maximo = edades[i];
			}
		}
		System.out.println("La edad maxima es "+maximo);
		
		int minimo = 102;
		int contMinimo = 0;
		for(int i = 0; i<edades.length; i++){
			if(edades[i]<minimo){
				minimo = edades[i];
				contMinimo = 1;
			}
			else{
				if(edades[i]==minimo){
					contMinimo++;
				}
			}
		}
		System.out.println("La edad minima es "+minimo+" y aparece "+contMinimo+" veces");
	}

}
