package guibasica;


import java.awt.HeadlessException;

import javax.swing.JFrame;

/**
 * @author Iker Garcia Ramirez
 * @date 28/4/2015
 *
 */
public class VentanaBasica extends JFrame implements IGuiBasica {

    /**
     * Constructor de la clase VentanaBasica
     * 
     * @param title
     * @throws HeadlessException
     */
    public VentanaBasica(String title) throws HeadlessException {
	super(title);
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
