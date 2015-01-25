package oo6;

import java.io.IOException;

public class BiblioString {
	
	static String concatenar() throws IOException{
		
		String c = "";
		String cadena = "";
		do{
			System.out.println("Dime una cadena");
			c = Consola.leeString();
			cadena+=c;
		}while(!c.equals("fin"));
		return cadena;
	}
	
	static int sustituir(String c, char car1, char car2){
		int longitud = c.length();
		int cont = 0;
		String cad = "";
		for(int contf = 0;contf<longitud;contf++){
			if(c.charAt(contf)==car2){
				cad+=car2;
				cont++;
			}
			else{
				cad+=c.charAt(contf);
			}
			
		}
		return cont;
	}
	
	static String eliminarCar(String c, char car){
		int longitud = c.length();
		String cad = "";
		for(int contf = 0;contf<longitud;contf++){
			if(c.charAt(contf)!=car){
				cad+=c.charAt(contf);
			}
		}
		return cad;
	}
	
	static String completar$(String c, int l){
		int longitud = c.length();
		String cad = c;
		for(int contf = longitud;contf<l;contf++){
			cad+='$';
		}
		return cad;
	}
	
	static void verPalabras(String c){
		int longitud = c.length();
		String cad = "";
		char car = 0;
		for(int contf = 0;contf<longitud;contf++){
			if(c.charAt(contf)==' '){
				cad+="\n";
			}
			else{
				if(c.charAt(contf)>='a' && c.charAt(contf)<='z'){
					car=(char) ('A'+(c.charAt(contf)-'a'));

					cad+=car;
				}
				else{
					if(c.charAt(contf)>='A' && c.charAt(contf)<='Z'){
						car=c.charAt(contf);
						cad+=car;
					}
				}
			}
		}
		System.out.println(cad);
	}
	
	static void verPalabrasAlReves(String c){
		c+=' ';
		int longitud = c.length();
		String cad = "";
		String cad2 = "";
		char car = 0;
		for(int contf = 0;contf<longitud;contf++){
			if(c.charAt(contf)==' '){
				cad+="\n";;
				cad2 = cad+cad2;
				cad = "";
			}
			else{
				if(c.charAt(contf)>='A' && c.charAt(contf)<='Z'){
					car=(char) ('a'+(c.charAt(contf)-'A'));
					cad+=car;
				}
				else{
					if(c.charAt(contf)>='a' && c.charAt(contf)<='z'){
						car=c.charAt(contf);
						cad+=car;
					}
				}
			}
		}
		System.out.println(cad2);
	}
	
}
