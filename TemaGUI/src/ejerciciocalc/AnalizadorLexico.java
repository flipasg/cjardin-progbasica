/**
 * TemaGUI - ejerciciocalc : AnalizadorLexico.java
 * @author Ikk
 * @date 16/4/2015 2015
 */
package ejerciciocalc;


//Comienza la clase AnalizadorLexico
public class AnalizadorLexico {
    private final static String NUMERO = "^-?\\d+\\.?\\d*$";
    
    /**
     * M�todo : esNumeroValido
     * @param numero
     * @return si es (o no) un n�mero v�lido
     */
    public static boolean esNumeroValido(String numero) {
	return numero.matches(NUMERO);
    }
    
}
