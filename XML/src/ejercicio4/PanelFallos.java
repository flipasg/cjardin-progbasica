/**
 *
 */
package ejercicio4;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Iker Garcia Ramirez
 * @date 29/4/2015
 *
 */
public class PanelFallos extends PanelBasico {
    private static final ImageIcon ICONO = new ImageIcon("img/Icono_error.png");
    private JLabel[] fallos;

    public PanelFallos(int numeroErrores) {
	fallos = new JLabel[numeroErrores];
	for (int i = 0; i < numeroErrores; i++) {
	    fallos[i] = new JLabel(ICONO);
	    add(fallos[i]);
	}

    }

    /**
     * @return the fallos
     */
    public JLabel[] getFallos() {
	return fallos;
    }
}
