/**
 *
 */
package ejercicio4;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.jdom2.JDOMException;

/**
 * @author Iker Garcia Ramirez
 * @date 29/4/2015
 *
 */
public class VentanaAhorcado extends VentanaBasica implements ActionListener {
    private PanelAlfabeto alfabeto;
    private PanelRespuesta respuesta;
    private PanelJugar jugar;
    private PanelFallos fallos;
    private Ahorcado propiedades;

    /**
     * Constructor de la clase VentanaAhorcado
     *
     * @param title
     * @throws HeadlessException
     */
    public VentanaAhorcado(String title) throws HeadlessException {
	super(title);
    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio4.VentanaBasica#instanciar()
     */
    @Override
    public void instanciar() {
	alfabeto = new PanelAlfabeto();
	respuesta = new PanelRespuesta();
	jugar = new PanelJugar();
    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio4.VentanaBasica#configurar()
     */
    @Override
    public void configurar() {
	setSize(new Dimension(700, 500));
	setLayout(null);
    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio4.VentanaBasica#aniadir()
     */
    @Override
    public void aniadir() {
	jugar.setBounds(315, 0, 80, 50);
	add(jugar);
	respuesta.setBounds(200, 200, 300, 50);
	add(respuesta);
	alfabeto.setBounds(0, 390, 695, 80);
	add(alfabeto);

    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio4.VentanaBasica#oyentes()
     */
    @Override
    public void oyentes() {
	jugar.getJugar().addActionListener(this);
	Component[] componentes = alfabeto.getComponents();
	for (int i = 0; i < componentes.length; i++) {
	    if (componentes[i].getClass() == JButton.class) {
		((JButton) componentes[i]).addActionListener(this);
		((JButton) componentes[i]).setEnabled(false);
	    }

	}

    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio4.VentanaBasica#propFinales()
     */
    @Override
    public void propFinales() {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(false);
    }

    public void aniadirFallos(int numFallos) {
	fallos = new PanelFallos(numFallos);
	fallos.setBounds(0, 120, 700, 100);
	add(fallos);
    }

    public void habilitarBotones() {
	Component[] componentes = alfabeto.getComponents();
	for (int i = 0; i < componentes.length; i++) {
	    if (componentes[i].getClass() == JButton.class) {
		if (!((JButton) componentes[i]).isEnabled())
		    ((JButton) componentes[i]).setEnabled(true);
		;
	    }

	}
    }

    public void reiniciar() {
	jugar.getJugar().setEnabled(true);
	fallos.setVisible(false);
	respuesta.getRespuesta().setText("");
	habilitarBotones();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

	try {
	    if (e.getSource() == jugar.getJugar()) {
		Object[] valores = { "Aceptar", "Cancelar" };
		String numLetras = JOptionPane.showInputDialog(this,
			"Introduce contraseña");
		if (numLetras != null) {
		    if (numLetras.equals("")) {
			propiedades = new Ahorcado();
		    } else {
			propiedades = new Ahorcado(Integer.parseInt(numLetras));
		    }

		    aniadirFallos(propiedades.getVidasRestantes());
		    respuesta.getRespuesta()
		    .setText(propiedades.verRespuesta());
		    jugar.getJugar().setEnabled(false);
		    Component[] componentes = alfabeto.getComponents();
		    for (int i = 0; i < componentes.length; i++) {
			if (componentes[i].getClass() == JButton.class) {
			    ((JButton) componentes[i]).setEnabled(true);
			}

		    }
		}
	    } else {
		JButton boton = (JButton) e.getSource();
		char c = boton.getText().toLowerCase().charAt(0);
		if (!propiedades.tirar(c)) {
		    fallos.getFallos()[propiedades.getVidasRestantes()]
			    .setVisible(false);

		} else {
		    boton.setEnabled(false);
		}
		respuesta.getRespuesta().setText(propiedades.verRespuesta());
		if (propiedades.completo()) {
		    JOptionPane.showMessageDialog(this,
			    "ENHORABUENA. PALABRA: "
				    + propiedades.getPalabraAAdivinar()
					    .toUpperCase(), "Mensaje",
			    JOptionPane.INFORMATION_MESSAGE);
		    GestorXML gx = GestorXML.obtenerInstancia();
		    gx.aniadirAcierto(propiedades.getPalabraAAdivinar(),
			    propiedades.getPalabraAAdivinar().length());
		    reiniciar();

		}
		if (!propiedades.quedanVidas()) {
		    JOptionPane.showMessageDialog(this,
			    "NO QUEDAN VIDAS. PALABRA: "
				    + propiedades.getPalabraAAdivinar()
					    .toUpperCase(), "Mensaje",
			    JOptionPane.INFORMATION_MESSAGE);
		    reiniciar();
		}

	    }

	} catch (NumberFormatException e1) {
	    JOptionPane.showMessageDialog(this, "Hay que introducir un numero",
		    "Alerta", JOptionPane.ERROR_MESSAGE);
	} catch (JDOMException e1) {
	    JOptionPane.showMessageDialog(this, "Problema con el XML", "Alert",
		    JOptionPane.ERROR_MESSAGE);
	} catch (IOException e1) {
	    JOptionPane.showMessageDialog(this, "Error de entrada/salida",
		    "Alert", JOptionPane.ERROR_MESSAGE);
	} catch (AhorcadoException e1) {
	    JOptionPane.showMessageDialog(this, e1.getMessage(), "Alerta",
		    JOptionPane.ERROR_MESSAGE);
	}

    }
}
