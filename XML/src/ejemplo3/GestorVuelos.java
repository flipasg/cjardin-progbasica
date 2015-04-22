/**
 * XML - ejemplo3 : GestorVuelos.java
 * @author Ikk
 * @date 21/4/2015 2015
 */
package ejemplo3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

import org.apache.bcel.verifier.exc.VerifierConstraintViolatedException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Clase  GestorVuelos
 * @author Ikk
 * @date 22/4/2015 2015
 */
public class GestorVuelos {
    private static final XMLOutputter SALIDA = new XMLOutputter(
	    Format.getPrettyFormat());
    private String fichero;
    private Document doc;

    /**
     * Constructor de la clase GestorVuelos
     * @param fichero
     * @throws JDOMException
     * @throws IOException
     */
    public GestorVuelos(String fichero) throws JDOMException, IOException {
	this.fichero = fichero;
	parsear();
    }

    /**
     * Metodo : getDoc
     * @return
     */
    public Document getDoc() {
        return doc;
    }

    /**
     * Metodo : parsear
     * @throws JDOMException
     * @throws IOException
     */
    public void parsear() throws JDOMException, IOException {
	SAXBuilder sb = new SAXBuilder();
	doc = sb.build(fichero);
    }

    /**
     * Metodo : cantidadVuelos
     * @return
     */
    public int cantidadVuelos() {
	return doc.getRootElement().getChildren().size();
    }

    /**
     * Metodo : borrarUltimoVuelo
     * @throws IOException
     */
    public void borrarUltimoVuelo() throws IOException {
	Element raiz = doc.getRootElement();
	List<Element> hijos = raiz.getChildren();

	raiz.removeContent(hijos.get(hijos.size() - 1));
	SALIDA.output(doc, new FileWriter(fichero));
    }
    
    public List obtenerVuelos() {
	Element root = doc.getRootElement();
	List<Element> vuelos = root.getChildren();
	return vuelos;
    }
    
    public Vector<String> obtenerOrigenes() {
	Vector<String> origenes =  new Vector<>();
	List<Element> vuelos = obtenerVuelos();
	for (Element e : vuelos) {
	    origenes.add(e.getChildText("origen"));
	}
	
	return origenes;
    }
    
    
    /**
     * Metodo : verVuelos
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
     * Metodo : cambiarPosicion
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
     * Metodo : generarOrigenesXML
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
