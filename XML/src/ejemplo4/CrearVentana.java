/**
 *
 */
package ejemplo4;

import java.awt.HeadlessException;

import javax.swing.JFrame;

/**
 * @author Iker Garcia Ramirez
 * @date 23/4/2015
 *
 */
public class CrearVentana extends JFrame implements ICrearGUI {

    /**
     * Constructor de la clase CrearVentana
     * 
     * @param titulo
     * @throws HeadlessException
     */
    public CrearVentana(String titulo) throws HeadlessException {
	super(titulo);
	iniciar();
    }

    /**
     *
     */
    private void iniciar() {
	instanciar();
	configurar();
	aniadir();
	oyentes();
	propiedades();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejemplo4.ICrearGUI#instanciar()
     */
    @Override
    public void instanciar() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejemplo4.ICrearGUI#configurar()
     */
    @Override
    public void configurar() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejemplo4.ICrearGUI#oyentes()
     */
    @Override
    public void oyentes() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejemplo4.ICrearGUI#propiedades()
     */
    @Override
    public void propiedades() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see ejemplo4.ICrearGUI#aniadir()
     */
    @Override
    public void aniadir() {
    }

}
