/**
 * TemaGUI - ejemplo4 : ListaCheckBox.java
 * @author Iker Garcia Ramirez
 * @date 30/03/2015
 */
package ejemplo4;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//Comienza la clase ListaCheckBox
public class ListaCheckBox extends JPanel{
    private JPanel panel;
    private JScrollPane panelScroll;
    public ListaCheckBox() {
	
	setLayout(null);
	setVisible(true);
	JCheckBox b1 = new JCheckBox("Primer check");
	JCheckBox b2 = new JCheckBox("Segundo check");
	JCheckBox b3 = new JCheckBox("Tercer check");
	JCheckBox b4 = new JCheckBox("Cuarto check");
	JCheckBox b5 = new JCheckBox("Quinto check");
	panel = new JPanel();
	panel.setLayout(null);
	panel.setPreferredSize(new Dimension(200, 200));
	panel.setVisible(true);
	panel.add(b1);
	b1.setBounds(0, 10, 125, 20);
	panel.add(b2);
	b2.setBounds(0, 30, 125, 20);
	panel.add(b3);
	b3.setBounds(0, 50, 125, 20);
	panel.add(b4);
	b4.setBounds(0, 70, 125, 20);
	panel.add(b5);
	b5.setBounds(0, 90, 125, 20);
	panelScroll = new JScrollPane(panel, panelScroll.VERTICAL_SCROLLBAR_ALWAYS, panelScroll.HORIZONTAL_SCROLLBAR_NEVER);
	panelScroll.setBounds(0, 0, 125, 125);
	panelScroll.setVisible(true);
	add(panelScroll);
    }
}
