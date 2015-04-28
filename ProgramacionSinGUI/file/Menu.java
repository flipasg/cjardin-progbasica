/**
 * 
 */
package EjerInicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import EjerInicio.Consola;

/**
 * @author dw1_alum9
 *
 */
public class Menu {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		char r;
		int num;
		
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		do{
			System.out.println("A-Calcular raíz cuadrada");
			System.out.println("B-Calcular cubo");
			System.out.println("C-Calcular sumatorio");
			System.out.println("D-Calcular factorial");
			System.out.println("E-Salir");
			System.out.println("Dime una opción:");
			r = Consola.leeChar();
			while(r!='A' && r!='B' && r!='C' && r!='D' && r!='E'){
				System.out.println("Dime una opción válida:");
				r = Consola.leeChar();
			}
			System.out.println("Dime un número:");
			num = b.read();
			if(r=='A'){
				double raiz;
				raiz = Math.sqrt(num);
				System.out.println(raiz);
			}
			if(r=='B'){
				int cubo;
				cubo = num*num*num;
				System.out.println(cubo);
			}
			if(r=='C'){
				int suma, cont;
				cont = 1;
				suma = 0;
				while(cont<=num){
					suma+=cont;
					cont++;
				}
				System.out.println(suma);
			}
			if(r=='D'){
				int fact, cont;
				cont = num;
				fact = 1;
				while(cont>0){
					fact*=cont;
					cont--;
				}
				System.out.println(fact);
			}
		}while(r!='E');

	}

}
