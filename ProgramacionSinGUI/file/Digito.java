/**
 * 
 */
package EjerInicio;

import java.io.IOException;

/**
 * @author ik010137ad
 *
 */
public class Digito {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int num, aux, cont, p, contD, dig;
		
		System.out.println("Dime un número");
		num = Consola.leeInt();
		
		aux = num;
		cont = 0;
		while(aux!=0){
			aux/=10;
			cont++;
		}
		
		System.out.println("Dime que digito es (desde la derecha)");
		p = Consola.leeInt();
		
		while(p<1 || p>cont){
			System.out.println("El dígito no puede ser menor que 1 ni mayor que "+cont);
			p = Consola.leeInt();
		}
		
		contD = 0;
		dig = 0;
		while(contD<p){
			dig = num%10;
			num/=10;
			contD++;
		}
		System.out.println("El dígito es "+dig);
	}

}
