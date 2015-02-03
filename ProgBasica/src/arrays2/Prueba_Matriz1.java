package arrays2;

import java.io.IOException;
import java.util.Arrays;

public class Prueba_Matriz1{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		Matriz1 m1 = new Matriz1();
		
		m1.cargarPorFilas();
		m1.ver();
		
		m1.cargarPorColumnas();
		m1.ver();
		
		m1.intercambiarFilas(1,10);
		m1.ver();
		
		m1.intercambiarColumnas(1,8);
		System.out.println(Arrays.toString(m1.negativos()));
		
		Matriz1[] matrices = new Matriz1[4];
		int nf;
		int nc;
		for(int i = 0; i<matrices.length; i++){
			System.out.println("Dime el número de filas: ");
			nf = Consola.leeInt();
			System.out.println("Dime el número de columnas: ");
			nc = Consola.leeInt();
			matrices[i] = new Matriz1(nf,nc);
			matrices[i].cargarPorFilas();
			matrices[i].ver();
			if(nc>=5){
				matrices[i].invertirPorFilas();
				matrices[i].ver();
			}
		}
		
	}

}
