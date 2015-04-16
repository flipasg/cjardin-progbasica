package ejerciciocalc;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import crearguis.VentanaBasica;

public class VentanaCalc extends VentanaBasica implements ActionListener {
    private JTextField resultado, ecuacion; //JTextFields con la información de los cálculos
    //JButtons con comportamiento similar (números y punto)
    private JButton cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, punto;
    //JButtons con comportamiento similar (operadores, borrado y igual)
    private JButton suma, resta, division, multiplicacion, borrarTodo, borrar, igual;
    private Calculadora c;
    /**
     * Constructor de la clase VentanaCalc
     * @param titulo
     * @throws HeadlessException
     */
    public VentanaCalc(String titulo) throws HeadlessException {
	super(titulo);
	c = new Calculadora();
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
	//obtenemos el botón origen del evento
	JButton presionado = (JButton) e.getSource();
	
	String textoResultado = resultado.getText();
	String textoEcuacion = ecuacion.getText();
	String comando = presionado.getActionCommand();
	String textoBoton = presionado.getText();
	
	if(comando.equals("numero")) {
	    String numero = textoResultado+textoBoton;
	    if(AnalizadorLexico.esNumeroValido(numero)) resultado.setText(numero);
	}
	if(comando.equals("operador")) {
	    if(!textoResultado.equals("")) {
		
		
		ecuacion.setText(textoEcuacion+textoResultado+textoBoton);
	    }
	    
	}
	if(comando.equals("borrar")) {
	    if(textoBoton.equals("C")) {
		ecuacion.setText("");
		resultado.setText("");
	    } else {
		if(!textoResultado.equals("")) resultado.setText(textoResultado.substring(0, textoResultado.length()-1));
	    }
	}
	
    } 
    
}
