package ejarrays;

import java.io.IOException;
import java.util.Arrays;

import consola.Consola;

public class OpArray{
	int[] aInt;

	public OpArray(int[] aInt){
		this.aInt = aInt;
	}
	
	public int cargarArray() throws IOException{
		int numero = 0;
		int cont = 0;
		do{
			System.out.println("Dime un numero");
			numero = Consola.leeInt();
			aInt[cont] = numero;
			cont++;
		} while(numero!=0 && cont<aInt.length);
		return cont;
	}
	
	public void ver(int n){
		for(int i = 0; i<n; i++){
			System.out.print(aInt[i]+" ");
		}
		System.out.println();
	}
	
	public int sustituir(int num) throws IOException{
		int cont = 0;
		for(int i = 0; i<aInt.length; i++){
			if(num==aInt[i]){
				System.out.println("¿Cual es el numero por cual desea sustituirlo?");
				aInt[i] = Consola.leeInt();
				cont++;
			}
		}
		return cont;
	}

	public String toString(int n){
		String str = "";
		for(int i = 0; i<n; i++){
			str+=aInt[i]+"";
		}
		return str;
	}
	
	private static boolean esPrimo(int num){
		int div = 2;
		boolean primo = true;
		if(num>1){
			while(primo && div<(num/2)+1){
				if(num%div==0){
					primo = false;
				}
				div++;
			}
			if(primo){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public int indicePrimo(){
		boolean encontrado = false;
		int indice = -1;
		for(int i = 0; i<aInt.length && !encontrado; i++){
			if(esPrimo(aInt[i])){
				encontrado = true;
				indice = i;
			}
		}
		return indice;
	}
	
	public static void main(String[] args) throws IOException{
		int[] aPrueba = new int[10];
		OpArray a1 = new OpArray(aPrueba);
		
		int n = a1.cargarArray();
		
		a1.ver(n);
		
		a1.sustituir(3);
		
		a1.ver(n);
		
		System.out.println(a1.toString(n));
		
		System.out.println(a1.indicePrimo());
		
	}
}
