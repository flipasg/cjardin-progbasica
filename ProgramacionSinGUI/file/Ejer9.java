package ejarrays;

import java.io.IOException;

import consola.Consola;

public class Ejer9{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		//declaracion del array de caracteres
		char[] achar = new char[20];
		
		/*
		 * inicializacion del array: valores introducidos por el usuario
		 * condicion: preguntamos si desea introducir otro valor
		 * 
		 */
		
		int cont = 0;
		String res = "";
		boolean cond = true;
		System.out.println("INICIALIZACION DEL ARRAY");
		while(cond){
			System.out.println("Dime un caracter");
			achar[cont] = Consola.leeChar();
			System.out.println("¿Deseas introducir otro caracter? S/N");
			res = Consola.leeString().toLowerCase();
			if(res.equals("n")){
				cond = false;
			}
			cont++;
		}
		
		/*
		 * metodo de insercion: preguntamos un caracter y una posicion n
		 * desplazamos los valores hacia la derecha de n
		 * 
		 */
		
		//mostramos el array antes de la insercion
		for(int i = 0; i<achar.length; i++){
			System.out.print(achar[i]+" ");
		}
		System.out.println();
		
		if(cont == achar.length){
			System.out.println("Todas las posiciones del array ocupadas");
		}else{
			//insercion
			char car = '\u0000';
			System.out.println("INSERCION DE UN CARACTER");
			System.out.println("Dime un caracter");
			car = Consola.leeChar();
			System.out.println("Dime una posicion");
			int n = Consola.leeInt()-1;
			if(n>achar.length){
				System.out.println("El array no dispone de tantas posiciones");
			}else{
				if(achar[n]!='\u0000'){
					for(int i = cont; i>=n; i--){
						achar[i+1] = achar[i];
					}
					achar[n] = car;
				}else{
					achar[n] = car;
				}
			}
		}
		//mostramos el array despues de la insercion
		for(int i = 0; i<achar.length; i++){
			System.out.print(achar[i]+" ");
		}
		System.out.println();
	}

}
