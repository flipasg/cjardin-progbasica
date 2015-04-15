package ejerciciocalc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import crearguis.VentanaBasica;

public class VentanaCalc extends VentanaBasica implements ActionListener {
    private JTextField resultado;
    private PanelBotonesNumericos pb;
    private PanelBotonesOperadores po;

    public VentanaCalc(String titulo) throws HeadlessException {
	super(titulo);
    }
    
    @Override
    public void instanciar() {
	resultado = new JTextField();
	pb = new PanelBotonesNumericos();
	po = new PanelBotonesOperadores();
    }

    @Override
    public void configurar() {
	pb.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
	po.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	resultado.setPreferredSize(new Dimension(250, 40));
	resultado.setBorder(BorderFactory.createTitledBorder("ECUACION"));
	resultado.setDisabledTextColor(Color.BLACK);
	resultado.setEnabled(false);
	setSize(new Dimension(280, 280));
    }

    @Override
    public void aniadir() {
	add("North", resultado);
	add("East", po);
	add("Center", pb);
	
    }

    @Override
    public void oyentes() {}

    @Override
    public void propFinales() {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(false);
    }

    public static void main(String[] args) {
	new VentanaCalc("Calculadora");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	resultado.setText(Integer.toString(pb.getNumero()));
    }
    
    
}
