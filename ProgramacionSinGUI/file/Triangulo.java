/**
 * 
 */
package EjerInicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ik010137ad
 *
 */
public class Triangulo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int num, cont, cont2, numero, numeroInicio;
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(isr);
		
		System.out.println("Dime el número de filas.");
		num = Integer.parseInt(b.readLine());
		
		cont=0;
		numeroInicio=1;
		
		while(cont<num){
			
			numero=numeroInicio;
			cont2=0;
			while(cont2<=cont){
				
				System.out.print(numero+" ");
				numero-=cont;
				cont2++;
				
			}
			System.out.println("");
			numeroInicio++;
			cont++;
		}
		
		

	}

}
