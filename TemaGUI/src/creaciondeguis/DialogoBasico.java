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
     * Método : DialogoBásico
     * @param titulo
     */
    public DialogoBasico(String titulo){
	super();
	iniciarGUI();
	this.setTitle(titulo);
    }
    

    /**
     * Método : iniciarGUI
     */
    public void iniciarGUI(){
	instanciarGUI();
	configurarGUI();
	anadirAGUI();
	oyentesGUI();
	configDialogo();
    }
    
    /**
     * Método : configDialogo
     */
    public abstract void configDialogo();
   }
