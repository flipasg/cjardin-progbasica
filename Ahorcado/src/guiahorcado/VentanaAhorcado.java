package guiahorcado;
/**
 *
 */


import gestor.GestorXML;
import guibasica.VentanaBasica;
import informacion.Ahorcado;
import informacion.AhorcadoException;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
     * @param titulo
     * @throws HeadlessException
     */
    public VentanaAhorcado(String titulo) throws HeadlessException {
	super(titulo);
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
	// obtenemos el boton jugar del PanelJugar
	// y establecemos como oyente a esta ventada
	jugar.getJugar().addActionListener(this);
	// obtenemos los componentes del PanelAlfabeto
	Component[] componentes = alfabeto.getComponents();
	for (int i = 0; i < componentes.length; i++) {
	    // los recorremos y si son JButton
	    if (componentes[i].getClass() == JButton.class) {
		// establecemos como oyente a esta ventana y los deshabilitamos
		((JButton) componentes[i]).addActionListener(this);
		((JButton) componentes[i]).addKeyListener(new TeclasListener());
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

    /**
     * Se encarga de aniadir el PanelFallos
     *
     * @param numFallos
     */
    public void aniadirFallos(int numFallos) {
	fallos = new PanelFallos(numFallos);
	fallos.setBounds(0, 120, 700, 100);
	add(fallos);
    }

    /**
     * Se encarga de deshabilitar los botones alfabeticos habilitados
     *
     */
    public void deshabilitarBotones() {
	Component[] componentes = alfabeto.getComponents();
	for (int i = 0; i < componentes.length; i++) {
	    if (componentes[i].getClass() == JButton.class) {
		if (((JButton) componentes[i]).isEnabled())
		    ((JButton) componentes[i]).setEnabled(false);
	    }

	}
    }

    /**
     * Se encarga de reiniciar los componentes del juego
     *
     */
    public void reiniciar() {
	jugar.getJugar().setEnabled(true);
	fallos.setVisible(false);
	respuesta.getRespuesta().setText("");
	deshabilitarBotones();
    }

    /**
     * Se encarga de realizar el comportamiento de una tirada
     *
     * @param boton
     * @param c
     * @throws JDOMException
     * @throws IOException
     */
    public void jugar(JButton boton, char c) throws JDOMException, IOException {
	if (!propiedades.tirar(c)) { // si la tirada devuelve falso
	    fallos.getFallos()[propiedades.getVidasRestantes()]
		    .setVisible(false); // borramos una imagen de error

	} else {
	    boton.setEnabled(false); // si no deshabilitamos el boton
	}

	// establecemos la respuesta desde las propiedades (clase Ahorcado)
	respuesta.getRespuesta().setText(propiedades.verRespuesta());
	if (propiedades.completo()) { // si se ha acertado la palabra
	    // mostramos un mensaje
	    JOptionPane.showMessageDialog(this, "ENHORABUENA. PALABRA: "
		    + propiedades.getPalabraAAdivinar().toUpperCase(),
		    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	    // obtenemos la instancia del GestorXML
	    GestorXML gx = GestorXML.obtenerInstancia();
	    // aniadimos el acierto al fichero xml
	    gx.aniadirAcierto(propiedades.getPalabraAAdivinar(), propiedades
		    .getPalabraAAdivinar().length());
	    reiniciar(); // reiniciamos

	}
	if (!propiedades.quedanVidas()) { // si no quedan vidas
	    // mostramos un mensaje
	    JOptionPane.showMessageDialog(this, "NO QUEDAN VIDAS. PALABRA: "
		    + propiedades.getPalabraAAdivinar().toUpperCase(),
		    "Mensaje", JOptionPane.INFORMATION_MESSAGE);

	    reiniciar();
	}
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
		jugar(boton, c);

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

    /**
     * Clase TeclasListener encarga de escucher el teclaro
     *
     * @author Iker Garcia Ramirez
     * @date 30/4/2015
     *
     */
    private class TeclasListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent e) {
	    // obtenemos el caracter y si es mayuscula lo convertimos a
	    // minuscula
	    char c = e.getKeyChar();
	    if (c <= 'Z' && c >= 'A') {
		c = (char) (c - ('A' - 'a'));
	    }
	    JButton boton = null;
	    Component[] componentes = alfabeto.getComponents();
	    for (int i = 0; i < componentes.length; i++) {
		// los recorremos y si son JButton
		if (componentes[i].getClass() == JButton.class) {
		    // csi es el boton equivalente al caracter presionado
		    if (((JButton) componentes[i]).getText().toLowerCase()
			    .charAt(0) == c) {
			// lo asignamos
			boton = (JButton) componentes[i];
		    }
		}

	    }
	    if (boton != null) { // si no es nulo
		try {
		    // jugamos
		    jugar(boton, c);
		} catch (JDOMException e1) {
		    e1.printStackTrace();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
	    }

	}
    }
}
