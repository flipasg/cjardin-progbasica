/**
 *
 */
package ejercicio4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @author Iker Garcia Ramirez
 * @date 28/4/2015
 *
 */
public class GestorXML {
    private static final String FICHERO = "palabras.xml"; // nombre del fichero
    private static final XMLOutputter SALIDA = new XMLOutputter(
	    Format.getPrettyFormat()); // clase encargada de mostrar la
    // informacion xml
    private Document doc; // documento xml parseado por SAXBuilder
    // para llevar el control de si ya hay un GestorXML instanciado
    private static GestorXML instancia; // patron Singleton

    /**
     * Constructor de la clase GestorXML
     *
     * @throws IOException
     * @throws JDOMException
     */
    private GestorXML() throws JDOMException, IOException {
	parsear();
    }

    /**
     * Devuelve la instancia del GestorXML para instanciar un Gestor hay que
     * llamar a este metodo
     *
     * @return la instancia
     * @throws IOException
     * @throws JDOMException
     */
    public static GestorXML obtenerInstancia() throws JDOMException,
    IOException {
	if (instancia == null)
	    instancia = new GestorXML();

	return instancia;
    }

    /**
     * Parsea el documento XML
     *
     * @throws JDOMException
     * @throws IOException
     */
    public void parsear() throws JDOMException, IOException {
	SAXBuilder sb = new SAXBuilder();
	doc = sb.build(FICHERO);
    }

    /**
     * Se encarga de buscar la palabra de una longitud concreta
     *
     * @param n
     * @return la palabra de longitud n
     * @throws AhorcadoException
     */
    public String palabraDeLongitud(int n) throws AhorcadoException {

	// declaramos el ArrayList de palabras
	ArrayList<String> pals = new ArrayList<String>();

	// listamos los grupos de palabras del fichero
	List<Element> listaGrupos = doc.getRootElement().getChildren();
	for (Element e : listaGrupos) { // iteramos sobre los grupos
	    // si estamos en el grupo de palabras que se nos pasa como parametro
	    if (Integer.parseInt(e.getAttributeValue("numletras")) == n) {
		// listamos las palabras
		List<Element> listaPalabras = e.getChildren();
		for (Element e1 : listaPalabras) {
		    pals.add(e1.getText()); // aniadimos las palabras
		}
	    }

	}

	// para obtener un numero aleatorio usaremos la clase Random
	Random rnd = new Random();
	if (pals.size() == 0)
	    throw new AhorcadoException("No tenemos palabras de esa longitud");
	// asi obtenemos un numero aleatorio entre 0 y la longitud de la lista
	// menos uno
	int palabrasDistintas = pals.size();
	int numAleatorio = rnd.nextInt(palabrasDistintas);
	return pals.get(numAleatorio);

    }

    /**
     * Se encarga de aniadir el atributo acierto a la palabra acertada
     *
     * @param palabra
     * @param n
     * @throws IOException
     * @throws JDOMException
     */
    public void aniadirAcierto(String palabra, int n) throws IOException {
	// listamos los grupos de palabras del fichero
	List<Element> listaGrupos = doc.getRootElement().getChildren();
	for (Element e : listaGrupos) { // iteramos sobre los grupos
	    // si estamos en el grupo de palabras que se nos pasa como parametro
	    if (Integer.parseInt(e.getAttributeValue("numletras")) == n) {
		// listamos las palabras
		List<Element> listaPalabras = e.getChildren();
		// recorremos las palabras
		for (Element e1 : listaPalabras) {
		    // si la palabra es la se nos pasa como parametro
		    if (e1.getText().equals(palabra)) {
			// si tiene atributos
			if (e1.hasAttributes()) {
			    // establecemos el atributo al valor del atributo
			    // mas uno
			    e1.setAttribute(
				    "aciertos",
				    Integer.toString(Integer.parseInt(e1
					    .getAttributeValue("aciertos")) + 1));
			} else { // si no
				 // establecemos el atributo (nuevo) a uno
			    e1.setAttribute("aciertos", "1");
			}
		    }
		}
	    }

	}

	SALIDA.output(doc, new FileWriter(FICHERO));
    }
}
