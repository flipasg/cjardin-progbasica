/**
 * 
 */
package EjerInicio3;

import java.io.IOException;

import EjerInicio.Consola;

/**
 * @author ikk
 *
 */
public class Equis9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		String fila;
		int n;
		
		System.out.println("Dime un numero de filas");
		n = Consola.leeInt();
		for(int contFila = 1;contFila<=n;contFila++){
			fila = "";
			for(int contBlanco = 0; contBlanco<n-contFila;contBlanco++){
				fila+="  ";
			}
			fila+="X X X X";
			System.out.println(fila);
		}


	}

}
