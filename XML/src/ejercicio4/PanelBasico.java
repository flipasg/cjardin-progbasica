package ejercicio4;

import javax.swing.JPanel;

/**
 * @author Iker Garcia Ramirez
 * @date 28/4/2015
 *
 */
public class PanelBasico extends JPanel implements IGuiBasica {

    /**
     * Constructor de la clase PanelBasico
     */
    public PanelBasico() {
	iniciar();
    }

    /**
     *
     */
    public void iniciar() {
	instanciar();
	configurar();
	aniadir();
	oyentes();
	propFinales();
    }

    @Override
    public void instanciar() {
    }

    @Override
    public void configurar() {
    }

    @Override
    public void aniadir() {
    }

    @Override
    public void oyentes() {
    }

    @Override
    public void propFinales() {
    }

}
