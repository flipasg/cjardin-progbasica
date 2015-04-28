package ej2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Ej2 {
	public static void main(String[] args) throws IOException {
		File f1 = new File(args[0]);
		File f2 = new File(args[1]);
		File f3 = new File(args[2]);
		FileReader fReader = null;
		FileWriter fWriter = null;
		try{
			
			try {
				fReader = new FileReader(f1);
			} catch (FileNotFoundException e) {
				System.err.println("Fichero 1 no encontrado");
				e.printStackTrace();
			}
			
			fWriter = new FileWriter(f2);
			int longitudDisponible = 1;
			while((longitudDisponible = fReader.read()) > 0) fWriter.write(longitudDisponible);
			
			fReader.close();
			fWriter.close();
			
			try {
				fReader = new FileReader(f2);
			} catch (FileNotFoundException e) {
				System.err.println("Fichero 2 no encontrado");
				e.printStackTrace();
			}
			
			fWriter = new FileWriter(f3);
			char[] buff = new char[20];
			while((longitudDisponible = fReader.read(buff)) > 0) fWriter.write(buff, 0, longitudDisponible);
			
			fReader.close();
			fWriter.close();
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		} finally {
			if(fReader!=null) fReader.close();
			if(fWriter!=null) fWriter.close();
		}
	}
}
