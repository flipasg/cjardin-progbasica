/**
 * TemaGUI - creaciondeguis : EjemploGUI.java
 * @author Iker Garcia Ramirez
 * @date 31/03/2015
 */
package creaciondeguis;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Comienza la clase EjemploGUI
public class EjemploGUI {
    //Declaramos los componentes que usaremos:
    JFrame ventana;
    JLabel etiqueta;
    JTextField campo;
    JButton boton;
    
    //En el constructor solo llamamos un método:
    public EjemploGUI(){
     iniciarGUI();
    }
    
    /**
     * Método que se encarga de llamar a todos los métodos
     * encargados de crear la GUI y mostrarla.
     */
    public void iniciarGUI(){
     instanciarGUI();
     configurarGUI();
     añadirAGUI();
     oyentesGUI();
     //La ventana se muestra al llamar este método:
     ventana.setVisible(true);
    }
    
    /**
     * Se encarga de instanciar cada componente que va en 
     * nuestra GUI.
     */
    private void instanciarGUI() {
     ventana = new JFrame("Ejemplo GUI #3");
     etiqueta = new JLabel("Etiqueta de ejemplo #3");
     campo = new JTextField(10);
     boton = new JButton("Botón De Ejemplo #3");
    }
    
    /**
     * Se encarga de configurar a todos los componentes,
     * como por ejemplo dar color a un boton o campo, cambiar
     * tamaños etc.
     */
    private void configurarGUI() {
     //Ponemos una acción de cerrado por default (salir en este caso):
     ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //Ponemos el layout:
     ventana.setLayout(new FlowLayout());
    }
    
    /**
     * Se encarga de añadir cualquier componente en la GUI.
     */
    private void añadirAGUI() {
     ventana.add(etiqueta);
     ventana.add(campo); 
     ventana.add(boton);
     //Se llama a pack después de haber agregado componenetes a la ventana
     ventana.pack();
    }
    
    /**
     * Se encarga de añadir los oyentes, ya sea de mouse,
     * teclado o similares.
     */
    private void oyentesGUI() {
     
     //Ejemplo de como añadir un oyente de acción a un botón:
     boton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
       //Ponemos aquí las acciones a realizar si damos click al botón:
       accionesBotón();
      }});
    }
    
    /**
     * Método encargado de dar un mensaje:
     */
    private void accionesBotón(){
     JOptionPane.showMessageDialog(null, "Has dado click en el botón");
    }
    
    public void llenarCampo(String texto){
     campo.setText(texto);
    }
    
    public static void main(String[] args){
     //Llamamos a una nueva instancia de la clase y a un método en la misma:
     new EjemploGUI().llenarCampo("¡Hola mundo!");
    }
    
   }
