/**
 * TemaGUI - ejemplo4 : VentanaVertical.java
 * @author Iker Garcia Ramirez
 * @date 30/03/2015
 */
package ejemplo4;

import javax.swing.JFrame;

//Comienza la clase VentanaVertical
public class VentanaVertical extends JFrame{
    private ListaCheck lista;
    private ListaCheckBox listaBox;
    
    /**
     * Contructor de la clase VentanaVertical
     */
    public VentanaVertical() {
		lista = new ListaCheck();
		listaBox = new ListaCheckBox();
		setSize(250, 500);
		setVisible(true);
		setLayout(null);
		add(lista);
		lista.setBounds(20, 20, 125, 125);
		add(listaBox);
		listaBox.setBounds(20, 30+lista.getHeight(), 125, getHeight());
	    }
    
    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	VentanaVertical vv = new VentanaVertical();
    }
}
