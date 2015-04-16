/**
 * TemaGUI - ejerciciocalc : VentanaCalc.java
 * @author Ikk
 * @date 16/4/2015 2015
 */
package ejerciciocalc;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import crearguis.VentanaBasica;

//Comienza la clase VentanaCalc
public class VentanaCalc extends VentanaBasica implements ActionListener {
    private JTextField resultado, ecuacion; //JTextFields con la información de los cálculos
    //JButtons con comportamiento similar (números y punto)
    private JButton cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, punto;
    //JButtons con comportamiento similar (operadores, borrado y igual)
    private JButton suma, resta, division, multiplicacion, borrarTodo, borrar, igual;
    
    //no me salía una mejor solución
    private boolean operacionRealizada; //llevaremos el control de si se ha realizado o no una operacion
    private JButton anterior; //el botón que realizará la operación
    private Double numeroResultado; //el resultado del las operacion que llevamos
    private RealizadorDeOperaciones rdo; //realizador de operaciones
    
    /**
     * Constructor de la clase VentanaCalc
     * @param titulo
     * @throws HeadlessException
     */
    public VentanaCalc(String titulo) throws HeadlessException {
	super(titulo);
	rdo = new RealizadorDeOperaciones();
	anterior = null; //en un principio no se hemos pulsado ningún botón
	numeroResultado = 0.0; //nuestro resultado final comienza a 0
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
		    //añadimos nombres a los botones de operación
		    if(boton.getText().equals("+")) boton.setName("suma");
		    if(boton.getText().equals("-")) boton.setName("resta");
		    if(boton.getText().equals("*")) boton.setName("multiplicacion");
		    if(boton.getText().equals("/")) boton.setName("division");
		    
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

    /* Método sobreescrito : actionPerformed
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	//obtenemos el botón origen del evento
	JButton presionado = (JButton) e.getSource();
	
	String textoResultado = resultado.getText(); //texto del resultado actual
	String textoEcuacion = ecuacion.getText(); //texto de la ecuación actual
	String comando = presionado.getActionCommand(); //comando del botón presionado
	String textoBoton = presionado.getText(); //texto del botón presionado
	
	if(comando.equals("numero")) { //si el comando es un numero
	    //si se ha realizado una operacion
	    //se mostrará el resultado y después se borra
	    if(operacionRealizada) textoResultado = ""; 
	    
	    //obtenemos el numero después de presionar el botón
	    String numero = textoResultado+textoBoton;
	    //si es un número válido establecemos el JTextField del resultado al número
	    if(AnalizadorLexico.esNumeroValido(numero)) resultado.setText(numero);
	    operacionRealizada = false; //como no hemos realizado ninguna operación devolvemos el valor a false
	}
	
	if(!textoResultado.equals("")) { //solo escucharemos a los botones de comandos cuando el resultado tenga algún valor
	    if(comando.equals("operador")) {
		//si hemos presionado un botón de operador antes, solo cambiaremos el operador final de la ecuación
		if(operacionRealizada) ecuacion.setText(textoEcuacion.substring(0, textoEcuacion.length()-1)+textoBoton);
		Double numero2 = Double.parseDouble(textoResultado); //obtenemos el número escrito en el resultado
		if(textoEcuacion.equals("")) { //si no tenemos ninguna operacion
		    numeroResultado = numero2; //establecemos ese numero al resultado final numérico
		} else { //si no
		    String nombreMetodo = anterior.getName(); //obtenemos el nombre del botón
		    if(nombreMetodo.equals("division") && numero2==0.0) { //si se tiene que realizar una division y es por 0
			//mostraremos una ventana de error
			JOptionPane.showMessageDialog(this, "Imposible realizar division por 0", "Error", JOptionPane.ERROR_MESSAGE);
			textoResultado = ""; //borraremos el resultado
			ecuacion.setText(textoEcuacion.substring(0, textoEcuacion.length()-1)); //borraremos el operando
		    } else { //si no realizaremos la operación
			numeroResultado = rdo.operar(rdo.buscarMetodo(anterior.getName()), numeroResultado, numero2);
		    }
		}
		
		anterior = presionado; //asignamos el botón presionado al anterior
		resultado.setText(Double.toString(numeroResultado)); //establecemos el resultado
		ecuacion.setText(textoEcuacion+textoResultado+textoBoton); //establecemos la ecuación
		operacionRealizada = true; //hemos realizado una operación
	    }	    
	}
	

	if(comando.equals("igual")) { //si el comando es igual
	    ecuacion.setText(""); //borramos la ecuacion
	    Double numero2 = Double.parseDouble(textoResultado);
	    
	    //realizamos la última operación pendiente
	    String nombreMetodo = anterior.getName();
	    if(nombreMetodo.equals("division") && numero2==0.0) {
		 JOptionPane.showMessageDialog(this, "Imposible realizar division por 0", "Error", JOptionPane.ERROR_MESSAGE);
		 textoResultado = "";
		 ecuacion.setText(textoEcuacion.substring(0, textoEcuacion.length()-1));
	    } else {
		numeroResultado = rdo.operar(rdo.buscarMetodo(anterior.getName()), numeroResultado, numero2);
	    }
	    
	    //establecemos el resultado
	    resultado.setText(Double.toString(numeroResultado));
	    numeroResultado = 0.0; //reiniciamos el resultado numérico
	    operacionRealizada = true; //hemos realizado una operación
	}
	
	if(comando.equals("borrar")) { //si el comando es borrar
	    if(textoBoton.equals("C")) { //C - BORRAR TODO
		ecuacion.setText(""); //reiniciamos la ecuación
		resultado.setText(""); //reiniciamos el resultado
		numeroResultado = 0.0; //reiniciamos el resultado numérico
	    } else { //si no solo borramos un dígito
		if(!textoResultado.equals("")) resultado.setText(textoResultado.substring(0, textoResultado.length()-1));
	    }
	}
	
    } 
    
    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	new VentanaCalc("Calculadora");
    }
    
}
