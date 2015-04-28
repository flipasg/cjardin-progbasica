/**
 * 
 */
package EjerInicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ik010137ad
 *
 */
public class Euclides {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		int a, b, aux;
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(isr);
		
		System.out.println("Dime dos números");
		
		a = Integer.parseInt(buffer.readLine());
		b = Integer.parseInt(buffer.readLine());
		
		if(a<0){
			a=a*(-1);
		}
		if(b<0){
			b=b*(-1);
		}
		if(b>a){
			aux=b;
			b=a;
			a=aux;
		}
		while(a%b!=0){
			b=a%b;
		}
		System.out.println(b);
	}

}
