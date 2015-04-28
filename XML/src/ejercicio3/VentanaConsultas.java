/**
 *
 */
package ejercicio3;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.jdom2.JDOMException;

/**
 * @author Iker Garcia Ramirez
 * @date 28/4/2015
 *
 */
public class VentanaConsultas extends VentanaBasica implements ActionListener {
    private PanelHoras ph;
    private PanelMedico pm;
    private PanelPaciente pp;
    private JButton boton;

    /**
     * Constructor de la clase VentanaConsultas
     *
     * @param titulo
     * @throws HeadlessException
     */
    public VentanaConsultas(String titulo) throws HeadlessException {
	super(titulo);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejercicio3.VentanaBasica#instanciar()
     */
    @Override
    public void instanciar() {
	ph = new PanelHoras();
	pm = new PanelMedico();
	pp = new PanelPaciente();
	boton = new JButton("ANIADIR");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejercicio3.VentanaBasica#configurar()
     */
    @Override
    public void configurar() {
	setLayout(null);
	setSize(new Dimension(500, 300));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejercicio3.VentanaBasica#aniadir()
     */
    @Override
    public void aniadir() {
	ph.setBounds(10, 10, 140, 180);
	add(ph);
	pm.setBounds(260, 30, 150, 40);
	add(pm);
	pp.setBounds(260, 150, 150, 40);
	add(pp);
	boton.setBounds(155, 210, 100, 40);
	add(boton);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejercicio3.VentanaBasica#oyentes()
     */
    @Override
    public void oyentes() {
	boton.addActionListener(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejercicio3.VentanaBasica#propFinales()
     */
    @Override
    public void propFinales() {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	if (boton == e.getSource()) {
	    try {
		// obtenemos las instancias de los gestores
		GestorDeConsultas gdc = GestorDeConsultas.obtenerInstancia();
		GestorXML gx = GestorXML.obtenerInstancia();

		// obtenemos la lista de las horas seleccionadas
		List<HoraConsulta> horasSeleccionadas = ph.getLista()
			.getSelectedValuesList();

		// si no hay horas seleccionadas, lanzamos un mensaje de error
		// no necesitamos hacer mas, porque el foreach no agregara
		// informacion de ser asi
		if (horasSeleccionadas.size() == 0) {
		    JOptionPane.showMessageDialog(this,
			    "Debe seleccionar una o mas horas", "Error",
			    JOptionPane.ERROR_MESSAGE);
		}
		// obtenemos el medico y el paciente
		Medico m = (Medico) pm.getMedicos().getSelectedItem();
		Paciente p = new Paciente(pp.getPaciente().getText());

		// si no se ha escrito el paciente
		// lanzamos un mensaje de error
		if (pp.getPaciente().getText().equals("")) {
		    JOptionPane.showMessageDialog(this,
			    "Debe introducir el nombre del paciente", "Error",
			    JOptionPane.ERROR_MESSAGE);
		} else { // si se ha escrito el paciente
		    // recorremos las horas
		    for (HoraConsulta h : horasSeleccionadas) {
			// si el medico no tiene una consulta a esa hora
			if (!gdc.hayConsulta(m, h)) {
			    // aniadimos la consulta y mostramos un mensaje de
			    // informacion
			    gdc.aniadirConsulta(m, p, h);
			    JOptionPane.showMessageDialog(this,
				    "CONSULTA ASIGNADA: " + p + " - " + m
				    + ", " + h, "Error",
				    JOptionPane.ERROR_MESSAGE);
			} else { // si ya tiene
			    // mostramos un mensaje de error
			    JOptionPane.showMessageDialog(this, "El/la " + m
				    + " ya tiene una consulta a las " + h,
				    "Error", JOptionPane.ERROR_MESSAGE);
			}

		    }

		    // aniadimos la informacion al XML
		    gx.aniadir(m);
		}

	    } catch (ConsultaException | IOException | JDOMException
		    | HoraException e1) {
		JOptionPane.showMessageDialog(this, e1.getMessage(), "Error",
			JOptionPane.ERROR_MESSAGE);
	    }

	}
    }

}
