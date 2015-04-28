/**
 * 
 */
package EjerOO1;

import java.io.IOException;

import EjerInicio.Consola;

/**
 * @author ikk
 *
 */
public class BiblioStatic {
	public static void verMultiplos5(int num1, int num2){
		int aux;
		if(num1>num2){
			aux = num1;
			num1 = num2;
			num2 = aux;
		}
		while(num1<=num2){
			if(num1%5==0){
				System.out.print(num1+" ");
				num1+=5;
			}
			else{
				num1++;
			}
		}
	}
	public static int tipoCaracter(char car){
		if(car>=65 && car<=90){
			return 1;
		}
		else{
			if(car>=97 && car<=122){
				return 2;
			}
			else{
				return -1;
			}
		}
	}
	public static float potencia(float x, int n){
		float r;
		r = 1;
		while(n>0){
			r*=x;
			n--;
		}
		return (float)r;
	}
	public static int sumatorio(int num){
		int r;
		r = 0;
		for(int cont = 1;cont<=num;cont++){
			r+=cont;
		}
		return r;
	}
	public static void verTabla(int num){
		int cont;
		
		cont = 1;
		while(cont<=10){
			System.out.println(cont+"*"+num+"="+(cont*num));
			cont++;
		}
	}
	public static void verTablaRestringida(int num){
		if(num<1 || num>20){
			System.out.println("No puedo visualizar la tabla");
		}
		else{
			int cont;
			
			cont = 1;
			while(cont<=10){
				System.out.println(cont+"*"+num+"="+(cont*num));
				cont++;
			}
		}
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		/*int num1, num2;

		do{
			System.out.println("Dime dos numeros enteros");
			num1 = Consola.leeInt();
			num2 = Consola.leeInt();
			verMultiplos5(num1, num2);
			System.out.println();
		}
		while(num1!=0 && num2!=0);
		
		char car;
		
		for(int cont = 0;cont<5;cont++){
			System.out.println("Dime un caracter");
			car = Consola.leeChar();
			System.out.println(car);
			
			if(tipoCaracter(car)==1){
				System.out.println("Es mayuscula");
			}
			else{
				if(tipoCaracter(car)==2){
					System.out.println("Es minuscula");
				}
				else{
					System.out.println("No es una letra");
				}
			}
		}
		
		int n, cont;
		System.out.println("Dime un número");
		n = Consola.leeInt();
		cont = 1;
		while(cont<=n){
			System.out.println(potencia(2, cont));
			cont++;
		}
		
		int x,cont;
		float sum;
		
		cont = 1;
		sum = 0;
		System.out.println("Dime un número");
		x = Consola.leeInt();
		
		while(cont<=8){
			sum+=((potencia(x, cont))/sumatorio(cont));
			cont++;
		}
		
		System.out.println(sum);
		
		int n;
		System.out.println("Dime un entero");
		n = Consola.leeInt();
		
		while(n<1 || n>10){
			System.out.println("Dime un entero");
			n = Consola.leeInt();
		}
		
		verTabla(n);*/
		int n;
		do{
			System.out.println("Dime un entero");
			n = Consola.leeInt();
			verTablaRestringida(n);
		}
		while(n!=0);
	}

}
