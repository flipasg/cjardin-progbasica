/**
 * TemaGUI - ejemplo5 : VentanaColores.java
 * @author Iker Garcia Ramirez
 * @date 31/03/2015
 */
package ejemplo5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//Comienza la clase VentanaColores
public class VentanaColores extends JFrame implements ActionListener {
    private PanelDibujo pDibujo;
    private JComboBox<String> comboColores;
    
    public VentanaColores(String titulo) {
	super(titulo);
	pDibujo = new PanelDibujo();
	String[] colores = {"BLACK", "BLUE", "YELLOW"};
	comboColores = new JComboBox<>(colores);
	setSize(125,125);
	add(comboColores);
	comboColores.addActionListener(this);
	add(pDibujo);
	setLayout(new FlowLayout());
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(500, 500);
	pack();
    }
    /* 
     * Método sobreescrito : actionPerformed
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
	String seleccion = (String) comboColores.getSelectedItem();
	if(seleccion.equals("BLACK")) {
	    pDibujo.setBackground(Color.BLACK);
	}
	if(seleccion.equals("YELLOW")) {
	    pDibujo.setBackground(Color.YELLOW);
	}
	if(seleccion.equals("BLUE")) {    
	    pDibujo.setBackground(Color.BLUE);
	}
    }
    public static void main(String[] args) {
	VentanaColores v = new VentanaColores("Cambiar Background");
    }
    
    
}
