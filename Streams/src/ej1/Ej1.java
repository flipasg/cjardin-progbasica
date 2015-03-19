package ej1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej1 {
	public static void main(String[] args) throws IOException {
		String carpeta = "img/";
		String fichero = "java1.jpg";
		FileInputStream fis = new FileInputStream(carpeta+fichero);
		FileOutputStream fos = new FileOutputStream(carpeta+fichero.split("\\.")[0]+"_CPY."+fichero.split("\\.")[1]);
		
		int r;
		while((r = fis.read())!=-1){
			fos.write(r);
		}
		
		fos.close();
		fis.close();
		
	}
}
