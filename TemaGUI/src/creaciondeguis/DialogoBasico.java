/**
 * TemaGUI - creaciondeguis : DialogoBasico.java
 * @author Iker Garcia Ramirez
 * @date 31/03/2015
 */
package creaciondeguis;

import javax.swing.JDialog;

//Comienza la clase DialogoBasico
public abstract class DialogoBasico extends JDialog implements GUIBasica {

	/**
	 * M�todo : DialogoB�sico
	 * 
	 * @param titulo
	 */
	public DialogoBasico(String titulo) {
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
		configDialogo();
	}

	/**
	 * M�todo : configDialogo
	 */
	public abstract void configDialogo();
}
