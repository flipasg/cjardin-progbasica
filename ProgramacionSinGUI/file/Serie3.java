/**
 * 
 */
package EjerInicio4;

import java.io.IOException;

import EjerInicio.Consola;

/**
 * @author ikk
 *
 */
public class Serie3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int num, num1, num2, inc;
		String fila, addend;
		
		System.out.println("Dime el número de filas impar");
		num = Consola.leeInt();
		while(num%2==0){
			System.out.println("Dime el número de filas impar");
			num = Consola.leeInt();
		}
		
		inc = 0;
		num1 = (num/2)+1;
		num2 = num-num1;
		
		for(int contFila = 1;contFila<=num1;contFila++){
			fila = "";
			for(int contBlancos = 1;contBlancos<num1-inc;contBlancos++){
				fila+="  ";
			}
			for(int contAdd = 1;contAdd<=contFila+inc;contAdd++){
				if(contFila%2!=0){
					if(contAdd%2!=0){
						addend = "Y ";
					}
					else{
						addend = "X ";
					}
				}
				else{
					if(contAdd%2!=0){
						addend = "X ";
					}
					else{
						addend = "Y ";
					}
				}
				fila+=addend;
			}
			inc++;
			System.out.println(fila);
		}
		
		inc = num2-1; 
		for(int contFila = num2;contFila>=1;contFila--){
			fila = "";
			for(int contBlancos = 0;contBlancos<num2-inc;contBlancos++){
				fila+="  ";
			}
			for(int contAdd = 1;contAdd<=contFila+inc;contAdd++){
				if(contFila%2!=0){
					if(contAdd%2!=0){
						addend = "Y ";
					}
					else{
						addend = "X ";
					}
				}
				else{
					if(contAdd%2!=0){
						addend = "X ";
					}
					else{
						addend = "Y ";
					}
				}
				fila+=addend;
			}
			inc--;
			System.out.println(fila);
		}

	}

}
