/**
 *
 */
package ej2wamp;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author Iker Garcia Ramirez
 * @date 19/5/2015
 *
 */
public class VentanaSQL extends JFrame {
    private JRadioButton proyections, films;
    private JButton insert, update, delete;

    /**
     * Constructor de la clase VentanaSQL
     *
     * @param title
     * @throws HeadlessException
     */
    public VentanaSQL(String titulo) throws HeadlessException {
	super(titulo);
	createDatabasePanel();
	createActionPanel();
	configure();
    }

    private void createDatabasePanel() {
	JPanel jp = new JPanel(new FlowLayout(FlowLayout.LEFT));
	ButtonGroup bg = new ButtonGroup();
	proyections = new JRadioButton("Proyections");
	films = new JRadioButton("Films");

	bg.add(proyections);
	bg.add(films);
	jp.add(proyections);
	jp.add(films);
	add(jp);
    }

    private void createActionPanel() {
	JPanel jp = new JPanel();
	insert = new JButton("Insert");
	update = new JButton("Update");
	delete = new JButton("Delete");
	jp.add(insert);
	jp.add(update);
	jp.add(delete);
	add(jp);
    }

    private void configure() {
	setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	setSize(new Dimension(500, 500));
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	pack();
    }

    public static void main(String[] args) {
	new VentanaSQL("GESTION DE PELICULAS");
    }

}
