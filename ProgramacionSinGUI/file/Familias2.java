/**
 * 
 */
package EjerInicio3;

import java.io.IOException;

import EjerInicio.Consola;

/**
 * @author ikk
 *
 */
public class Familias2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		int numFam, sal, codigoFam, numHijos, edadHijo;
		char sexoHijo;
		int contV, edadMin, salFamNum, contFamNum, maxHijos, codMaxHijos;
		
		System.out.println("Dime el n�mero de familias");
		numFam = Consola.leeInt();
		
		codigoFam = 0;
		maxHijos = 0;
		codMaxHijos = 0;
		salFamNum = 0;
		contFamNum = 0;
		
		for(int contf = 0;contf<numFam;contf++){
			
			System.out.println("Dime el codigo de la familia");
			codigoFam = Consola.leeInt();
			System.out.println("Dime el salario de la familia");
			sal = Consola.leeInt();
			System.out.println("Dime el n�mero de hijos");
			numHijos = Consola.leeInt();
			
			contV = 0;
			edadMin = 1000;
			for(int conth = 0;conth<numHijos;conth++){
				
				System.out.println("Dime la edad del hijo");
				edadHijo = Consola.leeInt();
				while(edadHijo<0 || edadHijo>100){
					System.out.println("Dime la edad del hijo");
					edadHijo = Consola.leeInt();
				}
				System.out.println("Dime el sexo del hijo");
				sexoHijo = Consola.leeChar();
				while(sexoHijo!='V' && sexoHijo!='v' && sexoHijo!='h' && sexoHijo!='H'){
					System.out.println("Dime el sexo del hijo");
					sexoHijo = Consola.leeChar();
				}
				
				if((sexoHijo=='V' || sexoHijo=='v') && edadHijo>=10 && edadHijo<=15){
					contV++;
				}
				if(edadHijo<edadMin){
					edadMin = edadHijo;
				}
			}
			
			System.out.println("El n�mero de hijos varones entre 10 y 15 a�os es "+contV);
			System.out.println("La edad m�nima de los hijos es "+edadMin);
			
			if(numHijos>=3){
				salFamNum+=sal;
				contFamNum++;
			}
			if(numHijos>maxHijos){
				maxHijos = numHijos;
				codMaxHijos = codigoFam;
			}
		}
		System.out.println("El codigo de la familia con mayor n�mero de hijos es"+codMaxHijos);
		System.out.println("La familia con mayor n�mero de hijos es "+codigoFam);
		System.out.println("El salario medio de las familias numerosas es "+(salFamNum/contFamNum));
	}

}
