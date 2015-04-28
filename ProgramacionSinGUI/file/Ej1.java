package ej1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej1 {

	public static void main(String[] args) throws IOException {
		BufferedReader buff = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		BufferedWriter buffWritter = null;
		File binario = new File("nums.bin");
		File texto = new File("nums.txt");
		try {
			buff = new BufferedReader(new InputStreamReader(System.in));
			dos = new DataOutputStream(new FileOutputStream(binario));
			String respuesta = "si";
			int numero = 0;
			do {
				System.out.println("Dime un número entero: ");
				numero = Integer.parseInt(buff.readLine());
				
				
				dos.writeInt(numero);
				
				System.out.println("¿Desea seguir añadiendo números? S/N");
				respuesta = buff.readLine();
			} while (respuesta.toLowerCase().startsWith("s"));
			dos.close();
			dis = new DataInputStream(new FileInputStream(binario));
			buffWritter = new BufferedWriter(new FileWriter(texto));
			int longFichBinario = dis.available()/(Integer.SIZE/8);
			for (int i = 0; i < longFichBinario; i++) {
				buffWritter.write(Integer.toString(dis.readInt()));
				buffWritter.newLine();
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			System.err.println("Error de entrada");
		} finally{
			if(buff!=null) buff.close();
			if(dis!=null) dis.close();
			if(buffWritter!=null) buffWritter.close();
		}

	}

}
