/**
 * 
 */
package EjerInicio2;

import java.io.IOException;

import EjerInicio.Consola;

/**
 * @author ik010137ad
 *
 */
public class Trayectos {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		char origen, destino, oMin, dMin;
		float kilometros, kMin;
		int num;
		
		System.out.println("Dime e número de trayectos");
		num = Consola.leeInt();
		kMin = 100000;
		oMin = 'a';
		dMin = 'a';
		for(int cont = 0;cont<num;cont++){
			System.out.println("Dime la ciudad origen");
			origen = Consola.leeChar();
			System.out.println("Dime la ciudad destino");
			destino = Consola.leeChar();
			System.out.println("Dime el trayecto");
			kilometros = Consola.leeFloat();
			
			if(kilometros<kMin){
				oMin = origen;
				dMin = destino;
				kMin = kilometros;
			}
		}
		System.out.println("El trayecto más corto es desde "+oMin+" hasta "+dMin+" con un total de "+kMin+" kilometros");
		

	}

}
