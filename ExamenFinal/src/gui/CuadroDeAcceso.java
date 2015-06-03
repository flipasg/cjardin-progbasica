package gui;

import informacion.Socio;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import basesdedatos.GestorBD;

public class CuadroDeAcceso extends JDialog implements ActionListener {
	private JTextField dni;
	private JPasswordField contrasenia;
	private JButton matricula;
	private int intentos;
	private VentanaMatricula vm;
	public CuadroDeAcceso(VentanaMatricula vm, String titulo, boolean modal) {
		super(vm, titulo, modal);
		this.vm =vm;
		
		configurarDNI();
		configurarContrasenia();
		configurarMatricula();
		configurarDialogo();
		
	}

	private void configurarDialogo() {
		intentos = 0;
		setSize(new Dimension(270, 160));
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		pack();
	}

	private void configurarMatricula() {
		matricula = new JButton("MATRICULA");
		matricula.setBounds(5, 80, 240, 30);
		matricula.addActionListener(this);
		add(matricula);
	}

	private void configurarContrasenia() {
		JLabel contrasenialb = new JLabel("Password");
		contrasenialb.setBounds(5, 45, 120, 20);
		add(contrasenialb);
		contrasenia = new JPasswordField(20);
		contrasenia.setBounds(125, 45, 120, 20);
		add(contrasenia);
	}

	private void configurarDNI() {
		JLabel dnilb = new JLabel("DNI");
		dnilb.setBounds(5, 15, 120, 20);
		add(dnilb);
		dni = new JTextField(20);
		dni.setBounds(125, 15, 120, 20);
		add(dni);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(matricula == e.getSource()) {
			if(intentos<2) {
				GestorBD gbd = new GestorBD();
				Socio s = gbd.login(dni.getText(), contrasenia.getText());
				if(s==null) {
					intentos++;
					dni.setText("");
					contrasenia.setText("");
				}
				else {
					vm.setS(s);
					gbd.desconectar();
					dispose();
				}
				
				
			} else {
				intentos = 0;
				dispose();
			}
		}
		
	}
}
