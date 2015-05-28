/**
 *
 */
package ejercicio3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXDatePicker;

/**
 * @author Iker Garcia Ramirez
 * @date 28/5/2015
 *
 */
public class VisorFotos extends JFrame {
    private DefaultListModel<Foto> dlm;
    private JComboBox<Fotografo> fotografos;
    private JLabel foto;
    private JList<Foto> lista;
    private JXDatePicker fecha;
    private GestorDeFotos gdf;

    /**
     * Constructor de la clase VisorFotos
     *
     * @param titulo
     * @throws HeadlessException
     */
    /**
     * Constructor de la clase VisorFotos
     *
     * @param titulo
     * @throws HeadlessException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public VisorFotos(String titulo) throws HeadlessException,
    ClassNotFoundException, SQLException {
	super(titulo);
	gdf = new GestorDeFotos();

	JPanel jp1 = configurarFotografos();
	JPanel jp2 = configurarFecha();
	JScrollPane js = configurarFotos();
	JPanel jp3 = configurarFoto();

	add(jp1);
	add(jp2);
	add(js);
	add(jp3);

	setLayout(new GridLayout(2, 2));
	setVisible(true);
	setSize(new Dimension(500, 500));
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();

    }

    /**
     * @return el panel de la foto
     */
    private JPanel configurarFoto() {
	JPanel jp3 = new JPanel();
	foto = new JLabel();
	jp3.add(foto);
	return jp3;
    }

    /**
     * @return el panel con scrolls de las fotos
     */
    private JScrollPane configurarFotos() {
	dlm = new DefaultListModel<Foto>();
	lista = new JList<Foto>(dlm);
	lista.addMouseListener(new MouseAdapter() {

	    /*
	     * (non-Javadoc)
	     *
	     * @see
	     * java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent
	     * )
	     */
	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
		    Foto f = lista.getSelectedValue();
		    foto.setIcon(redimensionar(new ImageIcon(f.getArchivo())));
		    try {
			gdf.incrementarVisualizaciones(f);
		    } catch (SQLException e1) {
			e1.printStackTrace();
		    }
		}
	    }

	});
	JScrollPane js = new JScrollPane(lista,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	return js;
    }

    /**
     * @return el panel de la fecha
     */
    private JPanel configurarFecha() {
	JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel etiqueta = new JLabel("Fotos posteriores a: ");
	fecha = new JXDatePicker();
	fecha.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		listarImagener();

	    }

	});
	jp2.add(etiqueta);
	jp2.add(fecha);
	return jp2;
    }

    /**
     * @return el panel de los fotografos
     * @throws SQLException
     */
    private JPanel configurarFotografos() throws SQLException {
	JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel etiqueta = new JLabel("Fotografo: ");
	fotografos = new JComboBox<Fotografo>(gdf.obtenerFotografos());
	fotografos.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		listarImagener();

	    }
	});
	jp1.add(etiqueta);
	jp1.add(fotografos);
	return jp1;
    }

    /**
     *
     */
    private void listarImagener() {
	dlm.removeAllElements();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String fechap;
	java.util.Date fechaPicker = fecha.getDate();
	try {
	    if (fechaPicker == null)
		fechap = "0000-00-00";
	    else {
		java.sql.Date fechaSql = new java.sql.Date(
			fechaPicker.getTime());
		fechap = fechaSql.toString();
	    }

	    Fotografo f = (Fotografo) fotografos.getSelectedItem();
	    ArrayList<Foto> fotos = gdf
		    .obtenerFotos(f.getIdfotografo(), fechap);
	    for (Foto foto : fotos) {
		dlm.addElement(foto);
	    }
	} catch (SQLException e1) {
	    e1.printStackTrace();
	}
    }

    private ImageIcon redimensionar(ImageIcon icono) {
	Image i = icono.getImage();
	Image otrai = i
		.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	ImageIcon icon2 = new ImageIcon(otrai);

	return icon2;
    }

    public static void main(String[] args) {
	try {
	    new VisorFotos("Fotografia");
	} catch (HeadlessException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
