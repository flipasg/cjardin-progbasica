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
    private JComboBox<Integer> combo; //declaramos el JComboBox
    private JLabel comboLabel; //declaramos el JLabel
    
    /**
     * Constructor de la clase Edad
     */
    public Edad() {
	
	    setSize(125, 125); //establecemos las dimensiones del JPanel
	    
	    //creamos un Vector con el rando de edades 0-120
	    //valdría con un array
            Vector<Integer> edades = new Vector<Integer>();
            for (int i = 0; i < 121; i++) {
                edades.add(i);
            }
            
            comboLabel = new JLabel("Edad: "); //instanciamos el JLabel con el texto "Edad: "
            comboLabel.setBounds(0, 0, 125, 20); //colocamos el JLabel en la posicion x = 0 y = 0, con 125 de ancho y 20 de alto
            
            combo = new JComboBox<Integer>(edades); //instanciamos el JComboBox con el Vector de Integers del 0 al 120
            combo.setBounds(0, 20, 125, 20); //colocamos el JComboBox en la posicion x = 0 y = 20, con 125 de ancho y 20 de alto
            
            setLayout(null); //quitamos el Layout por defecto
            add(comboLabel); //añadimos el JLabel
            add(combo); //añadimos el JComboBox
            setVisible(true); //JPanel visible
            
    } //fin del constructor
} //fin de la clase Edad
