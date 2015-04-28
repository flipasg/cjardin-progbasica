/**
 * 
 */
package EjerInicio;

import java.io.IOException;

/**
 * @author ik010137ad
 *
 */
public class Area {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		final float PI = 3.1416f;
		float area,radio;
		int base, altura;
		char car;
		
		System.out.println("Introduce C o R");
		car = Consola.leeChar();
		
		while(car!='C' && car!='c' && car!='R' && car!='r'){
			System.out.println("Introduce C o R");
			car = Consola.leeChar();	
		}
		
		if(car=='C' || car=='c'){
			System.out.println("Introduce el radio del circulo");
			radio = Consola.leeFloat();
			area = PI*radio*radio;
		}
		else{
			System.out.println("Introduce la base del rectangulo");
			base = Consola.leeInt();
			System.out.println("Introduce la altura del rectangulo");
			altura = Consola.leeInt();
			area = base*altura;
		}
		System.out.println(area);
	}

}
