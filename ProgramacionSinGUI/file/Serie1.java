/**
 * 
 */
package EjerInicio4;

import java.io.IOException;

import EjerInicio.Consola;

/**
 * @author ikk
 *
 */
public class Serie1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int num;
		String fila;
		
		System.out.println("Dime el número de filas");
		num = Consola.leeInt();
		
		for(int contFila = 1;contFila<=num;contFila++){
			fila = "";
			for(int contCol = 1;contCol<=contFila;contCol++){
				fila+="X Y ";
			}
			System.out.println(fila);
		}

	}

}
