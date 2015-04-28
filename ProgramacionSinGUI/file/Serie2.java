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
public class Serie2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int num, inc;
		String fila, addend;
		
		System.out.println("Dime el número de filas");
		num = Consola.leeInt();
		inc = 0;
		
		for(int contFila = 1;contFila<=num;contFila++){
			fila = "";
			for(int contBlancos = 1;contBlancos<num-inc;contBlancos++){
				fila+="  ";
			}
			if(contFila%2!=0){
				addend = "X ";
			}
			else{
				addend = "Y ";
			}
			for(int contAdd = 1;contAdd<=contFila+inc;contAdd++){
				fila+=addend;
			}
			inc++;
			System.out.println(fila);
		}

	}

}
