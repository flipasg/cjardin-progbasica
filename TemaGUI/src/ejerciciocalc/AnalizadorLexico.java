/**
 * TemaGUI - ejerciciocalc : AnalizadorLexico.java
 * @author Ikk
 * @date 16/4/2015 2015
 */
package ejerciciocalc;

import ejercicio2.EscuchadorCombo;

//Comienza la clase AnalizadorLexico
public class AnalizadorLexico {
    private final static String NUMERO = "^-?\\d+\\.?\\d*$";
    private final static String ECUACION = "^-?\\d+\\.?\\d*([+-/*]-?\\d+\\.?\\d*)$";
    
    public static boolean esNumeroValido(String numero) {
	return numero.matches(NUMERO);
    }
    
    public static boolean esOperacion(String ecuacion) {
	return ecuacion.matches(ECUACION);
    }
    
    public static void main(String[] args) {
	System.out.println(AnalizadorLexico.esOperacion("2.22+2"));
	System.out.println(AnalizadorLexico.esNumeroValido("2"));
	System.out.println(AnalizadorLexico.esNumeroValido("2."));
	System.out.println(AnalizadorLexico.esNumeroValido("2.2"));
	System.out.println(AnalizadorLexico.esNumeroValido("2.222"));
	System.out.println(AnalizadorLexico.esNumeroValido("2222.32323"));
	String str = "2.";
	System.out.println(Double.parseDouble(str));
    }
}
