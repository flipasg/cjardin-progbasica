
package EjerInicio;

import java.io.IOException;

/**
 * @author ik010137ad
 *
 */
public class NumDigitos {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int num, aux, cont;
		
		System.out.println("Dime un n�mero");
		num = Consola.leeInt();
		
		aux = num;
		cont = 0;
		while(aux!=0){
			aux/=10;
			cont++;
		}
		System.out.println("El n�mero de d�gitos de "+num+" es "+cont);

	}

}
