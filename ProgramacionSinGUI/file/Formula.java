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
public class Formula {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int num, i, fact, factI, factNI, aux;
		
		System.out.println("Dime dos numeros");
		num = Consola.leeInt();
		i = Consola.leeInt();
		
		if(num<i){
			aux = num;
			num = i;
			i = aux;
		}
		
		System.out.println("N será "+num);
		System.out.println("I será "+i);
		
		fact = 1;
		factI = 1;
		factNI = 1;
		for(int cont = 2;cont<=num;cont++){
			fact*=cont;
			if(cont==i){
				factI = fact;
			}
			if(cont==(num-i)){
				factNI = fact;
			}
		}
		System.out.println("El resultado es "+(fact/(factI*factNI)));

	}

}
