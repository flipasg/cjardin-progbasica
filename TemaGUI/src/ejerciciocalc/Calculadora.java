/**
 * TemaGUI - ejerciciocalc : Calculadora.java
 * @author Ikk
 * @date 16/4/2015 2015
 */
package ejerciciocalc;

//Comienza la clase Calculadora
public class Calculadora {

    /**
     * Método : suma
     * @param numero1
     * @param numero2
     * @return la suma
     */
    public Double suma(double numero1, double numero2) {
	return numero1+numero2;
    }
    
    /**
     * Método : resta
     * @param numero1
     * @param numero2
     * @return la resta
     */
    public Double resta(double numero1, double numero2) {
	return numero1-numero2;
    }
    
    /**
     * Método : multiplicacion
     * @param numero1
     * @param numero2
     * @return la multiplicación
     */
    public Double multiplicacion(double numero1, double numero2) {
	return numero1*numero2;
    }
    
    /**
     * Método : division
     * @param numero1
     * @param numero2
     * @return la división
     */
    public Double division(double numero1, double numero2) {
	return numero1/numero2;
    }
    
}
