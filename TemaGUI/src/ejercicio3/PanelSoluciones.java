/**
 * TemaGUI - ejercicio3 : PanelSoluciones.java
 * @author ikk
 * @date 13/4/2015 2015
 */
package ejercicio3;

import javax.swing.JLabel;
import javax.swing.JPanel;

//Comienza la clase PanelSoluciones
public class PanelSoluciones extends JPanel{
    private JLabel s1, s2;
    
    /**
     * Constructor de la clase PanelSoluciones
     */
    public PanelSoluciones() {
	//instanciamos
	s1 = new JLabel("Solucion 1: ");
	s2 = new JLabel("Solucion 2: ");
	
	//a�adimos
	add(s1);
	add(s2);
	
	//propiedades finales
	setVisible(true);
    }

    /**
     * M�todo obtener : getS1
     * @return el s1 de la clase
     */
    public JLabel getS1() {
        return s1;
    }

    /**
     * M�todo obtener : getS2
     * @return el s2 de la clase
     */
    public JLabel getS2() {
        return s2;
    }
}
