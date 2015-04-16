/**
 * TemaGUI - ejerciciocalc : RealizadorDeOperaciones.java
 * @author ikk
 * @date 16/4/2015 2015
 */
package ejerciciocalc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Comienza la clase RealizadorDeOperaciones
public class RealizadorDeOperaciones {
    private Calculadora c;
    
    /**
     * Constructor de la clase RealizadorDeOperaciones
     */
    public RealizadorDeOperaciones() {
	c = new Calculadora();
    }
    
    /**
     * Método : buscarMetodo
     * @param nombreMetodo
     * @return el método
     */
    public Method buscarMetodo(String nombreMetodo) {
	//obtenemos un array de los métodos declarados de la clase Calculadora
	Method[] metodos = (Calculadora.class).getDeclaredMethods();
	for (Method m : metodos) {
	    String nombre = m.getName();
	    //si el nombre del método es igual al que se pasa como parametro lo devolvemos
	    if(nombre.equals(nombreMetodo)) return m;
	}
	
	return null;
    }
    
    /**
     * Método : operar
     * @param m
     * @param numero1
     * @param numero2
     * @return el resultado de la operación
     */
    public Double operar(Method m, double numero1, double numero2) {
	double resultado = 0;
	try {
	    resultado = (Double) m.invoke(c, numero1, numero2);
	} catch (IllegalAccessException | IllegalArgumentException 
		| InvocationTargetException e) {}
	return resultado;
    }
    
}
