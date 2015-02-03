/**
 * 
 */
package arrays2;

import java.util.Arrays;

/**
 * @author ikk
 *
 */
public class MatrizDesigual {
	
	private Float[][] nums;
	
	public MatrizDesigual(){
		nums = new Float[4][4];
	}
	
	public void cargarFila(Float[] af, int pos){
		nums[pos-1] = af;
	}
	
	public void verFila(int pos){
		System.out.println(Arrays.toString(nums[pos-1]));
		
	}
	
	public void verMatriz(){
		for (int i = 0; i < nums.length; i++) {
			System.out.println(Arrays.toString(nums[i]));
		}
	}
	
	private static boolean esPrimo(int n){
		int i = 2;
		while(i<(n/2)+1){
			if(n%i==0){
				return false;
			}
			i++;
		}
		return true;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MatrizDesigual md1 = new MatrizDesigual();
		
		Float[] p3 = new Float[7];
		
		float pot = 1;
		int num = 3;
		for (int i = 0; i < p3.length; i++) {
			pot*=num;
			p3[i] = pot;
			
		}
		
		System.out.println(Arrays.toString(p3));
		
		md1.cargarFila(p3, 1);
		
		Float[] a5 = new Float[5];
		for (int i = 0; i < a5.length; i++) {
			a5[i] = (float)((int)(Math.random()*21))+15;
		}
		
		System.out.println(Arrays.toString(a5));
		
		md1.cargarFila(a5, 2);
		
		Float[] ca7 = new Float[7];
		double ang = 0;
		for (int i = 0; i < ca7.length; i++) {
			ca7[i] = (float) Math.cos(((ang*Math.PI)/180));
			ang+=45;
		}
		
		System.out.println(Arrays.toString(ca7));
		
		md1.cargarFila(ca7, 3);
		
		Float[] pr20 = new Float[20];
		int numPrimo = 2;
		for (int i = 0; i < pr20.length; i++) {
			while(!esPrimo(numPrimo)){
				numPrimo++;
			}
			pr20[i] = (float)numPrimo;
			numPrimo++;
		}
		
		System.out.println(Arrays.toString(pr20));
		System.out.println();
		
		md1.cargarFila(pr20, 4);
		
		md1.verMatriz();
	}

}
