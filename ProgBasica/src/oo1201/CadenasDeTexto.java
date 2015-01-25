/**
 * 
 */
package oo1201;

import java.io.IOException;

import oo6.Consola;

/**
 * @author ikk
 *
 */
public class CadenasDeTexto {
	
	static void dobleEspacio() throws IOException{
		System.out.println("Dime una cadena de carácteres");
		String cad1 = Consola.leeString();
		String cad2 = "";
		for (int i = 0;i<cad1.length();i++) {
			if(cad1.charAt(i)==' '){
				cad2+="  ";
			}
			else{
				cad2+=cad1.charAt(i);
			}
		}
		System.out.println(cad2);
		
	}
	
	static void dosCadenas() throws IOException{
		System.out.println("Dime una cadena de carácteres");
		String cad1 = Consola.leeString();
		String cad2 = "";
		String cad3 = "";
		for (int i = 0;i<cad1.length();i++) {
			if(i==0 || i%2==0){
				cad2+=cad1.charAt(i);
			}
			else{
				cad3+=cad1.charAt(i);
			}
		}
		System.out.println(cad2);
		System.out.println(cad3);
	}
	
	static void sustituirNumeros() throws IOException{
		System.out.println("Dime una cadena de carácteres");
		String cad1 = Consola.leeString();
		String cad2 = "";
		int cont = 0;
		for(int i = 0;i<cad1.length();i++){
			if(cad1.charAt(i)>='0' && cad1.charAt(i)<='9'){
				cont = Character.getNumericValue(cad1.charAt(i));
				System.out.println(cont);
				for(int j = 0;j<cont;j++){
					cad2+=cad1.charAt(i);
				}
			}
			else{
				cad2+=cad1.charAt(i);
			}
		}
		System.out.println(cad2);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{

		//dobleEspacio();
		//dosCadenas();
		sustituirNumeros();
	}

}
