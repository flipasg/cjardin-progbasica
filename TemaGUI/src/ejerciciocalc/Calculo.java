/**
 * TemaGUI - ejerciciocalc : Calculo.java
 * @author ikk
 * @date 17/4/2015 2015
 */
package ejerciciocalc;

import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JOptionPane;

//Comienza la clase Calculo
public class Calculo {
    private String operaciones; //operaciones totales
    private String resultado; //resultado actual
    private String operador; //operador actual
    private String operacion; //operacion actual
    private String ultimaOperacion; //operacion a realizar
    
    private double resultadoNumerico; //resultado num�rico
    
    private boolean operacionRealizada; //true si se ha realizado una operacion
    
    private RealizadorDeOperaciones realizador; //clase encargada de realizar las operaciones
    
    /**
     * Constructor de la clase Calculo
     */
    public Calculo() {
	realizador = new RealizadorDeOperaciones();
	vaciar(); //comienza todo vacio
    }
    
    /**
     * M�todo : vaciar
     */
    public void vaciar() {
	resultadoNumerico = 0.0; //el resultado num�rico comienza a 0.0
	//las cadenas comienzan vacias
	resultado = "";
	ultimaOperacion = "";
	operaciones = "";
	operador = "";
	operador = "";
	//no hemos realizado ninguna operacion
	operacionRealizada =  false;
    }
    
    
    /**
     * M�todo establecer : setResultadoNumerico
     * @param resultadoNumerico para establecer resultadoNumerico
     */
    public void setResultadoNumerico(double resultadoNumerico) {
        this.resultadoNumerico = resultadoNumerico;
    }
    
    /**
     * M�todo obtener : getOperaciones
     * @return el operaciones de la clase
     */
    public String getOperaciones() {
        return operaciones;
    }

    /**
     * M�todo obtener : getResultado
     * @return el resultado de la clase
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * M�todo obtener : isOperacionRealizada
     * @return el operacionRealizada de la clase
     */
    public boolean isOperacionRealizada() {
        return operacionRealizada;
    }
    

    /**
     * M�todo : borrarDigito
     */
    public void borrarDigito() {
	if(!resultado.equals("")) //si la cadena no esta vacia
	    resultado = resultado.substring(0, resultado.length()-1);
    }
    
    /**
     * M�todo : borrarDigitoOperaciones
     */
    public void borrarDigitoOperaciones() {
	if(!operaciones.equals("")) //si la cadena no esta vacia
	    operaciones = operaciones.substring(0, operaciones.length()-1);
    }

    /**
     * M�todo : borrarOperaciones
     */
    public void borrarOperaciones() {
	operaciones = "";
    }
    
    /**
     * M�todo : establecerOperacion
     * @param boton
     */
    public void establecerOperacion(JButton boton) {
	//obtenemos el nombre y el texto del boton
	operacion = boton.getName();
	operador = boton.getText();
    }
    
    
    /**
     * M�todo : aniadirDigito
     * @param digito
     */
    public void aniadirDigito(String digito) {
	//si hemos realizado una operacion anterior, vaciamos el resultado
	if(operacionRealizada) resultado = "";
	String numero = resultado + digito; //obtenemos el n�mero con el nuevo d�gito
	//si es v�lido establecemos el resultado
	if(AnalizadorLexico.esNumeroValido(numero)) resultado += digito;
	operacionRealizada = false; //no hemos realizado ninguna operacion
    }
    
    /**
     * M�todo : calcular
     * @param numero2
     */
    public void calcular(String numero2) {
	double num2 = Double.parseDouble(numero2); //obtenemos el n�mero de la cadena
	
	if(operacionRealizada) { //si se ha realizado una operacion
	    borrarDigitoOperaciones(); //borramos el ultimo d�gito (ser� un operador)
	    operaciones += operador; //a�adimos el nuevo operador
	} else { //si no
		if(operaciones.equals("")) { //si no hemos realizado ninguna operaci�n
		    resultado = numero2; //establecemos el resultado al n�mero 
		    resultadoNumerico = Double.parseDouble(resultado); //y el resultado num�rico tambi�n
		} else { //si no
		    if(ultimaOperacion.equals("division") && num2==0.0) { //si es una divisi�n entre 0
			//mostramos un mensaje de error
			JOptionPane.showMessageDialog(null, "Imposible realizar division por 0", "Error", JOptionPane.ERROR_MESSAGE);
			vaciar(); //vaciamos todo
			numero2 = "";
		    } else { //si no realizamos la operacion
			//buscamos el m�todo en la clase Calculadora
			Method metodoAInvocar = realizador.buscarMetodo(ultimaOperacion);
			//realizamos la operacion sobre el resultado num�rico
			resultadoNumerico = realizador.operar(metodoAInvocar, resultadoNumerico, num2);
			//establecemos el resultado
			resultado = Double.toString(resultadoNumerico);
		    }
		    
		}
		
		operaciones = operaciones + numero2 + operador; //actualizamos las operaciones
		operacionRealizada = true; //hemos realizado una operaci�n
		
	}
	
	ultimaOperacion = operacion; //establecemos la �ltima operaci�n con la operaci�n actual

    }
    
    
    

}
