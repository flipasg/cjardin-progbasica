/**
 * 
 */
package EjerInicio;

import java.io.IOException;

/**
 * @author ik010137ad
 *
 */
public class Medio {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int num1, num2, num3;
		
		System.out.println("Dime tres números");
		num1 = Consola.leeInt();
		num2 = Consola.leeInt();
		num3 = Consola.leeInt();
		
		if(num1==num2 || num1==num3 || num2==num3){
			System.out.println("No hay número medio");
		}
		else{
			if((num1>num2 && num1<num3)||(num1<num2 && num1>num3)){
				System.out.println(num1+" es el número medio.");
			}
			else{
				if((num2>num1 && num2<num3)||(num2<num1 && num2>num3)){
					System.out.println(num2+" es el número medio.");
				}
				else{
					System.out.println(num3+" es el número medio.");
				}
			}
		}
	}
}
