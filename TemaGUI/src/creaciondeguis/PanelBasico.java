/**
 * TemaGUI - creaciondeguis : PanelBasico.java
 * @author Iker Garcia Ramirez
 * @date 31/03/2015
 */
package creaciondeguis;

import javax.swing.JPanel;

//Comienza la clase PanelBasico
public abstract class PanelBasico extends JPanel implements GUIBasica {

	/**
	 * Contructor de la clase PanelBasico
	 */
	public PanelBasico() {
		super();
		iniciarGUI();
	}

	/**
	 * M�todo : iniciarGUI
	 */
	public void iniciarGUI() {
		instanciarGUI();
		configurarGUI();
		anadirAGUI();
		oyentesGUI();
	}
}
