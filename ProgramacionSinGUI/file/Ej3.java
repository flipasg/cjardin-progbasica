package Ej3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej3 {
	public static void main(String[] args) throws IOException {
		BufferedReader buffReader = null;
		BufferedWriter buffWriter =  null;
		try {
			buffReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Dime el nombre del archivo: ");
			File f = new File(buffReader.readLine());
			buffWriter = new BufferedWriter(new FileWriter(f));
			String respuesta = "";
			do {
				System.out.println("Dime una cadena de carácteres: ");
				respuesta = buffReader.readLine();
				String respuestaInversa = "";
				for (int i = respuesta.length()-1; i >= 0 ; i--) {
					respuestaInversa+=respuesta.charAt(i);
				}
				int longitudInversa = respuestaInversa.length();
				if(longitudInversa>=30) respuestaInversa = respuestaInversa.substring(longitudInversa-30);
				
				buffWriter.write(respuestaInversa);
				buffWriter.newLine();
				
				System.out.println("¿Desea seguir añadiendo números? S/N");
				respuesta = buffReader.readLine();
			} while (respuesta.toLowerCase().startsWith("s"));
			
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		} finally {
			if(buffWriter!=null) buffWriter.close();
			if(buffReader!=null) buffReader.close();
		}
	}
}
