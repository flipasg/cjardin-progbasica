package guiconsultas;
/**
 *
 */


import guibasica.PanelBasico;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Ikk
 * @date 28/4/2015
 *
 */
public class PanelPaciente extends PanelBasico {
    private JLabel etiqueta;
    private JTextField paciente;

    /*
     * (non-Javadoc)
     *
     * @see ejercicio3.PanelBasico#instanciar()
     */
    @Override
    public void instanciar() {
	// instanciamos la etiqueta
	etiqueta = new JLabel("Nombre del paciente");
	// instanciamos el campo de texto con un ancho de 150
	paciente = new JTextField(150);
    }

    /**
     * @return el campo de texto del paciente
     */
    public JTextField getPaciente() {
	return paciente;
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
	add(paciente);
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
