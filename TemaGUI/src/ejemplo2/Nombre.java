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
    private JLabel nombreLabel; //declaramos el JLabel
    private JTextField nombre; //declaramos el JTextField
    
    /**
     * Constructor de la clase Nombre
     */
    public Nombre() {
    	setSize(125, 125); //establecemos las dimensiones del JPanel
    	
	nombreLabel = new JLabel("Nombre: "); //instanciamos el JLabel
	nombreLabel.setBounds(0, 0, 125, 20); //colocamos el JLabel en x = 0 y = 0, 125 de ancho y 20 de alto
	
	nombre = new JTextField(100); //instanciamos el JTextField
	nombre.setBounds(0, 20, 125, 20); //colocamos el JTextField
	
	setLayout(null); //quitamos el Layour por defecto
	add(nombreLabel); //añadimos el JLabel
	add(nombre); //añadimos el JTextField
	setVisible(true); //JPanel visible
    } //fin del constructor

} //fin de la clase Nombre
