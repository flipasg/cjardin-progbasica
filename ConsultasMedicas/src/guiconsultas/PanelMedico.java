package guiconsultas;
/**
 *
 */


import informacion.Medico;
import gestores.GestorDeConsultas;
import guibasica.PanelBasico;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * @author Ikk
 * @date 28/4/2015
 *
 */
public class PanelMedico extends PanelBasico {
    private JLabel etiqueta;
    private JComboBox<Medico> medicos;

    /*
     * (non-Javadoc)
     *
     * @see ejercicio3.PanelBasico#instanciar()
     */
    @Override
    public void instanciar() {
	// instanciamos la etiqueta
	etiqueta = new JLabel("Elija medico");
	// instanciamos el Combo partiendo de un array de medicos
	medicos = new JComboBox<Medico>(GestorDeConsultas.getMedicos());

    }

    /**
     * @return el combo de medicos
     */
    public JComboBox<Medico> getMedicos() {
	return medicos;
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
	add(medicos);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejercicio3.PanelBasico#propFinal
     */
    @Override
    public void propFinales() {
	setVisible(true);
    }

}
