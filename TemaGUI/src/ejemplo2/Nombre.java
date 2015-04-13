/**
 * TemaGUI - ejemplo2 : Nombre.java
 * @author Iker Garcia Ramirez
 * @date 25/03/2015
 */
package ejemplo2;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Comienza la clase Nombre
public class Nombre extends JPanel{
    private JLabel nombreLabel;
    private JTextField nombre;
    
    public Nombre() {
    	setSize(125, 125);
	JFrame n = new JFrame();
	nombreLabel = new JLabel("Nombre: ");
	nombreLabel.setBounds(0, 0, 125, 20);
	nombre = new JTextField(100);
	nombre.setBounds(0, 20, 125, 20);
	setVisible(true);
	add(nombreLabel);
	add(nombre);
	setVisible(true);
    }

}
