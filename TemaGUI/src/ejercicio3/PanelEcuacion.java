/**
 * TemaGUI - ejercicio3 : PanelEcuacion.java
 * @author ikk
 * @date 13/4/2015 2015
 */
package ejercicio3;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Comienza la clase PanelEcuacion
public class PanelEcuacion extends JPanel {
    private JTextField a,b,c;
    private JLabel x2,x,r;
    
    /**
     * Constructor de la clase PanelEcuacion
     */
    public PanelEcuacion() {
	//instanciamos
	a = new JTextField(5);
	x2 = new JLabel(" x2 + ");
	b = new JTextField(5);
	x = new JLabel(" x + ");
	c= new JTextField(5);
	r = new JLabel(" =0 ");
	
	//añadimos
	add(a);
	add(x2);
	add(b);
	add(x);
	add(c);
	add(r);
	
	//propiedades finales
	setVisible(true);
    }

    /**
     * Método obtener : getA
     * @return el a de la clase
     */
    public JTextField getA() {
        return a;
    }

    /**
     * Método obtener : getB
     * @return el b de la clase
     */
    public JTextField getB() {
        return b;
    }

    /**
     * Método obtener : getC
     * @return el c de la clase
     */
    public JTextField getC() {
        return c;
    }
    
    /**
     * Método : reiniciarEcuacion
     */
    public void reiniciarEcuacion() {
	a.setText(null);
	b.setText(null);
	c.setText(null);
    }
}
