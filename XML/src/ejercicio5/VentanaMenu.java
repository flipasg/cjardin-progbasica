/**
 *
 */
package ejercicio5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import org.jdom2.JDOMException;

/**
 * @author Iker Garcia Ramirez
 * @date 1/5/2015
 *
 */
public class VentanaMenu extends JFrame implements ActionListener {
    private GestorXML gx;
    private JLabel etiquetaPrimeros, etiquetaSegundos, etiquetaAdicionales;
    private JLabel precioPrimero, precioSegundo, precioAdicionales;
    private JCheckBox[] adicionales;
    private ButtonGroup grupoPrimeros, grupoSegundos;
    private JRadioButton[] primeros, segundos;
    private JButton pedir;

    /**
     * Constructor de la clase VentanaMenu
     *
     * @param titulo
     * @throws HeadlessException
     * @throws IOException
     * @throws JDOMException
     */
    public VentanaMenu(String titulo) throws HeadlessException, JDOMException,
    IOException {
	super(titulo);
	instanciar();
	configurar();
	aniadir();
	propiedadesFinales();
    }

    private void instanciar() throws JDOMException, IOException {
	gx = new GestorXML();

	etiquetaPrimeros = new JLabel("SELECCIONA UN PRIMERO");
	etiquetaSegundos = new JLabel("SELECCIONA UN SEGUNDO");
	etiquetaAdicionales = new JLabel("SELECCIONA LOS ADICIONALES");

	precioPrimero = new JLabel();
	precioSegundo = new JLabel();
	precioAdicionales = new JLabel();

	grupoPrimeros = new ButtonGroup();
	grupoSegundos = new ButtonGroup();

	Plato[] primerosPlatos = gx.damePlato("primero");
	Plato[] segundosPlatos = gx.damePlato("principal");
	Plato[] platosAdicionales = gx.damePlato("adicional");

	primeros = new JRadioButton[primerosPlatos.length];
	segundos = new JRadioButton[segundosPlatos.length];
	adicionales = new JCheckBox[platosAdicionales.length];

	for (int i = 0; i < primeros.length; i++) {
	    primeros[i] = new JRadioButton(primerosPlatos[i].getNombre());
	    grupoPrimeros.add(primeros[i]);
	    primeros[i].addActionListener(new EscuchadorPrimerPlato(
		    primerosPlatos));
	    primeros[i].addActionListener(this);
	}

	for (int i = 0; i < segundos.length; i++) {
	    segundos[i] = new JRadioButton(segundosPlatos[i].getNombre());
	    grupoSegundos.add(segundos[i]);
	    segundos[i].addActionListener(new EscuchadorPlatoPrincipal(
		    segundosPlatos));
	    segundos[i].addActionListener(this);

	}

	for (int i = 0; i < platosAdicionales.length; i++) {
	    adicionales[i] = new JCheckBox(platosAdicionales[i].getNombre());
	    adicionales[i].addActionListener(new EscuchadorPlatoAdicional(
		    platosAdicionales));
	    adicionales[i].addActionListener(this);

	}

	pedir = new JButton("PEDIR");
	pedir.addActionListener(this);
    }

    private void configurar() {
	etiquetaPrimeros.setFont(new Font("Arial", Font.BOLD, 14));
	etiquetaPrimeros.setBorder(BorderFactory.createLineBorder(Color.BLACK,
		4));
	etiquetaSegundos.setFont(new Font("Arial", Font.BOLD, 14));
	etiquetaSegundos.setBorder(BorderFactory.createLineBorder(Color.BLACK,
		4));
	etiquetaAdicionales.setFont(new Font("Arial", Font.BOLD, 14));
	etiquetaAdicionales.setBorder(BorderFactory.createLineBorder(
		Color.BLACK, 4));
	setSize(new Dimension(800, 400));
	setLayout(new GridBagLayout());
    }

    private void aniadir() {
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor = GridBagConstraints.WEST;
	gbc.insets = new Insets(0, 0, 0, 50);

	gbc.gridy = 0;
	gbc.gridx = 0;
	add(etiquetaPrimeros, gbc);

	gbc.gridx = 0;
	for (int i = 0; i < primeros.length; i++) {
	    gbc.gridy = i + 1;
	    add(primeros[i], gbc);
	}

	gbc.insets = new Insets(0, 0, 0, 50);
	gbc.gridy = 0;
	gbc.gridx = 1;
	add(etiquetaSegundos, gbc);

	gbc.gridx = 1;
	for (int i = 0; i < segundos.length; i++) {
	    gbc.gridy = i + 1;
	    add(segundos[i], gbc);
	}

	if (primeros.length > segundos.length
		&& primeros.length > adicionales.length) {
	    gbc.gridy = primeros.length + 1;
	} else if (segundos.length > primeros.length
		&& segundos.length > adicionales.length) {
	    gbc.gridy = segundos.length + 1;
	} else {
	    gbc.gridy = adicionales.length + 1;
	}
	gbc.insets = new Insets(20, 0, 0, 0);
	gbc.gridx = 0;
	add(precioPrimero, gbc);
	gbc.gridx = 1;
	add(precioSegundo, gbc);
	gbc.gridx = 2;
	add(precioAdicionales, gbc);

	gbc.anchor = GridBagConstraints.CENTER;
	gbc.insets = new Insets(50, 0, 0, 0);
	gbc.gridx = 1;
	gbc.gridy++;
	add(pedir, gbc);

	gbc.anchor = GridBagConstraints.WEST;
	gbc.insets = new Insets(0, 0, 0, 0);
	gbc.gridy = 0;
	gbc.gridx = 2;
	add(etiquetaAdicionales, gbc);

	gbc.gridx = 2;
	for (int i = 0; i < adicionales.length; i++) {
	    gbc.gridy = i + 1;
	    add(adicionales[i], gbc);
	}

    }

    private void propiedadesFinales() {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(false);
    }

    private class EscuchadorPrimerPlato implements ActionListener {
	private Plato[] p;

	/**
	 * Constructor de la clase VentanaMenu.EscuchadorPrimerPlato
	 */
	public EscuchadorPrimerPlato(Plato[] p) {
	    this.p = p;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
	 * )
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	    JRadioButton r = (JRadioButton) e.getSource();
	    for (int i = 0; i < p.length; i++) {
		if (r.getText().equals(p[i].getNombre())) {
		    precioPrimero.setText("PRECIO: "
			    + Double.toString(p[i].getPrecio()) + " €");
		}
	    }
	}
    }

    private class EscuchadorPlatoPrincipal implements ActionListener {
	private Plato[] p;

	/**
	 * Constructor de la clase VentanaMenu.EscuchadorPrimerPlato
	 */
	public EscuchadorPlatoPrincipal(Plato[] p) {
	    this.p = p;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
	 * )
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	    JRadioButton r = (JRadioButton) e.getSource();
	    for (int i = 0; i < p.length; i++) {
		if (r.getText().equals(p[i].getNombre())) {
		    precioSegundo.setText("PRECIO: "
			    + Double.toString(p[i].getPrecio()) + " €");
		}
	    }
	}
    }

    private class EscuchadorPlatoAdicional implements ActionListener {
	private Plato[] p;

	/**
	 * Constructor de la clase VentanaMenu.EscuchadorPrimerPlato
	 */
	public EscuchadorPlatoAdicional(Plato[] p) {
	    this.p = p;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
	 * )
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	    String cadena = "";
	    for (int i = 0; i < adicionales.length; i++) {
		if (adicionales[i].isSelected()) {
		    for (int j = 0; j < p.length; j++) {
			if (adicionales[i].getText().equals(p[j].getNombre())) {
			    cadena += " " + Double.toString(p[i].getPrecio())
				    + " € +";

			}
		    }

		}

	    }
	    if (cadena.length() > 0) {
		cadena = cadena.substring(0, cadena.length() - 1);
		precioAdicionales.setText("PRECIO:" + cadena);
	    } else {
		precioAdicionales.setText(cadena);
	    }

	}
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	if (pedir == e.getSource()) {
	    boolean seleccionadoPrimero = false;
	    for (int i = 0; i < primeros.length && !seleccionadoPrimero; i++) {
		if (primeros[i].isSelected()) {
		    seleccionadoPrimero = true;
		}
	    }

	    boolean seleccionadoSegundo = false;
	    for (int i = 0; i < segundos.length && !seleccionadoSegundo; i++) {
		if (segundos[i].isSelected()) {
		    seleccionadoSegundo = true;
		}
	    }

	    if (seleccionadoPrimero && seleccionadoSegundo) {
		ArrayList<Plato> pedidoCompleto = new ArrayList<Plato>();

		Plato[] pri = gx.damePlato("primero");
		JRadioButton rBotonPrimero = null;
		for (int i = 0; i < primeros.length; i++) {
		    if (primeros[i].isSelected()) {
			rBotonPrimero = primeros[i];
		    }
		}

		for (int i = 0; i < pri.length; i++) {
		    if (rBotonPrimero.getText().equals(pri[i].getNombre())) {
			pedidoCompleto.add(pri[i]);
		    }
		}

		Plato[] seg = gx.damePlato("principal");
		JRadioButton rBotonSegundo = null;
		for (int i = 0; i < segundos.length; i++) {
		    if (segundos[i].isSelected()) {
			rBotonSegundo = segundos[i];
		    }
		}

		for (int i = 0; i < seg.length; i++) {
		    if (rBotonSegundo.getText().equals(seg[i].getNombre())) {
			pedidoCompleto.add(seg[i]);
		    }
		}

		Plato[] ad = gx.damePlato("adicional");
		JCheckBox checkAdicional = null;
		for (int i = 0; i < adicionales.length; i++) {
		    if (adicionales[i].isSelected()) {
			checkAdicional = adicionales[i];
			for (int j = 0; j < ad.length; j++) {
			    if (checkAdicional.getText().equals(
				    ad[j].getNombre())) {
				pedidoCompleto.add(ad[j]);
			    }
			}
		    }
		}

		new DialogoPedido(this, "PEDIDO", true, pedidoCompleto);

		grupoPrimeros.clearSelection();
		grupoSegundos.clearSelection();
		for (int i = 0; i < adicionales.length; i++) {
		    if (adicionales[i].isSelected()) {
			adicionales[i].setSelected(false);
		    }
		}
		precioPrimero.setText("");
		precioSegundo.setText("");
		precioAdicionales.setText("");
		pedidoCompleto.clear();
	    } else {
		JOptionPane
			.showMessageDialog(
				this,
				"HAY QUE SELECCIONAR UN PRIMERO Y UN SEGUNDO LOS ADICIONALES SON OPCIONALES",
				"ALERTA", JOptionPane.ERROR_MESSAGE);
	    }
	}
    }
}
