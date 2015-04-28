/**
 * 
 */
package EjerInicio3;

import java.io.IOException;

import EjerInicio.Consola;

/**
 * @author dw1_alum9
 *
 */
public class MediaPrimos {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int num1, num2, suma, aux, cont, contPrimos;
		boolean primo;
		
		System.out.println("Dime dos números");
		num1 = Consola.leeInt();
		num2 = Consola.leeInt();
		
		if(num1>num2){
			aux = num1;
			num1 = num2;
			num2 = aux;
		}
		suma = 0;
		contPrimos = 0;
		while(num1<=num2){
			cont = 2;
			primo = true;
			while(primo==true && cont<(num1/2)+1){
				if(num1%cont==0){
					primo = false;
				}
				cont++;
			}
			if(primo){
				suma+=num1;
				contPrimos++;
			}
			num1++;
		}
		System.out.println("La media de los números primos es "+(suma/contPrimos));
	}

}
