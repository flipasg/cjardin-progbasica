package guiahorcado;
/**
 *
 */


import guibasica.PanelBasico;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * @author Iker Garcia Ramirez
 * @date 29/4/2015
 *
 */
public class PanelRespuesta extends PanelBasico {
    private JLabel respuesta;

    /*
     * (non-Javadoc)
     *
     * @see ejercicio4.PanelBasico#instanciar()
     */
    @Override
    public void instanciar() {
	respuesta = new JLabel();
    }

    /**
     * @return the respuesta
     */
    public JLabel getRespuesta() {
	return respuesta;
    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio4.PanelBasico#configurar()
     */
    @Override
    public void configurar() {
	respuesta.setFont(new Font("Arial", Font.BOLD, 30));
    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio4.PanelBasico#aniadir()
     */
    @Override
    public void aniadir() {
	add(respuesta);
    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio4.PanelBasico#propFinales()
     */
    @Override
    public void propFinales() {
	setVisible(true);
    }

}
