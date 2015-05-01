/**
 *
 */
package ejercicio5;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.jdom2.JDOMException;

/**
 * @author Iker Garcia Ramirez
 * @date 1/5/2015
 *
 */
public class Principal {
    /**
     * Metodo principal del programa
     *
     * @param args
     */
    public static void main(String[] args) {
	try {
	    new VentanaMenu("RESTAURANTE");
	} catch (HeadlessException e) {
	    JOptionPane.showMessageDialog(null, "Problema exception", "Error",
		    JOptionPane.ERROR_MESSAGE);
	} catch (JDOMException e) {
	    JOptionPane.showMessageDialog(null, "Problema XML", "Error",
		    JOptionPane.ERROR_MESSAGE);
	} catch (IOException e) {
	    JOptionPane.showMessageDialog(null, "Problema flujo de datos",
		    "Error", JOptionPane.ERROR_MESSAGE);
	    e.printStackTrace();
	}

    }
}
