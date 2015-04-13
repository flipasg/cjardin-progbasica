/**
 * TemaGUI - creaciondeguis : PanelEjemplo.java
 * @author Iker Garcia Ramirez
 * @date 31/03/2015
 */
package creaciondeguis;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Comienza la clase PanelEjemplo
public final class PanelEjemplo extends PanelBasico {
    JLabel etiqueta;
    JTextField campo;
    JButton boton;
    
    /**
     * No hay que poner nada en el constructor...
     */
    public PanelEjemplo() {
     
    }

    /**
     * Instanciamos los componentes:
     */
    public void instanciarGUI() {
     etiqueta = new JLabel("Etiqueta de ejemplo");
     campo = new JTextField(10);
     boton = new JButton("Botón de ejemplo");
    }
    
    /**
     * Se configura la GUI:
     */
    public void configurarGUI() {
     //Ponemos el layout al panel principal:
     this.setLayout(new FlowLayout());
     this.setVisible(true);
    }
    
    /**
     * Se añaden los componentes de la GUI:
     */
    public void anadirAGUI() {
     this.add(etiqueta);
     this.add(campo);
     this.add(boton);
    }
    
    /**
     * Se agregan oyentes a los 
     * componentes de la GUI:
     */
    public void oyentesGUI() {
     
     //Ejemplo de como añadir un oyente de acción a un botón:
     boton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
       //Ponemos aquí las acciones a realizar si damos click al botón:
       accionesBotón();
      }});
    }
    
    /**
     * Se encarga de dar un mensaje al dar click en el botón.
     */
    private void accionesBotón(){
     JOptionPane.showMessageDialog(null, "Has dado click en el botón");
    }
    public static void main(String[] args) {
		PanelEjemplo p = new PanelEjemplo();
	}
   }
