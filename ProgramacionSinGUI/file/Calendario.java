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
public class Calendario {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int mes, diaSemana, dias, contDias, diaEs, contSemana, contDia;
		String nombreMes, semana;
		
		System.out.println("Dime el mes");
		mes = Consola.leeInt();
		System.out.println("Dime el dia de la semana");
		diaSemana = Consola.leeInt();
		nombreMes = "";
		dias = 0;
		
		if(mes==1){
			nombreMes = "Enero";
			dias = 31;
		}
		if(mes==2){
			nombreMes = "Febrero";
			dias = 28;
		}
		if(mes==3){
			nombreMes = "Marzo";
			dias = 31;
		}
		if(mes==4){
			nombreMes = "Abril";
			dias = 30;
		}
		if(mes==5){
			nombreMes = "Mayo";
			dias = 31;
		}
		if(mes==6){
			nombreMes = "Junio";
			dias = 30;
		}
		if(mes==7){
			nombreMes = "Julio";
			dias = 31;
		}
		if(mes==8){
			nombreMes = "Agosto";
			dias = 31;
		}
		if(mes==9){
			nombreMes = "Septiembre";
			dias = 30;
		}
		if(mes==10){
			nombreMes = "Octumbre";
			dias = 31;
		}
		if(mes==11){
			nombreMes = "Noviembre";
			dias = 30;
		}
		if(mes==12){
			nombreMes = "Diciembre";
			dias = 31;
		}

		System.out.println(nombreMes);
		System.out.println("L\tM\tX\tJ\tV\tS\tD");
		
		contDias = 0;
		semana ="";
		while(contDias<diaSemana-1){
			semana+=" \t";
			contDias++;
		}
		
		diaEs = 1;
		while(contDias<7){
			semana+=diaEs+"\t";
			contDias++;
			diaEs++;
		}
		System.out.println(semana);
		semana = "";
		contSemana = 0;
		
		while(contSemana<4){
			contDia = 0;
			while(contDia<7 && diaEs<=dias){
				semana+=diaEs+"\t";
				diaEs++;
				contDia++;
			}
			System.out.println(semana);
			semana = "";
			contSemana++;
		}
		
	}

}
