/**
 *
 */
package ejercicio5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.jdom2.JDOMException;

/**
 * @author Iker Garcia Ramirez
 * @date 1/5/2015
 *
 */
public class DialogoPedido extends JDialog implements ActionListener {
    private JLabel primero, primeroImagen, segundo, segundoImagen, adicionales,
    precioTotal;
    private JButton aceptar, descartar;
    private ArrayList<Plato> p;

    /**
     * Constructor de la clase DialogoPedido
     *
     * @param owner
     * @param title
     * @param modal
     * @param p
     */
    public DialogoPedido(Frame owner, String title, boolean modal,
	    ArrayList<Plato> p) {
	super(owner, title, modal);
	this.p = p;
	iniciar();
    }

    private void iniciar() {
	instanciar();
	configurar();
	aniadir();
	oyentes();
	propiedadesFinales();
    }

    /**
     * Se encarga de configurar el dialogo
     *
     */
    private void configurar() {
	// establecemos el tamanio y el layout
	setSize(new Dimension(600, 600));
	setLayout(new GridBagLayout());
	// establecemos el tamanio y tipo de letra de las estiquetas
	primero.setFont(new Font("Arial", Font.BOLD, 16));
	segundo.setFont(new Font("Arial", Font.BOLD, 16));
	adicionales.setFont(new Font("Arial", Font.BOLD, 14));
	precioTotal.setFont(new Font("Arial", Font.BOLD, 20));
	precioTotal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
    }

    /**
     * Se encarga de instanciar los componentes del dialogo
     *
     */
    private void instanciar() {
	adicionales = new JLabel();
	float sumaAdicionales = 0.0f;
	for (Plato plato : p) {
	    if (plato.getTipo().equals("primero")) {
		primero = new JLabel(plato.getNombre() + " "
			+ plato.getPrecio() + " €");
		primeroImagen = new JLabel(
			redimensionarIcono(plato.getImagen()));
	    }
	    if (plato.getTipo().equals("principal")) {
		segundo = new JLabel(plato.getNombre() + " "
			+ plato.getPrecio() + " €");
		segundoImagen = new JLabel(
			redimensionarIcono(plato.getImagen()));
	    }
	    if (plato.getTipo().equals("adicional")) {
		sumaAdicionales += plato.getPrecio();
		adicionales.setText(adicionales.getText() + plato.getNombre()
			+ "(" + plato.getPrecio() + "€) ");

	    }
	}
	adicionales.setText(adicionales.getText() + sumaAdicionales + " €");
	precioTotal = new JLabel("EL PRECIO TOTAL ES: " + precioTotal() + " €");
	aceptar = new JButton("ACEPTAR");
	descartar = new JButton("DESCARTAR");
    }

    private void aniadir() {
	// creamos las constantes para poder colocar los componentes
	GridBagConstraints gbc = new GridBagConstraints();
	// los alineamos a la izquierda
	gbc.anchor = GridBagConstraints.WEST;
	// margen entre componentes (abajo 20)
	gbc.insets = new Insets(0, 0, 20, 0);
	gbc.gridy = 0; // posicion y
	gbc.gridx = 0; // posicion x
	add(primero, gbc); // aniadimos componente
	gbc.gridy = 0;
	gbc.gridx = 1;
	add(primeroImagen, gbc);
	gbc.gridy = 1;
	gbc.gridx = 0;
	add(segundo, gbc);
	gbc.gridy = 1;
	gbc.gridx = 1;
	add(segundoImagen, gbc);
	gbc.gridy = 2;
	gbc.gridx = 0;
	add(adicionales, gbc);
	gbc.gridy = 3;
	gbc.gridx = 0;
	add(precioTotal, gbc);
	gbc.gridy = 4;
	gbc.gridx = 0;
	add(aceptar, gbc);
	gbc.gridy = 4;
	gbc.gridx = 1;
	add(descartar, gbc);
    }

    /**
     * Se encarga de establecer los oyentes
     *
     */
    private void oyentes() {
	aceptar.addActionListener(this);
	descartar.addActionListener(this);
    }

    /**
     * Se encarga de establecer las propiedades finales
     *
     */
    private void propiedadesFinales() {
	setVisible(true);
	setResizable(false);
    }

    /**
     * Se encarga de redimensionar un icono
     *
     * ESTARIA MEJOR EN OTRA CLASE
     *
     * @return el icono redimensionado
     */
    public ImageIcon redimensionarIcono(String icono) {
	// creamos el icono
	ImageIcon icon = new ImageIcon("img/" + icono);
	Image i = icon.getImage(); // creamos una imagen con el icono
	// redimensionamos la imagen
	Image otrai = i
		.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	// creamos el icono redimensionado
	ImageIcon icon2 = new ImageIcon(otrai);

	return icon2;
    }

    /**
     * Se encarga de calcular el precio total del pedido
     *
     * @return el precio total del pedido
     */
    private float precioTotal() {
	float suma = 0.0f;
	for (Iterator<Plato> it = p.iterator(); it.hasNext();) {
	    Plato plato = it.next();
	    suma += plato.getPrecio();
	}

	return suma;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == aceptar) { // si se pulsa aceptar
	    try {
		// creamos el gextor xml
		GestorXML gx = new GestorXML();
		// escribimos el pedido
		gx.escribirPedido(p);
	    } catch (JDOMException e1) {
		JOptionPane.showMessageDialog(this, "Problema XML", "Error",
			JOptionPane.ERROR_MESSAGE);
	    } catch (IOException e1) {
		JOptionPane.showMessageDialog(this, "Problema flujo de datos",
			"Error", JOptionPane.ERROR_MESSAGE);
	    }

	}

	dispose(); // sea cual sea el boton pulsado cerramos el dialogo
    }

}
