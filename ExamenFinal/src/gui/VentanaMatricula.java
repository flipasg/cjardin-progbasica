package gui;

import informacion.Actividad;
import informacion.ResultadoMatricula;
import informacion.Socio;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import basesdedatos.GestorBD;

public class VentanaMatricula extends JFrame {
	private Socio s;
	private JComboBox<Actividad> combo;
	private JTextArea area;
	private float total;
	private int actividadesTotales;
	private JLabel precioTotal;
	private GestorBD gbd;
	
	private class EscuchadorCombo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Actividad a = (Actividad) combo.getSelectedItem();
			ResultadoMatricula rm = gbd.matricular(s, a);
			if(!rm.isExito()) {
				JOptionPane.showMessageDialog(getContentPane(), rm, "NO MATRICULADO", JOptionPane.ERROR_MESSAGE);
			} else {
				area.setText(area.getText()+"\n"+a.getNombre());
				total += a.getCosteMensual();
				actividadesTotales++;
				precioTotal.setText(total+" €");
				JOptionPane.showMessageDialog(getContentPane(), rm, "MATRICULADO", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
	}
	public VentanaMatricula(String titulo) throws HeadlessException {
		super(titulo);
		total = 0.0f;
		actividadesTotales = 0;
		s = null;
		gbd = new GestorBD();
		new CuadroDeAcceso(this,"Acceso",true);
		if(s==null) dispose();
		
		JPanel panelUsuario = configurarPanelUsuario();
		JPanel panelCombo = configurarPanelCombo();
		JPanel panelTexto = configurarPanelTexto();
		JPanel panelPrecio = configurarPanelPrecio();
		
		add(panelUsuario);
		add(panelCombo);
		add(panelTexto);
		add(panelPrecio);
		
		configurarVentana();
	}

	private void configurarVentana() {
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				if(actividadesTotales>2) total *= 0.80f;
				
				gbd.establecerCuota(s, total);
				JOptionPane.showMessageDialog(getContentPane(), "EL PRECIO TOTAL HA SIDO " + total + " €", "CUOTA", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setVisible(true);
		setResizable(false);
		pack();
	}

	private JPanel configurarPanelPrecio() {
		JPanel panelPrecio = new JPanel(new FlowLayout(FlowLayout.CENTER));
		precioTotal = new JLabel(total + " €");
		panelPrecio.add(precioTotal);
		return panelPrecio;
	}

	private JPanel configurarPanelTexto() {
		JPanel panelTexto = new JPanel(new FlowLayout(FlowLayout.CENTER));
		area = new JTextArea("NUEVAS ACTIVIDADES");
		area.setColumns(33);
		area.setRows(10);
		JScrollPane jsp = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelTexto.add(jsp);
		return panelTexto;
	}

	private JPanel configurarPanelCombo() {
		JPanel panelCombo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel ea = new JLabel("Escoge actividad");
		combo = new JComboBox<Actividad>(gbd.actividades());
		combo.addActionListener(new EscuchadorCombo());
		panelCombo.add(ea);
		panelCombo.add(combo);
		return panelCombo;
	}

	private JPanel configurarPanelUsuario() {
		JPanel panelUsuario = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelUsuario.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 60));
		JLabel usuario = new JLabel(s.toString());
		panelUsuario.add(usuario);
		return panelUsuario;
	}

	public void setS(Socio s) {
		this.s = s;
	}
	
	public static void main(String[] args) {
		new VentanaMatricula("MATRICULA");
	}

}
