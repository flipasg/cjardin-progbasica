/**
 * XML - ejemplo4 : VuelosGUI.java
 * @author Ikk
 * @date 22/4/2015
 */
package ejemplo4;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.jdom2.Element;
import org.jdom2.JDOMException;

import ejemplo3.GestorVuelos;

//Comienza la clase VuelosGUI
public class VuelosGUI extends CrearVentana {
    private static final String FICHERO = "vuelos.xml";
    private JLabel origenEtiqueta, destinoEtiqueta;
    JComboBox<String> origenCombo;
    private JComboBox<Element> destinoCombo;
    private JButton comprar;
    private GestorVuelos gv;

    /**
     * Constructor de la clase VuelosGUI
     * 
     * @param titulo
     * @throws HeadlessException
     */
    public VuelosGUI(String titulo) throws HeadlessException {
	super(titulo);

    }

    /**
     * Metodo sobreescrito : instanciar
     * 
     * @see ejemplo4.CrearVentana#instanciar()
     */
    @Override
    public void instanciar() {
	try {
	    gv = new GestorVuelos(FICHERO);
	    origenEtiqueta = new JLabel("ORIGEN");
	    destinoEtiqueta = new JLabel("DESTINO");
	    origenCombo = new JComboBox<>(gv.obtenerOrigenesDistintos());
	} catch (JDOMException e) {  
	} catch (IOException e) {}

    }
    /**
     * Metodo sobreescrito : aniadir
     * @see ejemplo4.CrearVentana#aniadir()
     */
    @Override
    public void aniadir() {
        add(origenCombo);
    }
    /**
     * Metodo sobreescrito : configurar
     * 
     * @see ejemplo4.CrearVentana#configurar()
     */
    @Override
    public void configurar() {
	setSize(new Dimension(500, 500));
    }

    /**
     * Metodo sobreescrito : oyentes
     * 
     * @see ejemplo4.CrearVentana#oyentes()
     */
    @Override
    public void oyentes() {

    }

    /**
     * Metodo sobreescrito : propiedades
     * 
     * @see ejemplo4.CrearVentana#propiedades()
     */
    @Override
    public void propiedades() {
	setResizable(false);
	setVisible(true);
    }
    
    public static void main(String[] args) {
	new VuelosGUI("Ikk Viajes");
    }

}
