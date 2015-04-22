/**
 * XML - ejemplo4 : CrearVentana.java
 * @author Ikk
 * @date 22/4/2015
 */
package ejemplo4;

import java.awt.HeadlessException;

import javax.swing.JFrame;

//Comienza la clase CrearVentana
public class CrearVentana extends JFrame implements ICrearGUI{
    
    
    
    
    /**
     * Constructor de la clase CrearVentana
     * @param titulo
     * @throws HeadlessException
     */
    public CrearVentana(String titulo) throws HeadlessException {
	super(titulo);
	iniciar();
    }
    
    private void iniciar() {
	instanciar();
	configurar();
	aniadir();
	oyentes();
	propiedades();
    }

    /**
     * Metodo sobreescrito : instanciar
     * @see ejemplo4.ICrearGUI#instanciar()
     */
    @Override
    public void instanciar() {}

    /**
     * Metodo sobreescrito : configurar
     * @see ejemplo4.ICrearGUI#configurar()
     */
    @Override
    public void configurar() {}

    /**
     * Metodo sobreescrito : oyentes
     * @see ejemplo4.ICrearGUI#oyentes()
     */
    @Override
    public void oyentes() {}

    /**
     * Metodo sobreescrito : propiedades
     * @see ejemplo4.ICrearGUI#propiedades()
     */
    @Override
    public void propiedades() {}

    /**
     * Metodo sobreescrito : aniadir
     * @see ejemplo4.ICrearGUI#aniadir()
     */
    @Override
    public void aniadir() {}

}
