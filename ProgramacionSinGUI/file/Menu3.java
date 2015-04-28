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
public class Menu3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int r, v1, v2, v11, v12, v21, v22;
		
		do{
			System.out.println("1.-Calcular el módulo de un vector");
			System.out.println("2.-Calcular el producto escalar de dos vectores");
			System.out.println("3.-Fin del programa");
			
			System.out.println("Dime una opción");
			r = Consola.leeInt();
			while(r<1 || r>3){
				System.out.println("Dime una opción válida");
				r = Consola.leeInt();
			}
			
			if(r==1){
				System.out.println("Dime los componentes del vector (coordenadas)");
				v1 = Consola.leeInt();
				v2 = Consola.leeInt();
				
				System.out.println("El módulo del vector es "+Math.sqrt(v1*v1+v2*v2));
			}
			if(r==2){
				System.out.println("Dime los componentes del primer vector (coordenadas)");
				v11 = Consola.leeInt();
				v12 = Consola.leeInt();
				System.out.println("Dime los componentes del segundo vector (coordenadas)");
				v21 = Consola.leeInt();
				v22 = Consola.leeInt();
				
				System.out.println("El producto escalar de ambos vectores es"+(v11*v21+v12*v22));
			}
		}while(r!=3);

	}

}
