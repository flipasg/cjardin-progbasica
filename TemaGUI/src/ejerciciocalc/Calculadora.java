/**
 * TemaGUI - ejerciciocalc : Calculadora.java
 * @author Ikk
 * @date 16/4/2015 2015
 */
package ejerciciocalc;

//Comienza la clase Calculadora
public class Calculadora {

    /**
     * M�todo : suma
     * @param numero1
     * @param numero2
     * @return la suma
     */
    public Double suma(double numero1, double numero2) {
	return numero1+numero2;
    }
    
    /**
     * M�todo : resta
     * @param numero1
     * @param numero2
     * @return la resta
     */
    public Double resta(double numero1, double numero2) {
	return numero1-numero2;
    }
    
    /**
     * M�todo : multiplicacion
     * @param numero1
     * @param numero2
     * @return la multiplicaci�n
     */
    public Double multiplicacion(double numero1, double numero2) {
	return numero1*numero2;
    }
    
    /**
     * M�todo : division
     * @param numero1
     * @param numero2
     * @return la divisi�n
     */
    public Double division(double numero1, double numero2) {
	return numero1/numero2;
    }
}
