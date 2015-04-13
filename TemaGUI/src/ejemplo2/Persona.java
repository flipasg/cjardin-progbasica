/**
 * TemaGUI - ejemplo2 : Persona.java
 * @author Iker Garcia Ramirez
 * @date 25/03/2015
 */
package ejemplo2;

import java.awt.Color;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Comienza la clase Persona
public class Persona extends JFrame{
    private Edad edad;
    private Nombre nombre;
    public Persona() {
	super("Mi ventana");
	edad = new Edad();
	nombre = new Nombre();
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
	setSize(500, 500);
	add(edad);
	add(nombre);
	setVisible(true);
    }
    
    public static void main(String[] args) {
	Persona person = new Persona();
    }

} // fin de la clase persona
