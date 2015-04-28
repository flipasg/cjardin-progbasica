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
public class Serie8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int numInicio, n, contBlanco, num;
		String fila;
		
		System.out.println("Dime el número de filas");
		n = Consola.leeInt();
		
		numInicio = 1;
		for(int contFila = 1;contFila<=n;contFila++){
			contBlanco = 1;
			fila = "";
			num = numInicio;
			while(contBlanco<contFila && contFila>1){
				fila+=" \t";
				contBlanco++;
			}
			for(int contColumna = 0;contColumna<contFila+2;contColumna++){
				fila+=(num)+"\t";
				num+=contFila;
			}
			System.out.println(fila);
			numInicio*=2;
		}

	}

}
