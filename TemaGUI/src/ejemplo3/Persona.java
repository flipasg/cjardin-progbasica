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
    private JLabel edadLabel, nombreLabel; //declaramos los JLabel
    private JTextField nombre; //declaramos el JTextField
    private JComboBox<Integer> edad; //declaramos el JComboBox
    
    
    /**
     * Constructor de la clase Persona
     */
    public Persona() {
	super("Mi ventana"); //llámamos al constructor de la superclase, da el nombre a la ventana
	
	//vector con las edades 0-120
	Vector<Integer> edades = new Vector<Integer>();
	for (int i = 0; i < 121; i++) {
	    edades.add(i);
	}
	
	//variables de posicionamiento
	int x = 0; //coordenada x
	int y = 0; //coordenada y
	int h = 125; //ancho
	int w = 20; //alto
	//width deberia ser ancho y heigth alto (w y h)
	
	
	edadLabel = new JLabel("Edad: "); //instanciamos el JLabel del JComboBox
	edadLabel.setBounds(x, y, h, w); //colocamos el JLabel
	
	nombreLabel = new JLabel("Nombre: "); //instanciamos el JLabel del JTextField
	x = h; //desplazamos el JLabel a lo ancho
	nombreLabel.setBounds(x, y, h, w); //colocamos el JLabel
	
	edad = new JComboBox<Integer>(edades); //instanciamos el JComboBox con las edades
	edad.setSelectedItem(1); //establecemos el elemento seleccionado
	x = 0; //la coordenada x vuelve a ser 0
	y = w; //desplazamos el JComboBox en vertical (a lo alto)
	edad.setBounds(x, y, h, w); //colocamos el JComboBox
	
	nombre = new JTextField(100); //instanciamos el JTextField
	x = h; //desplazamos el JTextField a lo ancho
	nombre.setBounds(x, y, h, w); //colocamos el JTextField
	
	setLayout(null); //quitamos el Layout por defecto
	setDefaultCloseOperation(EXIT_ON_CLOSE); //establecemos la accion al cerrar la ventana
	setSize(500, 500); //establecemos las dimensiones del JFrame
	
	add(edadLabel); //añadimos el JLabel de la edad
	add(nombreLabel); //añadimos el JLabel del nombre
	add(edad); //añadimos el JComboBox de la edad
	add(nombre); //añadimos el JTextField del nombre
	
	setVisible(true); //JFrame visible
    } //fin del constructor
    
    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	Persona person = new Persona(); //declaramos e instanciamos la persona
    } //fin del main

} // fin de la clase persona

