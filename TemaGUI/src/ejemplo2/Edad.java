/**
 * TemaGUI - ejemplo2 : Edad.java
 * @author Iker Garcia Ramirez
 * @date 25/03/2015
 */
package ejemplo2;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Comienza la clase Edad
public class Edad extends JPanel{
    private JComboBox<Integer> combo;
    private JLabel comboLabel;
    
    public Edad() {
	    setSize(125, 125);
		Vector<Integer> edades = new Vector<Integer>();
		for (int i = 0; i < 121; i++) {
		    edades.add(i);
		}
		comboLabel = new JLabel("Edad: ");
		comboLabel.setBounds(0, 0, 125, 20);
		combo = new JComboBox<Integer>(edades);
		combo.setBounds(0, 20, 125, 20);
		setLayout(null);
		add(comboLabel);
		add(combo);
		setVisible(true);
    }
}
