package ejemplo4;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdom2.JDOMException;

/**
 * @author Iker Garcia Ramirez
 * @date 22/4/2015
 *
 */
public class VuelosGUI extends CrearVentana implements ActionListener {
    private static final String FICHERO = "vuelos.xml";
    private JLabel origenEtiqueta, destinoEtiqueta;
    private JList<String> origenLista, destinoLista;
    private JButton comprar;
    private GestorVuelos gv;

    /**
     * Constructor de la clase VuelosGUI
     * 
     * @param titulo
     * @throws HeadlessException
     */
    public VuelosGUI(String titulo) throws HeadlessException {
	super(titulo);

    }

    /*
     * (non-Javadoc)
     *
     * @see ejemplo4.CrearVentana#instanciar()
     */
    @Override
    public void instanciar() {
	try {
	    gv = new GestorVuelos(FICHERO);
	    origenEtiqueta = new JLabel("ORIGEN");
	    destinoEtiqueta = new JLabel("DESTINO");
	    origenLista = new JList<String>(gv.obtenerOrigenesDistintos());
	    destinoLista = new JList<String>();
	    comprar = new JButton("COMPRAR");

	} catch (JDOMException e) {
	} catch (IOException e) {
	}

    }

    /*
     * (non-Javadoc)
     *
     * @see ejemplo4.CrearVentana#configurar()
     */
    @Override
    public void configurar() {
	setLayout(new GridBagLayout());
	setSize(new Dimension(500, 500));
    }

    /*
     * (non-Javadoc)
     *
     * @see ejemplo4.CrearVentana#aniadir()
     */
    @Override
    public void aniadir() {
	// propiedades del GridBagLayout
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.insets = new Insets(1, 1, 1, 1); // margen entre componentes

	gbc.gridy = 0;
	gbc.gridx = 0;
	add(origenEtiqueta, gbc);

	gbc.gridy = 0;
	gbc.gridx = 2;
	add(destinoEtiqueta, gbc);

	gbc.gridy = 1;
	gbc.gridx = 0;
	add(origenLista, gbc);

	gbc.gridy = 1;
	gbc.gridx = 2;
	add(destinoLista, gbc);

	gbc.gridy = 2;
	gbc.gridx = 1;
	add(comprar, gbc);
    }

    @Override
    public void oyentes() {
	destinoLista.addListSelectionListener(new ListSelectionListener() {

	    /*
	     * (non-Javadoc)
	     * 
	     * @see
	     * javax.swing.event.ListSelectionListener#valueChanged(javax.swing
	     * .event.ListSelectionEvent)
	     */
	    @Override
	    public void valueChanged(ListSelectionEvent e) {
		destinoLista.setListData(gv.obtenerDestinos(origenLista
			.getSelectedValue()));
		pack();
	    }
	});

    }

    /*
     * (non-Javadoc)
     *
     * @see ejemplo4.CrearVentana#propiedades()
     */
    @Override
    public void propiedades() {
	setResizable(false);
	setVisible(true);
	pack();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == comprar) {

	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	new VuelosGUI("Ikk Viajes");
    }

}
