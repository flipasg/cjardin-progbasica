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
public class Cruz {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		String fila;
		int n, inc, x;
		System.out.println("Dime el numero de filas");
		x = Consola.leeInt();
		
		n = x/2;
		inc = 4*(n-2);
		
		//parte de arriba
		for(int contFila = 1;contFila<=n;contFila++){
			fila = "";
			if(contFila>1){
				for(int contBlanco = 1; contBlanco<contFila;contBlanco++){
					fila+="  ";
				}
			}
			fila+="X X ";
			if(contFila!=n){
				for(int contBlanco = 0; contBlanco<inc;contBlanco++){
					fila+=" ";
				}
				inc-=4;
				fila+="X X";
			}
			System.out.println(fila);
		}
		
		//parte de abajo
		inc = 0;
		for(int contFila = 1;contFila<=n;contFila++){
			fila = "";
			for(int contBlanco = 0; contBlanco<n-contFila;contBlanco++){
				fila+="  ";
			}
			fila+="X X ";
			if(contFila!=1){
				for(int contBlanco = 0; contBlanco<inc;contBlanco++){
					fila+=" ";
				}
				inc+=4;
				fila+="X X";
			}
			System.out.println(fila);
		}


	}

}
