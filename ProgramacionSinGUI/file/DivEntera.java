/**
 * 
 */
package EjerInicio;

import java.io.IOException;

/**
 * @author ik010137ad
 *
 */
public class DivEntera {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int cont, num1, num2, aux;
		
		System.out.println("Dime dos números");
		num1 = Consola.leeInt();
		num2 = Consola.leeInt();
		
		if(num2>num1){
			aux = num2;
			num2 = num1;
			num1 = aux;
		}
		if(num1<0){
			num1*=(-1);
		}
		if(num2<0){
			num2*=(-1);
		}
		
		cont = 0;
		while(num1>=num2){
			cont++;
			num1-=num2;
		}
		System.out.println("El resultado es "+cont);
	}

}
