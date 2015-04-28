/**
 * 
 */
package EjerInicio;

import java.io.IOException;

/**
 * @author ik010137ad
 *
 */
public class Hora {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		
		int hora, min;
		
		System.out.println("Dime la hora.");
		hora = Consola.leeInt();
		System.out.println("Dime los minutos.");
		min = Consola.leeInt();
		
		if(hora>12){
			hora-=12; //hora=hora-12;
			System.out.println("La hora es "+hora+":"+min+" PM");
		}
		else{
			System.out.println("La hora es "+hora+":"+min+" AM");
		}
	}

}
