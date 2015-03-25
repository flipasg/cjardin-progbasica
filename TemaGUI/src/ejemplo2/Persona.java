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
    private Edad edad; //declaramos la edad
    private Nombre nombre; //declaramos el nombre
    
    /**
     * Constructor de la clase Persona
     */
    public Persona() {
		super("Mi ventana"); //ll�mamos al m�todo de la superclase, da el t�tulo a la ventana
		
		//instanciamos las variables
		edad = new Edad();
		nombre = new Nombre();
		
		setSize(500, 500); //establecemos las dimensiones del JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE); //establecemos la acci�n por defecto al cerrar la ventana
		setLayout(null); //quitamos el Layout por defecto
		
		add(edad); //a�adimos la edad
		add(nombre); //a�adimos el nombre
		
		edad.setBounds(0, 0, 125, 125); //colocamos la edad en el JFrame
		nombre.setBounds(125, 0, 125, 125); //colocamos el nombre en el JFrame
		
		setVisible(true); //JFrane visible
    } //fin del constructor
    
    /**
     * M�todo : main
     * @param args
     */
    public static void main(String[] args) {
    	Persona person = new Persona();
    } //fin del main

} // fin de la clase persona
