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
public class TarjetaDeCredito {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		final int pPar = 2;
		final int pImpar = 1;
		int num, aux, cont, sum, inc, mult;
		
		System.out.println("Dime un número");
		num = Consola.leeInt();
		
		aux = num;
		cont = 1;
		inc = 0;
		sum = 0;
		while(aux!=0){
			mult = 0;
			if(cont%2!=0){
				mult = (aux%10)*pImpar;
				if(mult>9){
					mult-=9;
				}
				inc = mult;
			}
			else{
				mult = (aux%10)*pPar;
				if(mult>9){
					mult-=9;
				}
				inc = mult;
			}
			sum+=inc;
			aux/=10;
			cont++;
		}
		if(sum%10==0){
			System.out.println("La tarjeta es válida");
		}
		else{
			System.out.println("La tarjeta no es válida");
		}
	}

}
