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
public class PagosMensuales {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int c, n;
		float total, mensual, d,r;
		
		System.out.println("Numero de meses");
		n = Consola.leeInt();
		System.out.println("Capital");
		c = Consola.leeInt();
		System.out.println("Interés");
		r = Consola.leeFloat();
		
		total = 0;
		d = 1;
		mensual = 0;
		for(int contM = 0;contM<n;contM++){
			d*=(1/(1+(r/100)));
		}
		System.out.println((int)((c*(r/100))/(1-d)*n));
		mensual = (c*(r/100))/(1-(1/d));
		System.out.println("Mensual: "+mensual);
		total+=mensual;
		System.out.println("Total: "+total);
	}

}
