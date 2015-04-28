package ejarrays;

import java.io.IOException;

import consola.Consola;

public class Ejer8{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		//declaracion e inicializacion
		int[] aint = {1,2,3,4,5};
		
		//pedimos la posicion y le restamos uno porque los indices son de 0 a n-1
		System.out.println("Dime una posicion del array");
		int pos = Consola.leeInt()-1;
		
		//borramos dicha posicion
		int aux = 0;
		for(int i = pos; i<aint.length; i++){
			if(i==pos){
				aint[i] = 0;
			}else{
				aint[i-1] = aint[i];
			}
			if(i==aint.length-1){
				aint[i] = 0;
			}
		}
		
		//visualizamos el array
		for(int i = 0; i<aint.length; i++){
			System.out.print(aint[i]+" ");
		}
		System.out.println();
	}

}
