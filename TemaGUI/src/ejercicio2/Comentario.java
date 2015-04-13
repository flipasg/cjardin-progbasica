/**
 * TemaGUI - ejercicio2 : Comentario.java
 * @author ikk
 * @date 13/4/2015 2015
 */
package ejercicio2;

import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Comienza la clase Comentario
//El nombre deberia haber sido PanelComentario
public class Comentario extends JPanel {
    private JCheckBox snComentario;
    private JTextField comentario;
    
    public Comentario() {
	//instanciamos
	snComentario = new JCheckBox("Guardar comentario");
	snComentario.setSelected(true);
	comentario = new JTextField(100);
	
	//configuramos
	setLayout(null);
	setSize(new Dimension(20, 500));
	
	//colocamos y añadimos
	snComentario.setBounds(0, 0, 200, 20);
	add(snComentario);
	comentario.setBounds(210, 0, 230, 20);
	add(comentario);
	
	//propiedades finales
	setVisible(true);
    
    }

    /**
     * Método obtener : getSnComentario
     * @return el snComentario de la clase
     */
    public JCheckBox getSnComentario() {
        return snComentario;
    }

    /**
     * Método obtener : getComentario
     * @return el comentario de la clase
     */
    public JTextField getComentario() {
        return comentario;
    }
    
    
}
