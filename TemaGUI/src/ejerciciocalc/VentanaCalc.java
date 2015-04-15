package ejerciciocalc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import crearguis.VentanaBasica;

public class VentanaCalc extends VentanaBasica implements ActionListener {
    private Calculadora c;
    private JTextField resultado, ecuacion;
    private JButton cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, punto;
    private JButton suma, resta, division, multiplicacion, resto, factorial, borrarTodo, borrar, igual;
    private double numero1;
    private JButton anterior;

    public VentanaCalc(String titulo) throws HeadlessException {
	super(titulo);
	c = new Calculadora();
    }
    
    @Override
    public void instanciar() {
	ecuacion= new JTextField();
	resultado = new JTextField();
	cero = new JButton("0");
	uno = new JButton("1");
	dos = new JButton("2");
	tres = new JButton("3");
	cuatro = new JButton("4");
	cinco = new JButton("5");
	seis = new JButton("6");
	siete = new JButton("7");
	ocho = new JButton("8");
	nueve = new JButton("9");
	punto = new JButton(".");
	suma = new JButton("+");
	resta = new JButton("-");
	division = new JButton("/");
	multiplicacion = new JButton("*");
	resto = new JButton("%");
	borrar = new JButton("C");
	borrarTodo = new JButton("CE");
	igual = new JButton("=");
	factorial = new JButton("!");
    }

    @Override
    public void configurar() {
	ecuacion.setEditable(false);
	resultado.setEditable(false);
	resultado.setBorder(new LineBorder(Color.BLACK, 2));
	GridBagLayout gbl = new GridBagLayout();
	setLayout(gbl);
    }

    @Override
    public void aniadir() {
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.insets = new Insets(1,1,1,1);
	
	gbc.gridy = 2;
	gbc.gridx = 0;
	add(siete, gbc);
	
	gbc.gridy = 2;
	gbc.gridx = 1;
	add(ocho, gbc);
	
	gbc.gridy = 2;
	gbc.gridx = 2;
	add(nueve, gbc);
	
	gbc.gridy = 2;
	gbc.gridx = 3;
	add(borrar, gbc);
	
	gbc.gridy = 2;
	gbc.gridx = 4;
	add(borrarTodo, gbc);
	
	gbc.gridy = 3;
	gbc.gridx = 0;
	add(cuatro, gbc);
	
	gbc.gridy = 3;
	gbc.gridx = 1;
	add(cinco, gbc);
	
	gbc.gridy = 3;
	gbc.gridx = 2;
	add(seis, gbc);
	
	gbc.gridy = 3;
	gbc.gridx = 3;
	add(suma, gbc);
	
	gbc.gridy = 3;
	gbc.gridx = 4;
	add(resta, gbc);
	
	gbc.gridy = 4;
	gbc.gridx = 0;
	add(uno, gbc);
	
	gbc.gridy = 4;
	gbc.gridx = 1;
	add(dos, gbc);
	
	gbc.gridy = 4;
	gbc.gridx = 2;
	add(tres, gbc);
	
	gbc.gridy = 4;
	gbc.gridx = 3;
	add(multiplicacion, gbc);
	
	gbc.gridy = 4;
	gbc.gridx = 4;
	add(division, gbc);

	gbc.gridy = 5;
	gbc.gridx = 2;
	add(punto, gbc);
	
	gbc.gridy = 5;
	gbc.gridx = 3;
	add(resto, gbc);
	
	gbc.gridy = 5;
	gbc.gridx = 4;
	add(igual, gbc);
	
	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.gridwidth = 2;
	gbc.gridy = 5;
	gbc.gridx = 0;
	add(cero, gbc);
	
	gbc.gridwidth = 5;
	gbc.gridy = 0;
	gbc.gridx = 0;
	add(ecuacion, gbc);
	
	gbc.gridy = 1;
	gbc.gridx = 0;
	add(resultado, gbc);
	
    }

    @Override
    public void oyentes() {
	Component[] componentes = getContentPane().getComponents();
	for (int i = 0; i < componentes.length; i++) {
	    if(componentes[i].getClass()==JButton.class) {
		JButton boton = (JButton) componentes[i];
		boton.addActionListener(this);
		if(boton.getText().equals("+") || boton.getText().equals("-") || boton.getText().equals("/") || boton.getText().equals("*") || boton.getText().equals("%")) {
		    boton.setActionCommand("operador");
		} else if(boton.getText().equals("C") || boton.getText().equals("CE")) {
		    boton.setActionCommand("borrar");
		} else if(boton.getText().equals(".")){
		    boton.setActionCommand("punto");
		} else if(boton.getText().equals("=")){
		    boton.setActionCommand("igual");
		} else {
		    boton.setActionCommand("numero");
		}
	    }
	    
	}
    }

    @Override
    public void propFinales() {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(false);
	pack();
    }

    public static void main(String[] args) {
	new VentanaCalc("Calculadora");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	JButton presionado = (JButton) e.getSource();
	String texto = resultado.getText();

	if(texto.equals("")) {
	    if(presionado.getActionCommand().equals("numero")) {
		resultado.setText(texto+presionado.getText());
	    }
	} else {
	    
	    double numero2 = Double.parseDouble(texto);
	    if(presionado.getActionCommand().equals("borrar")) {
		if(presionado.getText().equals("CE")) {
		    resultado.setText("");
		    ecuacion.setText("");
		    numero1 = 0;
		} else {
		    resultado.setText(texto.substring(0, texto.length()-1));
		}
	    } else if(presionado.getActionCommand().equals("operador")){
		anterior = presionado;
		resultado.setText(texto+presionado.getText());
		ecuacion.setText(ecuacion.getText()+resultado.getText());
		
		if(presionado==suma) {
		    numero1+=numero2;
		    resultado.setText(Double.toString(numero1));
		} else if(presionado==resta) {
		    numero1-=numero2;
		    resultado.setText(Double.toString(numero1));
		} else if(presionado==multiplicacion) {
		    if(numero1==0) numero1 = 1;
		    numero1*=numero2;
		    resultado.setText(Double.toString(numero1));
		} else if(presionado==division) {
		   if(numero2!=0) {
		       numero1/=numero2;
		       resultado.setText(Double.toString(numero1));
		   } else {
		       ecuacion.setText("");
		       resultado.setText("ERROR");
		   }

		} else {
		    resultado.setText(Double.toString(numero1));
		    numero1%=numero2;
		}
	    } else if(presionado.getActionCommand().equals("igual")){
		if(anterior==suma) {
		    numero1+=numero2;
		    resultado.setText(Double.toString(numero1));
		} else if(anterior==resta) {
		    numero1-=numero2;
		    resultado.setText(Double.toString(numero1));
		} else if(anterior==multiplicacion) {
		    if(numero1==0) numero1 = 1;
		    numero1*=numero2;
		    resultado.setText(Double.toString(numero1));
		} else if(anterior==division) {
		   if(numero2!=0) {
		       numero1/=numero2;
		       resultado.setText(Double.toString(numero1));
		   } else {
		       ecuacion.setText("");
		       resultado.setText("ERROR");
		   }

		} else {
		    resultado.setText(Double.toString(numero1));
		    numero1%=numero2;
		}
		resultado.setText(Double.toString(numero1));
		ecuacion.setText("");
		numero1 = 0;
	    } else {
		resultado.setText(""+presionado.getText());
	    }
	    
	}
    }
    
    
}
