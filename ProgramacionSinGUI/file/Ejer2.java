package ejarrays;

import java.io.IOException;
import java.util.Vector;

import consola.Consola;

public class Ejer2{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		Integer numeros[] = new Integer[100];
		int numero;
		int cont = 0;
		//cargamos el array de Integer
		do{
			System.out.println("Dime un numero");
			numero = Consola.leeInt();
			
			numeros[cont] = new Integer(numero);
			cont++;
			
		} while(numero!=0);
		
		//array auxiliar que elimina los elementos null
		Integer numerosAux[] = new Integer[cont];
		
		for(int i = 0; i<numerosAux.length; i++){
			numerosAux[i] = numeros[i];
		}
		for(int i = 0; i<numerosAux.length; i++){
			System.out.print(numerosAux[i]+" ");
		}
		System.out.println();
		
		//copiamos el array auxiliar a la inversa
		Integer numerosCopia[] = new Integer[numerosAux.length];
		int contCopia = 0;
		for(int i = numerosAux.length-1; i>=0; i--){
			numerosCopia[contCopia] = numerosAux[i];
			contCopia++;
		}
		
		//mostramos el array copia
		for(int i = 0; i<numerosCopia.length; i++){
			System.out.print(numerosCopia[i]+" ");
		}
		System.out.println();
		
	}

}
