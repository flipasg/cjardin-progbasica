package ejarrays;

import java.io.IOException;

import consola.Consola;
import oo3.Loro;

public class ArrayLoros{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		final int N = 4;
		char sexo;
		int edad;
		char region;
		String color;
		String nombreAve;
		String nombreDuenio;
		
		//declaramos los arrays de Loros
		Loro[] aloro1 = new Loro[N];
		Loro[] aloro2 = new Loro[N];
		
		//cargamos loros en el primer array
		System.out.println("Primer array de loros: ");
		for(int i = 0; i<aloro1.length; i++){
			System.out.println("Loro número "+i);
			System.out.println("Cual es su nombre?");
			nombreAve = Consola.leeString().toUpperCase();
			System.out.println("Cual es el nombre de su duenio?");
			nombreDuenio = Consola.leeString().toUpperCase();
			System.out.println("Que sexo tiene el loro? H/M");
			sexo = Consola.leeChar();
			System.out.println("Que edad tiene el loro? 0-99");
			edad = Consola.leeInt();
			System.out.println("De que region es el loro? N/S/E/O");
			region = Consola.leeChar();
			System.out.println("De que color es el loro?");
			color = Consola.leeString();
			aloro1[i] = new Loro(sexo,edad,region,color,nombreAve,nombreDuenio);
		}
		
		//cargamos loros en el segundo array
		System.out.println("Segundo array de loros: ");
		for(int i = 0; i<aloro2.length; i++){
			System.out.println("Loro número "+i);
			System.out.println("Cual es su nombre?");
			nombreAve = Consola.leeString().toUpperCase();
			System.out.println("Cual es el nombre de su duenio?");
			nombreDuenio = Consola.leeString().toUpperCase();
			System.out.println("Que sexo tiene el loro? H/M");
			sexo = Consola.leeChar();
			System.out.println("Que edad tiene el loro? 0-99");
			edad = Consola.leeInt();
			System.out.println("De que region es el loro? N/S/E/O");
			region = Consola.leeChar();
			System.out.println("De que color es el loro?");
			color = Consola.leeString();
			aloro2[i] = new Loro(sexo,edad,region,color,nombreAve,nombreDuenio);
		}
		
		//declaramos el array mezcla
		Loro[] aloro3 = new Loro[aloro1.length+aloro2.length];
		
		//cargamos los loros al array
		int cont = 0;
		for(int i = 0; i<aloro3.length; i+=2){
			aloro3[i] = aloro1[cont];
			aloro3[i+1] = aloro2[cont];
			cont++;
		}
		
		//cantan todos los loros
		for(int i = 0; i<aloro3.length; i++){
			aloro3[i].cantar();
			System.out.println();
		}
		
		//cantan los que empiezan por LOR
		for(int i = 0; i<aloro3.length; i++){
			if(aloro3[i].getNombres().getNombreAve().startsWith("LOR")){
				aloro3[i].cantar();
				System.out.println();
			}
		}
	}

}
