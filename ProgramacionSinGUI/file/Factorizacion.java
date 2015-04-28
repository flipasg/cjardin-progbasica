/**
 * 
 */
package EjerInicio;

import java.io.IOException;

/**
 * @author ik010137ad
 *
 */
public class Factorizacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		int num, div;
		
		System.out.println("Dime el número a factorizar");
		num = Consola.leeInt();
		div=2;
		
		System.out.print(num+"=");
		while(div<(num/2)+1){
			while(num%div==0){
				System.out.print(div+"*");
				num=num/div;
			}
			div++;
		}
	}

}
