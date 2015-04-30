/**
 *
 */
package ejercicio4;

import javax.swing.JButton;

/**
 * @author Iker Garcia Ramirez
 * @date 29/4/2015
 *
 */
public class PanelJugar extends PanelBasico {
    private JButton jugar;

    /*
     * (non-Javadoc)
     * 
     * @see ejercicio4.PanelBasico#instanciar()
     */
    @Override
    public void instanciar() {
	jugar = new JButton("JUGAR");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejercicio4.PanelBasico#aniadir()
     */
    @Override
    public void aniadir() {
	add(jugar);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejercicio4.PanelBasico#oyentes()
     */
    @Override
    public void oyentes() {
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

    /**
     * @return the jugar
     */
    public JButton getJugar() {
	return jugar;
    }

}
