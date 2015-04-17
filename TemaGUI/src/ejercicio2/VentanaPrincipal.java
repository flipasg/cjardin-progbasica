package ejercicio2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private PanelImagenes pi;
    private Comentario c;
    private JButton boton;
    
    /**
     * Constructor de la clase VentanaPrincipal
     */
    public VentanaPrincipal() {
	//instanciamos
	pi = new PanelImagenes();
	c = new Comentario();
	boton = new JButton("Guardar");
	
	//configuramos
	setSize(500, 320);
	setLayout(null);
	
	//colocamos y añadimos
	pi.setBounds(20, 20, 200, 200);
	add(pi);
	c.setBounds(20, 220, 500, 20);
	add(c);
	boton.setBounds(210, 260, 80, 20);
	add(boton);
	
	//establecemos oyentes
	boton.addActionListener(this);
	
	//usamos un adapter para implementar solo el metodo del cierre de ventana
	addWindowListener(new WindowAdapter() {
	    
	    @Override
	    public void windowClosing(WindowEvent e) {
		JOptionPane.showMessageDialog(getContentPane(), "ADIOS");
	    }
	    
	});
	
	//propiedades finales
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(false);
    }
    
    /* Método sobreescrito : actionPerformed
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	if(c.getSnComentario().isSelected()) { //si el checkbox esta seleccionado
	    String dir = "txt/"; //directorio para txt
	    String comentario = c.getComentario().getText(); //comentario
	    String imagen = (String) pi.getImagenes().getSelectedItem(); //imagen con extension
	    try {
		//usamos un BufferedReader para escribir linea a linea
		BufferedWriter bw = new BufferedWriter(new FileWriter(dir+imagen.substring(0, imagen.indexOf("."))+".txt", true));
		bw.write(comentario); //escribimos el comentario
		bw.newLine(); //pasamos a la siguiente linea
		bw.close(); //cerramos el reader
	    } catch (IOException e1) {
		System.err.println("Error de entrada/salida");
		e1.printStackTrace();
	    }
	    
	}
    }
}
