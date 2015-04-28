/**
 * 
 */
package EjerInicio;

import java.io.IOException;

/**
 * @author ik010137ad
 * MAS O MENOS!!!!!!!!!!!!!!!!!!!!!!
 */
public class DiasVividos {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int diaHoy, mesHoy, anioHoy, diaNac, mesNac, anioNac;
		int dAnio, contMes;
		int sumNac, sumHoy, dias;
		String persona;
		
		System.out.println("Dime tu nombre");
		persona = Consola.leeString();
		
		System.out.println("Dime la fecha de hoy");
		diaHoy = Consola.leeInt();
		mesHoy = Consola.leeInt();
		anioHoy = Consola.leeInt();
		
		System.out.println("Dime la fecha de nacimiento");
		diaNac = Consola.leeInt();
		mesNac = Consola.leeInt();
		anioNac = Consola.leeInt();
		
		int contAnio;
		contAnio = anioNac;
		dAnio = 0;
		while(contAnio<anioHoy){
			dAnio+=365;
			contAnio++;
		}
		System.out.println(dAnio);
		
		contMes = 1;
		dias = 31;
		sumNac = 0;
		while(contMes<mesNac){
			if(contMes<9){
				if(contMes%2==0){
					if(contMes==2){
						dias = 28;
					}
					if(contMes==8){
						dias = 31;
					}
					dias = 30;
				}
			}
			else{
				if(contMes%2!=0){
					dias = 30;
				}
			}
			sumNac+=dias; //sumNac=sumNac+dias;
			contMes++;
		}
		sumNac+=diaNac;
		System.out.println(sumNac);
		
		contMes = 1;
		dias = 31;
		sumHoy = 0;
		while(contMes<mesHoy){
			
			if(contMes<9){
				if(contMes%2==0){
					if(contMes==2){
						dias = 28;
					}
					if(contMes==8){
						dias = 31;
					}
					dias = 30;
				}
			}
			else{
				if(contMes%2!=0){
					dias = 30;
				}
			}
			sumHoy+=dias; //sumNac=sumNac+dias;
			contMes++;
		}
		sumHoy+=diaHoy;
		System.out.println(sumHoy);
		
		dAnio-=sumNac;
		dAnio+=sumHoy;
		System.out.println("Los días vividos por "+persona+" son "+dAnio);
	}

}
