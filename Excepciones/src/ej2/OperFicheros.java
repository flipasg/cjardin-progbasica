package ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OperFicheros {
	
	public static long verTamanio(String nombrefichero) throws IOException{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(nombrefichero);
			long longitud = fis.available();
			fis.close();
			return longitud;
		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
		} finally {
			if(fis != null) fis.close();
		}
		
		return -1;
		
	}
	
	public static ArrayList<String> copiaLineas(String nombrefichero) throws IOException {
		ArrayList<String> lineas = new ArrayList<String>();
		BufferedReader buffReader = new BufferedReader(new FileReader(nombrefichero));
		String linea = "";
		while ((linea = buffReader.readLine()) != null) lineas.add(linea);
		buffReader.close();
		return lineas;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Dime un nombre de fichero");
			String nombrefichero = buffReader.readLine();
			System.out.println(verTamanio(nombrefichero));
			
			System.out.println("Dime otro nombre de fichero");
			nombrefichero = buffReader.readLine();
			try {
				System.out.println(copiaLineas(nombrefichero));
			} catch (FileNotFoundException e) {
				System.err.println("El fichero no existe");
			} catch (IOException e) {
				System.err.println("Error de entrada/salida");
			}
			
			
		} 
		catch (NumberFormatException  e) {} 
		catch (IOException e) {}
		finally {
			if(buffReader != null) buffReader.close();
		}
	}
}
