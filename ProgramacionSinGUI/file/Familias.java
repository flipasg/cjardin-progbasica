/**
 * 
 */
package EjerInicio2;

import java.io.IOException;

import EjerInicio.Consola;

/**
 * @author ik010137ad
 *
 */
public class Familias {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int numHijos, sueldo, sFamNum, contFamNum, sMaxSH, sMin;
		float  pagoAyunt, descHijos;
		sFamNum = 0;
		sMaxSH = 0;
		sMin = 1000000;
		contFamNum = 0;
		for(int cont = 0;cont<20;cont++){
			pagoAyunt = 0;
			descHijos = 0;
			System.out.println("Dime el número de hijos");
			numHijos = Consola.leeInt();
			System.out.println("Dime el suelo");
			sueldo = Consola.leeInt();
			pagoAyunt = sueldo*0.90f;
			if(numHijos>=3){
				descHijos = (100-(10*numHijos))/100;
				sFamNum+=sueldo;
				contFamNum++;
			}
			else{
				if(numHijos>0){
					descHijos = (100-(5*numHijos))/100;
				}
			}
			pagoAyunt*=descHijos;
			System.out.println("Esta familia tiene que pagar "+pagoAyunt);
			if(numHijos==0){
				if(sMaxSH<sueldo){
					sMaxSH = sueldo;
				}
			}
			if(sMin>sueldo){
				sMin = sueldo;
			}
		}
		System.out.println("La media de sueldo de las familias numerosas es "+(sFamNum/contFamNum));
		System.out.println("El sueldo máximo de las familias sin hijos es "+sMaxSH);
		System.out.println("El sueldo mínimo es "+sMin);
	}

}
