/**
 * TemaGUI - ejercicio2 : EscuchadorCombo.java
 * @author ikk
 * @date 13/4/2015 2015
 */
package ejercicio2;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

//Comienza la clase EscuchadorCombo
public class EscuchadorCombo implements ItemListener{
    
    @Override
    public void itemStateChanged(ItemEvent e) {
	JComboBox<String> imgns = (JComboBox<String>) e.getSource();
	String img = (String) imgns.getSelectedItem();
	if (e.getStateChange() == ItemEvent.SELECTED) { //si hay un cambio de seleccion
	    //establecemos el icono en la etiqueta
	    PanelImagenes.getEtiquetaImagen().setIcon(PanelImagenes.redimensionarIcono(PanelImagenes.getDir()+img));
	}
    }
}
