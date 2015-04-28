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
public class CoefIntec {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		final int medMujSev = 106;
		final int medHomSev = 105;
		final int medMujMad = 102;
		final int medHomMad = 101;
		char sexo, ciudad;
		int edad, coef, coefMaxS, sumM, contM;
		String situacion;
		
		coefMaxS = 255;
		contM = 0;
		sumM = 0;
		for(int cont = 0;cont<10;cont++){
			situacion = "";
			System.out.println("Dime tu sexo. H/M");
			sexo = Consola.leeChar();
			while(sexo!='H' && sexo!='M'){
				System.out.println("Dime tu sexo. H/M");
				sexo = Consola.leeChar();
			}
			System.out.println("Dime tu edad");
			edad = Consola.leeInt();
			while(edad>150 || edad<0){
				System.out.println("Dime tu edad");
				edad = Consola.leeInt();
			}
			System.out.println("Dime tu ciudad. S/M");
			ciudad = Consola.leeChar();
			while(ciudad!='S' && sexo!='M'){
				System.out.println("Dime tu ciudad. S/M");
				ciudad = Consola.leeChar();
			}
			System.out.println("Dime tu coeficiente");
			coef = Consola.leeInt();
			while(coef>250 || coef<50){
				System.out.println("Dime tu coeficiente");
				coef = Consola.leeInt();
			}
			if(sexo=='M'){
				if(ciudad=='M'){
					if(coef==medMujMad){
						situacion = "igual";
					}
					else{
						if(coef>medMujMad){
							situacion = "mayor";
						}
						else{
							situacion = "menor";
						}
					}
				}
				else{
					if(coef==medMujSev){
						situacion = "igual";
					}
					else{
						if(coef>medMujSev){
							situacion = "mayor";
						}
						else{
							situacion = "menor";
						}
					}
				}
			}
			else{
				if(ciudad=='M'){
					if(coef==medHomMad){
						situacion = "igual";
					}
					else{
						if(coef>medHomMad){
							situacion = "mayor";
						}
						else{
							situacion = "menor";
						}
					}
				}
				else{
					if(coef==medHomSev){
						situacion = "igual";
					}
					else{
						if(coef>medHomSev){
							situacion = "mayor";
						}
						else{
							situacion = "menor";
						}
					}
				}
			}
			System.out.println("El coeficiente es "+situacion+" que la media de de los de tu ciudad y sexo");
			if(sexo=='H' && ciudad=='S' && edad>=20 && edad<=30){
				if(coefMaxS<coef){
					coefMaxS = coef;
				}
			}
			if(ciudad=='M'){
				sumM+=coef;
				contM++;
			}
		}
		System.out.println("El coeficiente máximo de los hombres de Sevilla con edades comprendidas entre 20 y 30 años es "+coefMaxS);
		System.out.println("el coeficientemedio de las personas de Madrid es "+(sumM/contM));
	}

}
