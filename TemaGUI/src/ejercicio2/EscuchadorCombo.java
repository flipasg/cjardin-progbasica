/**
 * TemaGUI - ejercicio2 : EscuchadorCombo.java
 * @author ikk
 * @date 13/4/2015 2015
 */
package ejercicio2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

//Comienza la clase EscuchadorCombo
public class EscuchadorCombo implements ActionListener{
    private PanelImagenes p;
    
    /**
     * Constructor de la clase EscuchadorCombo
     */
    public EscuchadorCombo(PanelImagenes p) {
	this.p = p;
    }

    /* Método sobreescrito : actionPerformed
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	JComboBox<String> imgns = p.getImagenes();
	String img = (String) imgns.getSelectedItem();
	p.getEtiquetaImagen().setIcon(p.redimensionarIcono(PanelImagenes.getDir()+img));
    }
}
