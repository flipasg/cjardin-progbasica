/**
 * 
 */
package arrays2;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author ikk
 *
 */
public class MatrizMagica {
	private int dim;
	private int[][] matriz;
	
	/**
	 * 
	 */
	public MatrizMagica(int dim) {
		this.dim = dim;
		matriz = new int[dim][dim];
		cargar();
	}
	public void ver(){
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(Arrays.toString(matriz[i]));
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
	
	
	private void cargar(){
		int num = 1;
		boolean mult5 = false;
		int i = 0, j = dim/2;
		while(num<=dim*dim){
			matriz[i][j] = num;
			
			
			if(num%dim==0){
				i++;
			}else{
				if(i==0){
					i = dim-1;
				}else{
					i--;
				}
				if(j==dim-1){
					j = 0;
				}else{
					j++;
				}
			}
			num++;
					
		} 
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		int num;
		do{
			System.out.println("Dime una dimension impar");
			num = Consola.leeInt();
		}while(num%2==0);
		
		MatrizMagica mg1 = new MatrizMagica(num);
		mg1.ver();
		if(mg1.esCuadradoMagico()){
			System.out.println("Es magico");
		}else{
			System.out.println("No es magico");
		}

	}

}
