/**
 *
 */
package ejercicio3;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.jdom2.JDOMException;

/**
 * @author Ikk
 * @date 28/4/2015
 *
 */
public class Principal {
    public static void main(String[] args) {
	try {
	    // solo se pueden instanciar el GestorXML y el GestorDeConsultas una
	    // vez, obtenemos sus instancias
	    GestorXML gx = GestorXML.obtenerInstancia();
	    GestorDeConsultas gdc = GestorDeConsultas.obtenerInstancia();

	    // mostramos un dialogo de confirmacion para saber si el usuario
	    // desea resetear el fichero XML
	    int selectedOption = JOptionPane.showConfirmDialog(null,
		    "¿Desea resetear el fichero de medicos?", "RESETEAR",
		    JOptionPane.YES_NO_OPTION);

	    // en caso afirmativo
	    if (selectedOption == JOptionPane.YES_OPTION) {
		gx.iniciar(); // iniciamos el xml de 0
		// mostramos la ventana
		new VentanaConsultas("Consultas medicas");
	    } else if (selectedOption == JOptionPane.NO_OPTION) {
		// en caso negativo
		// cargamos el HashMap con la informacion del fichero
		gx.cargarHash();
		// mostramos la ventana
		new VentanaConsultas("Consultas medicas");
	    } else { // si no, si se cierra la ventana
		     // nos despedimos
		JOptionPane.showMessageDialog(null, "ADIOS");
	    }
	} catch (JDOMException | IOException | HoraException e) {
	    JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
		    JOptionPane.ERROR_MESSAGE);
	}

    }
}
