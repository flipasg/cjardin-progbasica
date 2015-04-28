/**
 * 
 */
package EjerInicio;

import java.io.IOException;

/**
 * @author ik010137ad
 *
 */
public class Calorias {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		final float REP = 1.66f;
		final float DOR = 1.08f;
		char car;
		float tiempo;
		
		System.out.println("Dime tu estado R/D");
		car = Consola.leeChar();
		while(car!='R' && car!='r' && car!='D' && car!='d'){
			System.out.println("Dime tu estado R/D");
			car = Consola.leeChar();
		}
		System.out.println("Dime el tiempo");
		tiempo = Consola.leeFloat();
		
		if(car=='R' || car=='r'){
			System.out.println(tiempo*REP);
		}
		else{
			System.out.println(tiempo*DOR);
		}
	}

}
