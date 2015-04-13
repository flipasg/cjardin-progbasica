/**
 * TemaGUI - ejercicio3 : PanelResolver.java
 * @author ikk
 * @date 13/4/2015 2015
 */
package ejercicio3;

import javax.swing.JButton;
import javax.swing.JPanel;

//Comienza la clase PanelResolver
public class PanelResolver extends JPanel{
    private JButton resolver;
    
    /**
     * Constructor de la clase PanelResolver
     */
    public PanelResolver() {
	//instanciamos
	resolver = new JButton("RESOLVER");
	
	//añadimos
	add(resolver);
	
	//propiedades finales
	setVisible(true);
    }

    /**
     * Método obtener : getResolver
     * @return el resolver de la clase
     */
    public JButton getResolver() {
        return resolver;
    }
}
