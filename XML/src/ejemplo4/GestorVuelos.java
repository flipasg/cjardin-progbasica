/**
 *
 */
package ejemplo4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Clase GestorVuelos
 *
 * @author Iker Garcia Ramirez
 * @date 22/4/2015 2015
 */
public class GestorVuelos {
    private static final XMLOutputter SALIDA = new XMLOutputter(
	    Format.getPrettyFormat());
    private String fichero;
    private Document doc;

    /**
     * Constructor de la clase GestorVuelos
     *
     * @param fichero
     * @throws JDOMException
     * @throws IOException
     */
    public GestorVuelos(String fichero) throws JDOMException, IOException {
	this.fichero = fichero;
	parsear();
    }

    /**
     * @return el documento
     */
    public Document getDoc() {
	return doc;
    }

    /**
     * @throws JDOMException
     * @throws IOException
     */
    public void parsear() throws JDOMException, IOException {
	SAXBuilder sb = new SAXBuilder();
	doc = sb.build(fichero);
    }

    /**
     * @return la cantidad de vuelos
     */
    public int cantidadVuelos() {
	return doc.getRootElement().getChildren().size();
    }

    public Vuelo[] devolverVuelos() {
	return null; // realizar metodo que devuelva un array de vuelos
    }

    /**
     * @throws IOException
     */
    public void borrarUltimoVuelo() throws IOException {
	Element raiz = doc.getRootElement();
	List<Element> hijos = raiz.getChildren();

	raiz.removeContent(hijos.get(hijos.size() - 1));
	SALIDA.output(doc, new FileWriter(fichero));
    }

    /**
     *
     * @return la lista de vuelos
     */
    public List<Element> obtenerVuelos() {
	Element root = doc.getRootElement();
	List<Element> vuelos = root.getChildren();
	return vuelos;
    }

    /**
     * @return el array de origenes distintos
     */
    public String[] obtenerOrigenesDistintos() {
	Set<String> origenesDistintos = new TreeSet<String>();
	List<Element> vuelos = obtenerVuelos();

	for (Element e : vuelos) {
	    origenesDistintos.add(e.getChildText("origen"));
	}
	String[] origenes = new String[origenesDistintos.size()];
	int i = 0;
	for (String origen : origenesDistintos) {
	    origenes[i] = origen;
	    i++;
	}

	return origenes;
    }

    /**
     * @param origen
     * @return
     */
    public String[] obtenerDestinos(String origen) {
	List<Element> vuelos = obtenerVuelos();
	ArrayList<String> destinosPorOrigen = new ArrayList<String>();
	for (Element e : vuelos) {
	    if (e.getChildText("origen").equals(origen)) {
		destinosPorOrigen.add(e.getChildText("destino"));
	    }
	}

	String[] destinos = new String[destinosPorOrigen.size()];
	int i = 0;
	for (String destino : destinosPorOrigen) {
	    destinos[i] = destino;
	    i++;
	}

	return destinos;
    }

    /**
     *
     */
    public void verVuelos() {
	Element root = doc.getRootElement();
	List<Element> vuelos = root.getChildren();
	for (Element e : vuelos) {
	    System.out.println("Vuelo numero " + e.getAttributeValue("id"));
	    System.out.println("\tORIGEN: " + e.getChildText("origen"));
	    System.out.println("\tDESTINO: " + e.getChildText("destino"));
	}
    }

    /**
     * @param posInicio
     * @param posFinal
     * @throws IOException
     */
    public void cambiarPosicion(int posInicio, int posFinal) throws IOException {
	posInicio--;
	posFinal--;

	Element root = doc.getRootElement();
	List<Element> vuelos = root.getChildren();
	Element c = vuelos.get(posInicio);
	Element c1 = vuelos.get(posFinal);

	c.detach();
	c1.detach();

	if (posFinal > (cantidadVuelos() - 1))
	    posFinal = cantidadVuelos() - 1;

	vuelos.set(posFinal, c);
	vuelos.set(posInicio, c1);

	SALIDA.output(doc, System.out);

    }

    /**
     * @throws IOException
     */
    public void generarOrigenesXML() throws IOException {
	Element root = doc.getRootElement();
	List<Element> vuelos = root.getChildren();
	for (Element e : vuelos) {
	    List<Element> informacion = e.getChildren();
	    e.setAttribute(informacion.get(0).getName(), informacion.get(0)
		    .getText());
	    e.removeContent(informacion.get(0));
	}

	for (Element e : vuelos) {

	}

	SALIDA.output(doc, new FileWriter("origenes" + fichero));
    }

}
