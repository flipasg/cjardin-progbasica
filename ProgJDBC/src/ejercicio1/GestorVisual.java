/**
 *
 */
package ejercicio1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Iker Garcia Ramirez
 * @date 27/5/2015
 *
 */
public class GestorVisual extends JFrame implements ActionListener {

    private JTextField dni, nombre, poblacion, telefono, fechaNacimiento;
    private JComboBox<Ciclo> ciclos;
    private JButton buscar, insertar, modificar, eliminar;
    private JLabel errores;
    private GestorAlumnos ga;

    /**
     * Constructor de la clase GestorVisual
     *
     * @param titulo
     * @throws HeadlessException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public GestorVisual(String titulo) throws HeadlessException,
    ClassNotFoundException, SQLException {
	super(titulo);
	ga = new GestorAlumnos();
	JPanel jp1 = new JPanel();
	JLabel tituloVentana = new JLabel("GESTION DE ALUMNOS");
	tituloVentana.setFont(new Font("Arial", Font.BOLD, 18));
	jp1.add(tituloVentana);
	add("North", jp1);

	JPanel jp2 = new JPanel();
	jp2.setLayout(new GridLayout(5, 1));
	jp2.add(new JLabel("DNI: "));
	jp2.add(new JLabel("Nombre: "));
	jp2.add(new JLabel("Poblacion: "));
	jp2.add(new JLabel("Telefono: "));
	jp2.add(new JLabel("Fecha de nacimiento: "));
	jp2.setBorder(BorderFactory.createEmptyBorder(5, 10, 15, 10));
	add("West", jp2);

	JPanel jp3 = new JPanel();
	jp3.setLayout(new GridLayout(5, 1));
	dni = new JTextField(20);
	nombre = new JTextField(20);
	poblacion = new JTextField(20);
	telefono = new JTextField(20);
	fechaNacimiento = new JTextField(20);
	jp3.add(dni);
	jp3.add(nombre);
	jp3.add(poblacion);
	jp3.add(telefono);
	jp3.add(fechaNacimiento);
	jp3.setBorder(BorderFactory.createEmptyBorder(5, 10, 15, 10));
	add("East", jp3);

	ciclos = new JComboBox<Ciclo>(ga.todosCiclos());
	JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	jp4.add(new JLabel("Ciclo:"));
	jp4.add(ciclos);
	add("South", jp4);
	JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	buscar = new JButton("Buscar");
	buscar.addActionListener(this);
	insertar = new JButton("Insertar");
	insertar.addActionListener(this);
	modificar = new JButton("Modificar");
	modificar.addActionListener(this);
	eliminar = new JButton("Eliminar");
	eliminar.addActionListener(this);
	jp5.add(buscar);
	jp5.add(insertar);
	jp5.add(modificar);
	jp5.add(eliminar);

	errores = new JLabel();
	JPanel jp7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	jp7.setPreferredSize(new Dimension(getWidth(), 40));
	jp7.add(errores);
	JPanel jp6 = new JPanel();
	jp6.setLayout(new BoxLayout(jp6, BoxLayout.Y_AXIS));
	jp6.add(jp4);
	jp6.add(jp5);
	jp6.add(jp7);
	add("South", jp6);

	setResizable(false);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(500, 500);
	pack();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	try {
	    new GestorVisual("Gestion de Estudios");
	} catch (HeadlessException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	errores.setText("");
	if (buscar == e.getSource() || modificar == e.getSource()) {
	    if (dni.getText().equals("")) {
		JOptionPane.showMessageDialog(getContentPane(),
			"Debe especificar un dni", "Error",
			JOptionPane.ERROR_MESSAGE);
	    } else {
		Alumno a = ga.buscaAlumno(dni.getText());
		establecerCampos(a);
		if (a != null && modificar == e.getSource())
		    errores.setText(ga.modificarAlumno(dni.getText(), a));
	    }

	}
	if (insertar == e.getSource()) {

	    try {
		String dnia = dni.getText();
		String nombrea = nombre.getText();
		String poblaciona = poblacion.getText();
		String telefonoa = telefono.getText();
		if (dnia.equals("") || nombrea.equals("")
			|| poblaciona.equals("") || telefonoa.equals("")
			|| fechaNacimiento.getText().equals("")) {
		    JOptionPane.showMessageDialog(getContentPane(),
			    "Debe rellenar todos los campos", "Error",
			    JOptionPane.ERROR_MESSAGE);
		} else {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date fechanaca = sdf.parse(fechaNacimiento
			    .getText());
		    Ciclo c = (Ciclo) ciclos.getSelectedItem();
		    int codcicloa = c.getCodCiclo();
		    Alumno a = new Alumno(dnia, nombrea, poblaciona, telefonoa,
			    fechanaca, codcicloa);
		    if (a != null) {
			errores.setText(ga.insertarAlumno(a));
		    }
		}

	    } catch (ParseException e1) {
		JOptionPane.showMessageDialog(getContentPane(),
			"Problema con el parseado de fecha", "Error",
			JOptionPane.ERROR_MESSAGE);
	    }

	}
	if (eliminar == e.getSource()) {
	    if (dni.getText().equals("")) {
		JOptionPane.showMessageDialog(getContentPane(),
			"Debe especificar un dni", "Error",
			JOptionPane.ERROR_MESSAGE);
	    } else {
		errores.setText(ga.eliminarAlumno(dni.getText()));
	    }
	}
    }

    /**
     *
     */
    private void establecerCampos(Alumno a) {
	if (a == null) {
	    errores.setText("No existe el alumno con DNI: " + dni.getText());
	} else {
	    nombre.setText(a.getNombre());
	    poblacion.setText(a.getPoblacion());
	    telefono.setText(a.getTelefono());
	    fechaNacimiento.setText(a.getFechaNacimiento().toString());
	    ciclos.setSelectedItem(new Ciclo(a.getCodCiclo(), "", 0));
	}
    }
}
