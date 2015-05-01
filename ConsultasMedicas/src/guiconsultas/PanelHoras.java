package guiconsultas;
/**
 *
 */


import excepciones.HoraConsulta;
import excepciones.HoraException;
import gestores.GestorDeConsultas;
import guibasica.PanelBasico;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * @author Iker Garcia Ramirez
 * @date 28/4/2015
 *
 */
public class PanelHoras extends PanelBasico {
    private JLabel etiqueta; // etiqueta de la lista
    private JList<HoraConsulta> lista; // lista de HoraConsulta
    private JScrollPane panel; // panel con scroll

    /**
     * @return la lista
     */
    public JList<HoraConsulta> getLista() {
	return lista;
    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio3.PanelBasico#instanciar()
     */
    @Override
    public void instanciar() {
	try {
	    // instanciamos la lista partiendo de un array de las horas
	    // disponibles
	    lista = new JList<HoraConsulta>(GestorDeConsultas
		    .obtenerInstancia().getHorasDisponibles());
	} catch (HoraException e) {
	    e.printStackTrace();
	}

	// instanciamos el panel de scroll partiendo de la lista
	panel = new JScrollPane(lista,
		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	// instanciamos la etiqueta
	etiqueta = new JLabel("Elija una o mas horas");
    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio3.PanelBasico#configurar()
     */
    @Override
    public void configurar() {
	// colocaremos verticalmente los componentes
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio3.PanelBasico#aniadir()
     */
    @Override
    public void aniadir() {
	add(etiqueta);
	add(panel);
    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio3.PanelBasico#propFinales()
     */
    @Override
    public void propFinales() {
	setVisible(true);
    }
}
