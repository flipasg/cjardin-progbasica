/**
 * TemaGUI - ejemplo5 : PanelDibujo.java
 * @author Iker Garcia Ramirez
 * @date 31/03/2015
 */
package ejemplo5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;

//Comienza la clase PanelDibujo
public class PanelDibujo extends JPanel{
    
    public PanelDibujo() {
	setPreferredSize(new Dimension(200, 200));
	setBackground(Color.BLACK);
	setVisible(true);
    }
    
}
