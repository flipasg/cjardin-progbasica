package oo19;

public class Biblioteca {
	
	static int mayusc(String c){
		int contm = 0;
		
		for(int i = 0;i<c.length();i++){
			if(c.charAt(i)>='A' && c.charAt(i)<='Z'){
				contm++;
			}
		}
		return contm;
	}
	
	static void cifrar(String c){
		String cad = "";
		for(int i = 0;i<c.length();i++){
			if(c.charAt(i)!=' '){
				if(c.charAt(i)>='a' && c.charAt(i)<='z'){
					cad+='*';
				}
				else{
					cad+=c.charAt(i);
				}
			}
		}
		cad+="XXX";
		c = cad;
		System.out.println(c);
	}
	
	public static void main(String[] args) {
		System.out.println(mayusc("Hola Que Tal"));
		cifrar("Hola Que Tal");

	}

}
