package ej3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;


public class GestionComercial {
	private String nombrefichero;

	/**
	 * @param nombrefichero
	 */
	public GestionComercial(String nombrefichero) {
		this.nombrefichero = nombrefichero;
	}
	
	public void guardaComerciales(ArrayList<Comercial> lc) throws FileNotFoundException, IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombrefichero));
		for (Iterator<Comercial> it = lc.iterator(); it.hasNext();) {
			Comercial c = it.next();
			oos.writeObject(c);
		}
		oos.close();
	}
	
	public void verComerciales() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombrefichero));
		Comercial c;
		do {
			c = (Comercial) ois.readObject();
			System.out.println(c);
		} while (c!=null);
		
		ois.close();
	}
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		GestionComercial gc = new GestionComercial("comerciales.data");
		gc.verComerciales();
	}
}
