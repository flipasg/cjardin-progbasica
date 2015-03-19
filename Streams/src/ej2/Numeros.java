package ej2;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Numeros {
	public static int generarUnNumero(int limiteInferior, int limiteSuperior){
		Random r = new Random();
		
		return r.nextInt(limiteSuperior-limiteInferior)+limiteInferior;
	}
	
	public static ArrayList<Integer> generarNumeros(int limiteInferior, int limiteSuperior, int cantidad){
		ArrayList<Integer> numeros = new ArrayList<Integer>(cantidad);
		for (int i = 0; i < cantidad; i++) {
			numeros.add(new Integer(generarUnNumero(limiteInferior, limiteSuperior)));
		}
		
		return numeros;
	}
	
	public static void anadirUnNumero(String fichero, int numero) throws IOException{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero, true));
		
		dos.writeInt(numero);
		
		dos.close();
	}
	
	public static void anadirNumeros(String fichero, ArrayList<Integer> numeros) throws IOException{
		for (Integer i : numeros) {
			anadirUnNumero(fichero, i.intValue());
		}
	}
	
	public static int buscarEnFichero(String fichero, int posicion) throws IOException{
		DataInputStream dis = new DataInputStream(new FileInputStream(fichero));
		for (int i = 0; i < dis.available(); i+=2) {
			System.out.println(dis.readInt());
			if(i==(posicion)) return dis.readInt();
		}
		
		return -1;
	}
	
	public static void verFichero(DataInputStream dis) throws IOException{
		for (int i = 0; i <= dis.available(); i++) {
			System.out.println(dis.readInt());
		}
		dis.close();
	}
	
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		for (int i = 1; i <= 4; i++) {
			numeros.add(i);
		}
		
		anadirNumeros("fich1.bin", numeros);
		anadirUnNumero("fich1.bin", generarUnNumero(1, 5));
		anadirNumeros("fich1.bin", generarNumeros(1, 4, 5));
		
		verFichero(new DataInputStream(new FileInputStream("fich1.bin")));

		
	}
}
