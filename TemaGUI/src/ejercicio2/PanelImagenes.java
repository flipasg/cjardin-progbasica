package ejercicio2;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Comienza la clase PanelImagenes
public class PanelImagenes extends JPanel {
    private JComboBox<String> imagenes;
    private JLabel etiquetaImagen; 
    private static final String dir = "img/"; 

    /**
     * Constructor de la clase PanelImagenes
     */
    public PanelImagenes() {
	
	cargarCombo();
	imagenes.setSelectedIndex(0); //seleccionamos la primera imagen
	etiquetaImagen = new JLabel(); //creamos la etiqueta
	//establecemos la primera imagen como icono, redimensionada
	etiquetaImagen.setIcon(redimensionarIcono(dir+imagenes.getSelectedItem()));
	setPreferredSize(new Dimension(200,200)); //establecemos la dimension preferida
	setLayout(null); //el Layout a null
	
	//colocamos y a�adimos
	imagenes.setBounds(5, 5, 150, 20);
	add(imagenes);
	etiquetaImagen.setBounds(5, 30, 150, 150);
	add(etiquetaImagen);
	
	//establecemos oyentes
	imagenes.addActionListener(new EscuchadorCombo(this));
	
	//propiedades finales
	setVisible(true);
    }
    
    /**
     * M�todo : cargarCombo
     */
    private void cargarCombo() {
	File f = new File(dir); //usamos la clase file para obtener la lista de archivos
	String[] arrayImagenes = f.list(); //array de String con los nombres de las imagenes
	imagenes = new JComboBox<>(arrayImagenes); //creamos el combo
    }
    
    
    /**
     * ESTARIA MEJOR EN OTRA CLASE <-
     * M�todo : redimensionarIcono
     * @return
     */
    public ImageIcon redimensionarIcono(String icono) {
	ImageIcon icon = new ImageIcon(icono); //creamos un icono con la seleccion
	Image i = icon.getImage(); //creamos una imagen con el icono
	Image otrai = i.getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH); //redimensionamos la imagen
	ImageIcon icon2 = new ImageIcon(otrai); //creamos un icono redimensionado
	
	return icon2;
    }

    /**
     * M�todo obtener : getEtiquetaImagen
     * @return el etiquetaImagen de la clase
     */
    public JLabel getEtiquetaImagen() {
        return etiquetaImagen;
    }

    /**
     * M�todo obtener : getImagenes
     * @return el imagenes de la clase
     */
    public JComboBox<String> getImagenes() {
        return imagenes;
    }


    /**
     * M�todo obtener : getDir
     * @return el dir de la clase
     */
    public static String getDir() {
        return dir;
    }
    
    
    
}
