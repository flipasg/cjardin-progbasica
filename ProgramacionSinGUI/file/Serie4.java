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
public class Serie4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws  IOException{
		int num;
		
		System.out.println("Dime la longitud del cuadrado");
		num = Consola.leeInt();
		
		for(int contFila = 1;contFila<=num;contFila++){
			if(contFila==1 || contFila==num){
				for(int contCol = 1;contCol<=num;contCol++){
					System.out.print("X");
					System.out.print(" ");
				}
			}
			else{
				if(contFila<num){
					for(int contCol = 1;contCol<=num;contCol++){
						if(contCol==1 || contCol==num){
							System.out.print("X");
							System.out.print(" ");
						}
						else{
							if(contCol<num){
								System.out.print(" ");
								System.out.print(" ");
							}
						}

					}
				}
			}
			System.out.print("\n");
		}

	}

}
