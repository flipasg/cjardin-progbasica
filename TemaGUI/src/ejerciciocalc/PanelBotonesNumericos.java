package ejerciciocalc;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import crearguis.PanelBasico;

public class PanelBotonesNumericos extends PanelBasico implements ActionListener{
   
    private int numero;
    
    @Override
    public void instanciar() {
	
    }

    @Override
    public void configurar() {
	setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
	setLayout(new GridLayout(4, 3, 5, 5));
    }

    @Override
    public void aniadir() {
	JButton b = null;
	String numeros = "7894561230.";
	for (int i = 0; i < numeros.length(); i++) {
	    b = new JButton(numeros.charAt(i)+"");
	    add(b);
	    b.setFocusable(false);
	    b.addActionListener(this);
	}
    }

    @Override
    public void oyentes() {}

    @Override
    public void propFinales() {
	setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	JButton seleccionado = (JButton) e.getSource();
	numero = Integer.parseInt(seleccionado.getText());
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
