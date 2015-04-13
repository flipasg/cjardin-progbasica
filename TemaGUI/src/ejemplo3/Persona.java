/**
 * TemaGUI - ejemplo2 : Persona.java
 * @author Iker Garcia Ramirez
 * @date 25/03/2015
 */
package ejemplo3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//Comienza la clase Persona
public class Persona extends JFrame{
    private JLabel edadLabel, nombreLabel;
    private JTextField nombre;
    private JComboBox<Integer> edad;
    
    
    public Persona() {
	super("Mi ventana");
	Vector<Integer> edades = new Vector<Integer>();
	for (int i = 0; i < 121; i++) {
	    edades.add(i);
	}
	
	int x = 0;
	int y = 0;
	int h = 125;
	int w = 20;
	edadLabel = new JLabel("Edad: ");
	edadLabel.setBounds(x, y, h, w);
	nombreLabel = new JLabel("Nombre: ");
	x = h;
	nombreLabel.setBounds(x, y, h, w);
	edad = new JComboBox<Integer>(edades);
	edad.setSelectedItem(1);
	x = 0;
	y = w;
	edad.setBounds(x, y, h, w);
	nombre = new JTextField(100);
	x = h;
	nombre.setBounds(x, y, h, w);
	setLayout(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(500, 500);
	add(edadLabel);
	add(nombreLabel);
	add(edad);
	add(nombre);
	setVisible(true);
    }
    
    public static void main(String[] args) {
	Persona person = new Persona();
    }

} // fin de la clase persona

