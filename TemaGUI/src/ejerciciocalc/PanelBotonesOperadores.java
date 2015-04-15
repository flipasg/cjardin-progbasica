package ejerciciocalc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import crearguis.PanelBasico;

public class PanelBotonesOperadores extends PanelBasico implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void instanciar() {}

    @Override
    public void configurar() {
	setLayout(new GridLayout(4, 2, 5, 5));
    }

    @Override
    public void aniadir() {
	String operadores = "+-/*%=rc";
	JButton b = null;
	for (int i = 0; i < operadores.length(); i++) {
	    b = new JButton(operadores.charAt(i)+"");
	    add(b);
	    b.setFocusable(false);
	    b.addActionListener(this);
	}

    }

    @Override
    public void oyentes() {}

    @Override
    public void propFinales(){
	setVisible(true);
    }

}
