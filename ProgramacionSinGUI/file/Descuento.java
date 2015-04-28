/**
 * 
 */
package EjerInicio;

import java.io.IOException;

/**
 * @author ik010137ad
 *
 */
public class Descuento {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		float compra;
		
		System.out.println("Dime cuanto has pagado");
		compra = Consola.leeFloat();
		
		if(compra > 100){
			System.out.println(compra*0.80);
		}
		else{
			System.out.println(compra);
		}
	}

}
