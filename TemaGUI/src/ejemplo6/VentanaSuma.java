/**
 * TemaGUI - ejemplo6 : VentanaSuma.java
 * @author Iker Garcia Ramirez
 * @date 01/04/2015
 */
package ejemplo6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//Comienza la clase VentanaSuma
public class VentanaSuma extends JFrame implements ActionListener{
    private JButton boton;
    private JTextField numero1;
    private JTextField numero2;
    private JLabel resultado;
    private JLabel numero1Label;
    private JLabel numero2Label;
    private JRadioButton sumar, restar, dividir, multiplicar;
    
    public VentanaSuma() {
	ButtonGroup operaciones = new ButtonGroup();
	operaciones.add(sumar);
	operaciones.add(restar);
	operaciones.add(dividir);
	operaciones.add(multiplicar);
	//instanciar
	sumar = new JRadioButton("SUMAR");
	restar = new JRadioButton("RESTAR");
	dividir = new JRadioButton("DIVIDIR");
	multiplicar = new JRadioButton("MULTIPLICAR");
	boton = new JButton("EJECUTAR");
	numero1 = new JTextField(5);
	numero2 = new JTextField(5);
	numero1Label = new JLabel("NUMERO1: ");
	numero2Label = new JLabel("NUMERO2: ");
	resultado = new JLabel("RESULTADO");
	//config
	setLayout(new FlowLayout());
	setSize(150,300);
	setResizable(false);
	setVisible(true);
	//add
	add(numero1Label);
	add(numero1);
	add(numero2Label);
	add(numero2);
	add(sumar);
	add(restar);
	add(multiplicar);
	add(dividir);
	add(boton);
	add(resultado);
	//listener
	boton.addActionListener(this);
    }
    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	VentanaSuma vs = new VentanaSuma();
    }
    /* 
     * Método sobreescrito : actionPerformed
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	JButton presionado = (JButton) e.getSource();
	float num1 = Float.parseFloat(numero1.getText());
	float num2 = Float.parseFloat(numero2.getText());
	if(presionado==boton) {
	    if(sumar.isSelected()) {
		float suma = num1 + num2;
		add(new JLabel("SUMA: "+suma));
		setVisible(true);
	    }
	    if(restar.isSelected()) {
		float resta = num1 - num2;
		add(new JLabel("RESTA: "+resta));
	    }
	    if(dividir.isSelected()) {
		float division = num1 / num2;
		add(new JLabel("DIVISION: "+division));
	    }
	    if(multiplicar.isSelected()) {
		float multiplicacion = num1 * num2;
		add(new JLabel("MULTIPLICACION: "+multiplicacion));
	    }

	    setVisible(true);
	}
    }

}
