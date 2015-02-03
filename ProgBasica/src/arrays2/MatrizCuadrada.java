package arrays2;

import java.io.IOException;
import java.util.Arrays;

public class MatrizCuadrada{
	private int dim;
	private int[][] matriz;
	
	public MatrizCuadrada(int dim){
		matriz = new int[dim][dim];
		this.dim = dim;
	}
	
	public MatrizCuadrada(int[][] a){
		matriz = a;
		dim = a.length;
	}
	
	public void cargar() throws IOException{
		int numero;
		for(int i = 0; i<dim; i++){
			for(int j = 0; j<dim; j++){
				boolean aniadido = false;
				do{
					boolean encontrado = false;
					System.out.println("Dime el valor para la fila: "+(i+1)+" y la columna: "+(j+1));
					numero = Consola.leeInt();
					
					for(int j2 = 0; !encontrado && j2<=i; j2++){
						int limite;
						if(j2==i){
							limite = j;
						}else{
							limite = dim;
						}
						for(int k = 0; !encontrado && k<limite; k++){
							if(numero==matriz[j2][k]){
								encontrado = true;
							}
						}
					}
					
					if(!encontrado){
						matriz[i][j] = numero;
						aniadido = true;
					}else{
						System.out.println("Imposible añadir");
					}
					
				} while(!aniadido);

			}
		}
	}
	
	public void cargarIdentidad(){
		for(int i = 0; i<dim; i++){
			for(int j = 0; j<dim; j++){
				if(j==i){
					matriz[i][j] = 1;
				}else{
					matriz[i][j] = 0;
				}
			}
			
		}
	}
	
	public void ver(){
		for (int i = 0; i < dim; i++) {
			System.out.print(Arrays.toString(matriz[i]));
		}
		System.out.println();
	}
	
	public static void ver(int[][] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print(Arrays.toString(a[i]));
		}
		System.out.println();
	}
	
	public int determintante(){
		if(dim==3){
			return (matriz[0][0]*matriz[1][1]*matriz[2][2]+matriz[0][1]*matriz[1][2]*matriz[2][0]+matriz[0][2]*matriz[1][0]*matriz[2][1]-matriz[2][0]*matriz[1][1]*matriz[0][2]-matriz[2][1]*matriz[1][2]*matriz[0][0]-matriz[2][2]*matriz[1][0]*matriz[0][1]);
		}else{
			return -1;
		}
	}
	
	public boolean esCuadradoMagico(){
		
		int sumDia = 0;
		int auxSum = 0;
		int sum = 0;
		boolean encontrado = false;
		
		for(int i = 0;!encontrado && i<dim; i++){
			sum = 0;
			for(int j = 0; j<dim; j++){
				sum+=matriz[i][j];
				if(i==j){
					sumDia+=matriz[i][j];
				}
			}
			if(i>0 && sum!=auxSum){
				encontrado = true;
			}
			auxSum = sum;
		}
		
		if(!encontrado){
			if(sumDia!=auxSum){
				encontrado = true;
			}
		}
		
		
		if(!encontrado){
			for(int i = 0;!encontrado && i<dim; i++){
				sum = 0;
				for(int j = 0; j<dim; j++){
					sum+=matriz[j][i];
				}
				
				if(sum!=auxSum){
					encontrado = true;
				}
				auxSum = sum;
				
			}
		}
		
		if(!encontrado){
			sumDia = 0;
			for(int i = 0, j = dim-1; i<dim && j>=0; i++, j--){
				sumDia+=matriz[i][j];
			}
			
			if(sumDia!=auxSum){
				encontrado = true;
			}
			
		}
		
		if(encontrado){
			return false;
		}else{
			return true;
		}
		
	}
	
	public int[][] calcularTraspuesta(){
		int[][] traspuesta = new int[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				traspuesta[i][j] = matriz[j][i];
			}
		}
		return traspuesta;
	}
	
	public boolean esSimetrica(){
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if(matriz[i][j]!=calcularTraspuesta()[i][j]){
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public boolean iguales(MatrizCuadrada mc){
		if(dim!=mc.dim){
			return false;
		}else{
			for (int i = 0; i < dim; i++) {
				for (int j = 0; j < dim; j++) {
					if(matriz[i][j]!=mc.matriz[i][j]){
						return false;
					}
				}
			}
			
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		MatrizCuadrada mc = new MatrizCuadrada(3);
		int[][] a = {{4,9,2},{3,5,7},{8,1,6}};
		MatrizCuadrada mc2 = new MatrizCuadrada(a);
		
		mc.cargar();
		mc.ver();
		
		//mc.cargarIdentidad();
		//mc.ver();
		
		if(mc.determintante()==-1){
			System.out.println("Imposible calcular determinante");
		}else{
			System.out.println("El determinante es "+mc.determintante());
		}
		
		if(mc.esCuadradoMagico()){
			System.out.println("Es cuadrado magico");
		}else{
			System.out.println("No es cuadrado mágico");
		}
		
		System.out.print("La traspuesta es ");
		ver(mc.calcularTraspuesta());
		
		if(mc2.esSimetrica()){
			System.out.println("Es simetrica");
		}else{
			System.out.println("No es simetrica");
		}
		
		if(mc.iguales(mc2)){
			System.out.println("Las matrices son iguales");
		}
		
	}
	
}