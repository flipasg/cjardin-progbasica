/**
 * TemaGUI - creaciondeguis : VentanaBasica.java
 * @author Iker Garcia Ramirez
 * @date 31/03/2015
 */
package creaciondeguis;

import javax.swing.JFrame;

//Comienza la clase VentanaBasica
public abstract class VentanaBasica extends JFrame implements GUIBasica {

	/**
	 * M�todo : VentanaBasica
	 * 
	 * @param titulo
	 */
	public VentanaBasica(String titulo) {
		super();
		iniciarGUI();
		this.setTitle(titulo);
	}

	/**
	 * M�todo : iniciarGUI
	 */
	public void iniciarGUI() {
		instanciarGUI();
		configurarGUI();
		anadirAGUI();
		oyentesGUI();
		configVentana();
	}

	/**
	 * Se encarga de configurar los �ltimos detalles de la ventana tales como:
	 * pack(); setAlwaysOnTop(true); setVisible(true);
	 * setLocationRelativeTo(null); setResizable(false); Que se deben poner
	 * despu�s de agregar componentes a la ventana.
	 */
	abstract void configVentana();
}
