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
public class Productos {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int ident, ventas, suma, iMin, iMax, catMin, catMax, ventasMax, ventasMin, num;
		char cat;
		
		System.out.println("Dime el número de productos");
		num = Consola.leeInt();
		
		iMin = 0;
		iMax = 0;
		suma = 0;
		catMin = 'D';
		catMax = 'D';
		ventasMax = 0;
		ventasMin = 100000;
		
		for(int cont = 0;cont<num;cont++){
			System.out.println("Dime el identificador");
			ident = Consola.leeInt();
			System.out.println("Dime la categoria. A, B o C.");
			cat = Consola.leeChar();
			while(cat!='A' && cat!='B' && cat!='C'){
				System.out.println("Dime la categoria. A, B o C.");
				cat = Consola.leeChar();	
			}
			System.out.println("Dime las ventas de este producto");
			ventas = Consola.leeInt();
			if(cat=='B'){
				suma+=ventas;
			}
			if(ventas>ventasMax){
				iMax = ident;
				catMax = cat;
				ventasMax = ventas;
			}
			if(ventas<ventasMin){
				iMin = ident;
				catMin = cat;
				ventasMin = ventas;
			}
		}
		System.out.println("El total de ventas de la categoría B es "+suma);
		System.out.println("El producto menos vendido es "+iMin+" de la categoría "+catMin+" con ventas de "+ventasMin);
		System.out.println("El producto más vendido es "+iMax+" de la categoría "+catMax+" con ventas de "+ventasMax);
	}

}
