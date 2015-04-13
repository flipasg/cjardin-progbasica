/**
 * TemaGUI - ejemplo : DialogoNombre.java
 * @author Iker Garcia Ramirez
 * @date 23/03/2015
 */
package ejemplo;

import javax.swing.JButton;
import javax.swing.JTextField;

//Comienza la clase DialogoNombre
public class DialogoNombre {
    private JButton boton;
    private JTextField cuadroTexto;
    private VentanaPrincipal ventana;
    private String nombre;
    
    /**
     * Contructor de la clase DialogoNombre
     * @param boton
     * @param cuadroTexto
     * @param ventana
     * @param nombre
     */
    public DialogoNombre(JButton boton, JTextField cuadroTexto,
	    VentanaPrincipal ventana, String nombre) {
	this.boton = boton;
	this.cuadroTexto = cuadroTexto;
	this.ventana = ventana;
	this.nombre = nombre;
    }
    
    
    
    
}
