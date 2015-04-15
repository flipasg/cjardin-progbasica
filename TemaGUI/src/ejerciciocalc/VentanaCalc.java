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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import crearguis.VentanaBasica;

public class VentanaCalc extends VentanaBasica implements ActionListener {
    private JTextField resultado, ecuacion; //JTextFields con la información de los cálculos
    //JButtons con comportamiento similar (números y punto)
    private JButton cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, punto;
    private JButton suma, resta, division, multiplicacion, borrarTodo, borrar, igual;
    private double numero1;
    private JButton anterior;

    /**
     * Constructor de la clase VentanaCalc
     * @param titulo
     * @throws HeadlessException
     */
    public VentanaCalc(String titulo) throws HeadlessException {
	super(titulo);
    }
    
    /**
     * Método : calcular
     * @param boton
     * @param numero2
     */
    private void calcular(JButton boton, double numero2) {
	if(boton==suma) {
	    numero1+=numero2;
	    resultado.setText(Double.toString(numero1));
	} else if(boton==resta) {
	    numero1-=numero2;
	    resultado.setText(Double.toString(numero1));
	} else if(boton==multiplicacion) {
	    if(numero1==0) numero1 = 1;
	    numero1*=numero2;
	    resultado.setText(Double.toString(numero1));
	} else if(boton==division) {
	    if(numero2!=0) {
		numero1/=numero2;
		resultado.setText(Double.toString(numero1));
	    } else {
		JOptionPane.showMessageDialog(this, "No es posible realizar una division entre 0", "Error", JOptionPane.ERROR_MESSAGE);
		ecuacion.setText("");
		resultado.setText("");
		numero1 = 0;
	    }

	} 
    }
    
    /* Método sobreescrito : instanciar
     * @see crearguis.VentanaBasica#instanciar()
     */
    @Override
    public void instanciar() {
	//JTextFields
	ecuacion= new JTextField();
	resultado = new JTextField();
	//JButtons
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
	borrar = new JButton("C");
	borrarTodo = new JButton("CE");
	igual = new JButton("=");
    }

    /* Método sobreescrito : configurar
     * @see crearguis.VentanaBasica#configurar()
     */
    @Override
    public void configurar() {
	ecuacion.setEditable(false); //no se puede escribir en ningún JTextFields
	resultado.setEditable(false);
	resultado.setBorder(new LineBorder(Color.BLACK, 2));
	GridBagLayout gbl = new GridBagLayout();
	setLayout(gbl);
    }

    /* Método sobreescrito : aniadir
     * @see crearguis.VentanaBasica#aniadir()
     */
    @Override
    public void aniadir() {
	//propiedades del GridBagLayout
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.insets = new Insets(1,1,1,1); //margen entre componentes
	
	gbc.gridy = 2; //fila
	gbc.gridx = 0; //columna
	add(siete, gbc); //añadimos el componente en la posicion
	
	//se repite lo mismo con cada componente
	//se explicarán las nuevas propiedades
	
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
	
	//coge el ancho hasta encontrar otro componente
	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.gridwidth = 2; //su rejilla ocupa dos columnas
	gbc.gridy = 5;
	gbc.gridx = 0;
	add(cero, gbc);
	
	gbc.gridy = 5;
	gbc.gridx = 3;
	add(igual, gbc);
	
	gbc.gridwidth = 5;
	gbc.gridy = 0;
	gbc.gridx = 0;
	add(ecuacion, gbc);
	
	gbc.gridy = 1;
	gbc.gridx = 0;
	add(resultado, gbc);
	
    }

    /* Método sobreescrito : oyentes
     * @see crearguis.VentanaBasica#oyentes()
     */
    @Override
    public void oyentes() {
	Component[] componentes = getContentPane().getComponents(); //array de componentes del JFrame
	for (int i = 0; i < componentes.length; i++) {
	    if(componentes[i].getClass()==JButton.class) { //si los componentes son botones
		JButton boton = (JButton) componentes[i];
		boton.addActionListener(this); //añadimos la ventana como oyente a todos los botones
		if(boton.getText().equals("+") || boton.getText().equals("-") || boton.getText().equals("/") 
			|| boton.getText().equals("*")) {
		    boton.setActionCommand("operador"); //si es un botón de operador le añadimos el comando operador
		} else if(boton.getText().equals("C") || boton.getText().equals("CE")) {
		    boton.setActionCommand("borrar"); //si es un botón de borrado le añadimos el comando borrar
		} else if(boton.getText().equals(".")){
		    boton.setActionCommand("punto");
		} else if(boton.getText().equals("=")){
		    boton.setActionCommand("igual");
		} else {
		    boton.setActionCommand("numero"); //los botones restantes son números
		}
	    }
	    
	}
    }

    /* Método sobreescrito : propFinales
     * @see crearguis.VentanaBasica#propFinales()
     */
    @Override
    public void propFinales() {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(false);
	pack();
    }

    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	new VentanaCalc("Calculadora");
    }

    /* Método sobreescrito : actionPerformed
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	JButton presionado = (JButton) e.getSource();
	String texto = resultado.getText();
//	HAY QUE MIRAR MEJOR EL MÉTODO
//	
//	if(texto.equals("")) {
//	    if(presionado.getActionCommand().equals("numero")) {
//		//numero1 = Double.parseDouble(presionado.getText());
//		resultado.setText(texto+presionado.getText());
//	    }
//	} else {
//	    double numero2 = Double.parseDouble(texto);
//	    if(presionado.getActionCommand().equals("borrar")) {
//		if(presionado.getText().equals("CE")) {
//		    resultado.setText("");
//		    ecuacion.setText("");
//		    numero1 = 0;
//		} else {
//		    resultado.setText(texto.substring(0, texto.length()-1));
//		}
//	    } else if(presionado.getActionCommand().equals("operador")){
//		//anterior = presionado;
//		resultado.setText(texto+presionado.getText());
//		ecuacion.setText(ecuacion.getText()+resultado.getText());
//		
//		calcular(presionado, numero2);
//	    } else if(presionado.getActionCommand().equals("igual")){
//		calcular(anterior, numero2);
//		resultado.setText(Double.toString(numero1));
//		ecuacion.setText("");
//		anterior = null;
//		numero1 = 0;
//	    } else {
//		if(!anterior.getActionCommand().equals("numero")) texto = "";
//		
//		resultado.setText(texto+presionado.getText());
//		
//		numero1 = Double.parseDouble(resultado.getText());
//	    }
//	    
//	}
//	anterior = presionado;
    }
    
    
}
