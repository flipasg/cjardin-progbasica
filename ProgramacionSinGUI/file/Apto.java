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
public class Apto {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		float marca, suma=0;
		boolean apto=true;
		int cont=0;
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(isr);
		
		do{
			System.out.println("Dime la marca.");
			marca = Float.parseFloat(buffer.readLine());
			if(marca>15.99){
				apto=false;
			}
			suma+=marca;
			cont++;
		}while(cont<10 && apto);
		if((suma/10)>15){
			apto=false;
		}
		if(apto){
			System.out.println("Eres apto.");
		}
		else{
			System.out.println("No eres apto.");
		}
	}

}
