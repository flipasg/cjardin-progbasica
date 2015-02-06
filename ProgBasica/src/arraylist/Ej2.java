/**
 * 
 */
package arraylist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import oo6.Consola;

/**
 * @author ikk
 *
 */
public class Ej2 {
	private ArrayList<Punto> alPunto;
	
	
	public Ej2() throws IOException{
		cargar();
	}
	
	/**
	 * @param alPunto
	 */
	public Ej2(ArrayList<Punto> alPunto){
		this.alPunto = alPunto;
	}
	
	private void cargar() throws IOException{
		String res = "";
		do {
			System.out.println("Dime las coordenadas del Punto a añadir");
			System.out.println("X: ");
			int x = Consola.leeInt();
			System.out.println("Y: ");
			int y = Consola.leeInt();
			
			alPunto.add(new Punto(x, y));
			
			do {
				System.out.println("Seguir añadiendo puntos? S/N");
				res = Consola.leeString().toUpperCase();
			} while (!res.equals("N") && !res.equals("S"));
			
			
		} while (!res.equals("N"));
	}
	
	public void ver(){
		for (Punto p : alPunto) {
			System.out.print(p.toString());
		}
		System.out.println();
	}
	
	/**
	 * @return the reverse ArrayList<Punto>
	 */
	public ArrayList<Punto> invertir(){
		ArrayList<Punto> auxP = new ArrayList<Punto>();
		for (int i = alPunto.size()-1;i>=0;i--) {
			auxP.add(alPunto.get(i));
		}
		return auxP;
		
	}
	
	
	
	/**
	 * @return the Punto
	 */
	public Punto puntoSegundoCuadrante(){
		Iterator<Punto> it = alPunto.iterator();
		while (it.hasNext()) {
			Punto punto = (Punto) it.next();
			if(punto.getX()<0 && punto.getY()>0){
				return punto;
			}
		}
		return null;
	}
	
	
	
	public void puntoOrigen(){
		boolean encontrado = false;
		for (int i = 0; i < alPunto.size() && !encontrado; i++) {
			if(alPunto.get(i).getX()==0 && alPunto.get(i).getY()==0){
				System.out.println("Indice: "+i);
				encontrado = true;
			}
		}
		if(!encontrado){
			System.out.println("El ArrayList no tiene Puntos de origen (0,0)");
		}
	}
	
	
	
	public void puntoUno(){
		boolean encontrado = false;
		for (Punto p : alPunto) {
			if(p.equals(new Punto(1, 1))){
				System.out.println("Esta contenido");
				encontrado = true;
			}
		}
		if(!encontrado){
			System.out.println("El ArrayList no tiene Puntos de origen (0,0)");
		}
	}
	
	
	public void borrarPuntos4(){
		Iterator<Punto> it = alPunto.iterator();
		while (it.hasNext()) {
			Punto punto = (Punto) it.next();
			if(punto.getX()>0 && punto.getY()<0){
				it.remove();
			}
		}
	}
	
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Ej2 ej2 = new Ej2();
		ej2.ver();

	}

}
