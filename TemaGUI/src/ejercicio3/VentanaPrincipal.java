package ejercicio3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private PanelEcuacion ecuacion;
    private PanelSoluciones soluciones;
    private PanelResolver resolver;
    
    /**
     * Constructor de la clase VentanaPrincipal
     */
    public VentanaPrincipal() {
	super("Ecuacion de segundo grado");
	
	//instanciamos
	resolver = new PanelResolver();
	soluciones = new PanelSoluciones();
	ecuacion = new PanelEcuacion();
	
	//configuramos
	setLayout(new BorderLayout());
	setSize(new Dimension(300, 120));
	
	//añadimos
	add("North", ecuacion);
	add("Center", resolver);
	add("South", soluciones);
	
	//configuramos oyentes
	resolver.getResolver().addActionListener(this);
	
	//propiedades finales
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	setVisible(true);
    }
    
    /* Método sobreescrito : actionPerformed
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	JButton presionado = (JButton) e.getSource();
	if(presionado==resolver.getResolver()) {
	    String a = ecuacion.getA().getText();
	    String b = ecuacion.getB().getText();
	    String c = ecuacion.getC().getText();
	    try {
		if(!a.matches("\\d+") || !b.matches("\\d+") || !c.matches("\\d+")) {
		    ecuacion.reiniciarEcuacion();
		    throw new RaizException("Debes rellenar con 3 int");
		} else {
		    int numA = Integer.parseInt(a);
		    int numB = Integer.parseInt(b);
		    int numC = Integer.parseInt(c);
		    
		    float raiz = (float) Math.pow(numB, 2)-(4*numA*numC);
		    if(raiz<0) {
			ecuacion.reiniciarEcuacion();
			throw new RaizException("Raiz negativa");
		    } else {
			float solucion1 = (float) ((-numB + Math.sqrt(raiz))/(2*numA));
			float solucion2 = (float) ((-numB - Math.sqrt(raiz))/(2*numA));
			soluciones.getS1().setText("Solucion 1: " + solucion1);
			soluciones.getS2().setText("Solucion 2: " + solucion2);
		    }
			
		}
	    } catch (RaizException e1) {
		JOptionPane.showMessageDialog(this, e1.getMessage());
	    }

	}
    } 
    
    /**
     * Método : main
     * @param args
     */
    public static void main(String[] args) {
	VentanaPrincipal v = new VentanaPrincipal();
    }



}
