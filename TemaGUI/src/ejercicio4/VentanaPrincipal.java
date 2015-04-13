/**
 * TemaGUI - ejercicio4 : VentanaPrincipal.java
 * @author ikk
 * @date 13/4/2015 2015
 */
package ejercicio4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

//Comienza la clase VentanaPrincipal
public class VentanaPrincipal extends JFrame implements ActionListener {
    private JTextField directorio;
    private JScrollPane scrollText;
    private JTextArea textoFichero;
    private JButton resetear;
    private JComboBox<String> archivos;
    
    
    /**
     * Constructor de la clase VentanaPrincipal
     */
    public VentanaPrincipal() {
	//instanciamos
	directorio = new JTextField(100);
	archivos = new JComboBox<String>();
	textoFichero = new JTextArea(100, 100);
	//ocultamos las barras de scroll
	scrollText = new JScrollPane(textoFichero, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	resetear = new JButton("RESETEAR");
	
	//configuramos los componentes
	archivos.setEnabled(false);
	textoFichero.setEnabled(false);
	scrollText.setEnabled(false);
	
	//configuramos la ventana
	setResizable(false);
	setSize(500,320);
	setLayout(null);
	
	//colocamos y añadimos
	directorio.setBounds(10, 10, 200, 20);
	add(directorio);
	archivos.setBounds(10, 40, 150, 20);
	add(archivos);
	scrollText.setBounds(200, 40, 250, 200);
	add(scrollText);
	resetear.setBounds(200, 250, 100, 20);
	add(resetear);
	
	//comandos y oyentes
	directorio.setActionCommand("texto");
	directorio.addActionListener(this);
	archivos.setActionCommand("menu");
	archivos.addActionListener(this);
	resetear.setActionCommand("resetear");
	resetear.addActionListener(this);
	
	//propiedades finales
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
    }
    
    /* Método sobreescrito : actionPerformed
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("texto")){ //si el comando es texto
	    JTextField dir = (JTextField) e.getSource(); //JTextField
	    if(dir.getText().equals("")) { //si esta vacio
		dir.setBorder(new LineBorder(Color.RED)); //marcamos los bordes de rojo
		//lanzamos el mensaje de error 
		JOptionPane.showMessageDialog(dir, "El campo no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
	    } else { //si no esta vacio
		File f = new File(dir.getText());
		if(!f.isDirectory()) { //si NO es directorio
		    dir.setBorder(new LineBorder(Color.RED)); //marcamos los bordes de rojo
		    dir.setText(null); //vaciamos el JTextField
		    //lanzamos el mensaje de error
		    JOptionPane.showMessageDialog(dir, "No es un directorio", "Error", JOptionPane.ERROR_MESSAGE);
		} else { //si es directorio
		    String[] arrayArchivos = f.list(); //creamos un array de la lista de archivos
		    for (int i = 0; i < arrayArchivos.length; i++) {
			archivos.addItem(arrayArchivos[i]); //añadimos cada archivo al JComboBox
		    }
		    archivos.setEnabled(true); //habilitamos el JComboBox
		}
	    }
	} else if(e.getActionCommand().equals("menu")) { //si el comando es el menu
	    JComboBox<String> listaArchivos = (JComboBox<String>) e.getSource(); //JComboBox
	    if(listaArchivos.isEnabled() && listaArchivos.getSelectedIndex()!=-1) { //si esta activado y se ha seleccionado un item
		//hacemos visibles las barras de escroll y activamos el panel
		scrollText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollText.setEnabled(true);
		textoFichero.setText(null); //vaciamos el JTextField con el texto del fichero
		try {
		    //abrimos un reader del fichero seleccionado en el JComboBox
		    BufferedReader br = new BufferedReader(new FileReader(directorio.getText()+"/"+listaArchivos.getSelectedItem()));
		    String linea = "";
		    while ((linea = br.readLine()) != null) {
			textoFichero.append(linea+"\n"); //añadimos al final del JTextField la linea leida   
		    }
		    br.close(); //cerramos el reader
		    //ponemos el color del texto en negro, ya que al estar desahabilitado el color es un azul claro
		    textoFichero.setDisabledTextColor(Color.BLACK);
		} catch (FileNotFoundException e1) {
		    JOptionPane.showMessageDialog(listaArchivos, "No se encuentra el archivo", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e1) {
		    JOptionPane.showMessageDialog(scrollText, "Error de entrada/salida", "Error", JOptionPane.ERROR_MESSAGE);
		}
	    }
	    
	} else { //si el comando es distinto (resetear)
	    JButton presionado = (JButton) e.getSource();
	    if(presionado==resetear) { //si se ha presionado el boton
		directorio.setText(null); //vaciamos el campo donde se escribe el directorio
		archivos.removeAllItems(); //vaciamos el JComboBox
		archivos.setEnabled(false); //deshabilitamos el JComboBox
		textoFichero.setText(null); //vaciamos el texto del fichero
		textoFichero.setEnabled(false); //deshabilitamos el texto del fichero
		//ocultamos las barras de scroll y desactivamos el panel
		scrollText.setEnabled(false);
		scrollText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    }
	}
	
    }
    
    public static void main(String[] args) {
	VentanaPrincipal v = new VentanaPrincipal();
    }


}

