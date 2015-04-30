/**
 *
 */
package ejercicio4;

import java.awt.GridLayout;

import javax.swing.JButton;

/**
 * @author Iker Garcia Ramirez
 * @date 29/4/2015
 *
 */
public class PanelAlfabeto extends PanelBasico {
    private static final JButton[] BOTONES = { new JButton("A"),
	new JButton("B"), new JButton("C"), new JButton("D"),
	new JButton("E"), new JButton("F"), new JButton("G"),
	new JButton("H"), new JButton("I"), new JButton("J"),
	new JButton("K"), new JButton("L"), new JButton("M"),
	new JButton("N"), new JButton("O"), new JButton("P"),
	new JButton("Q"), new JButton("R"), new JButton("S"),
	new JButton("T"), new JButton("U"), new JButton("V"),
	new JButton("W"), new JButton("X"), new JButton("Y"),
	new JButton("Z") };

    /*
     * (non-Javadoc)
     *
     * @see ejercicio4.PanelBasico#configurar()
     */
    @Override
    public void configurar() {
	setLayout(new GridLayout(2, 12));
    }

    /*
     * (non-Javadoc)
     *
     * @see ejercicio4.PanelBasico#aniadir()
     */
    @Override
    public void aniadir() {
	for (int i = 0; i < BOTONES.length; i++) {
	    add(BOTONES[i]);
	}
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
