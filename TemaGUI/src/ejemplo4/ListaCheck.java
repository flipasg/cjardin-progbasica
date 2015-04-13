/**
 * TemaGUI - ejemplo4 : ListaCheck.java
 * @author Iker Garcia Ramirez
 * @date 30/03/2015
 */
package ejemplo4;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//Comienza la clase ListaCheck
public class ListaCheck extends JPanel{
    private JList<Integer> lista;
    private JScrollPane panel;
    
    public ListaCheck() {
	
	setLayout(null);
	setVisible(true);
	Integer numeros[] = new Integer[100];
	for (int i = 0; i < numeros.length; i++) {
	    numeros[i] = i+1;
	}
	
	lista = new JList<Integer>(numeros);
	panel = new JScrollPane(lista, panel.VERTICAL_SCROLLBAR_ALWAYS, panel.HORIZONTAL_SCROLLBAR_NEVER);
	add(panel);
	panel.setBounds(0, 0, 125, 125);
	
    }
}
