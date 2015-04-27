/**
 *
 */
package ejercicio2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Clase que lleva la gestion de comidas desde un documento XML
 *
 * @author Iker Garcia Ramirez
 * @date 27/4/2015
 *
 */
public class GestionMenu {
    // clase encargada de la salida del documento en buffer
    // he decidido aniadirlo como atributo de clase por su uso
    private static final XMLOutputter SALIDA = new XMLOutputter(
	    Format.getPrettyFormat());
    private String fichero; // nombre del fichero
    private Document doc; // documento para tratar el fichero en buffer

    /**
     * Constructor de la clase GestionMenu
     *
     * @param fichero
     * @throws IOException
     * @throws JDOMException
     */
    public GestionMenu(String fichero) throws JDOMException, IOException {
	this.fichero = fichero;
	parsear();
    }

    /**
     * Parsea el fichero XML a un Document para poder manejarlo
     *
     * @throws JDOMException
     * @throws IOException
     */
    public void parsear() throws JDOMException, IOException {
	SAXBuilder sb = new SAXBuilder();
	doc = sb.build(fichero);
    }

    /**
     * Muestra el fichero XML por consola
     *
     * @throws IOException
     */
    public void ver() throws IOException {
	SALIDA.output(doc, System.out);
    }

    /**
     * Busca la comida con el nombre pasado como parametro
     *
     * @param nombre
     * @return la comida con ese nombre o null de no existir
     */
    public Element consultaPlato(String nombre) {
	Element raiz = doc.getRootElement();
	List<Element> listaComidas = raiz.getChildren();
	for (Element e : listaComidas) {
	    // buscamos el elemento con el nombre
	    if (e.getChildText("nombre").equals(nombre))
		return e; // si hay una comida con ese nombre la devolvemos
	}
	return null;
    }

    /**
     * Lista las comidas con menos calorias que las pasadas por parametro
     *
     * @param calorias
     * @return lista de comidas con menos calorias
     */
    public List<Element> consultaPorCalorias(int calorias) {
	// lista que contendra las comidas de menos calorias
	ArrayList<Element> listaComidasPorCalorias = new ArrayList<Element>();
	Element raiz = doc.getRootElement();
	List<Element> listaComidas = raiz.getChildren(); // lista de comidas
	for (Element e : listaComidas) {
	    int caloriasPlato = Integer.parseInt(e.getChildText("calorias"));
	    if (caloriasPlato < calorias) // si las calorias del plato son
		// menores
		listaComidasPorCalorias.add(e); // aniadimos la comida a la
	    // lista
	}

	return listaComidasPorCalorias; // devolvemos la lista
    }

    /**
     * Crea un fichero XML a partir de los platos mas economicos
     *
     * @param ficheroEconomico
     * @param precioMinimo
     * @param precioMaximo
     * @throws IOException
     */
    public void platosEconomicos(String ficheroEconomico, float precioMinimo,
	    float precioMaximo) throws IOException {
	// he decidido poner el nombre del fichero como parametro porque es
	// mejor para el manejo del buffer de entrada
	Element raiz = doc.getRootElement();
	List<Element> comidas = raiz.getChildren();

	for (Element e : comidas) {
	    String precioCadena = e.getChildText("precio");
	    float precio = Float.parseFloat(precioCadena);
	    // si el precio esta entre los pasados como parametro
	    if (precio >= precioMinimo && precio <= precioMaximo) {
		e.setAttribute("precio", precioCadena); // le aniadimos el
		// atributo precio
		e.removeChild("precio"); // eliminamos el elemento hijo precio
		e.removeChild("calorias"); // eliminamos el elemento hijo
		// calorias
	    } else {
		e.detach(); // lo "despegamos" del padre (la raiz)
	    }
	}

	// escribimos el documento que tenemos en buffer en el fichero
	SALIDA.output(doc, new FileWriter(ficheroEconomico));

    }

    /**
     * Aniade la comida al documento XML
     *
     * @param c
     * @throws IOException
     */
    public void nuevaComida(Comida c) throws IOException {
	Element raiz = doc.getRootElement();

	Element comida = new Element("comida");

	// creamos los elementos necesarios a partir de la informacion de la
	// comida
	Element nombreComida = new Element("nombre");
	nombreComida.setText(c.getNombre());
	Element precioComida = new Element("precio");
	precioComida.setText(Float.toString(c.getPrecio()));
	Element descripcionComida = new Element("descripcion");
	descripcionComida.setText(c.getDescripcion());
	Element caloriasComida = new Element("calorias");
	caloriasComida.setText(Integer.toString(c.getCalorias()));

	// aniadimos los elementos a la comida
	comida.addContent(nombreComida);
	comida.addContent(precioComida);
	comida.addContent(descripcionComida);
	comida.addContent(caloriasComida);

	// aniadimos la comida a la raiz
	raiz.addContent(comida);

	// escribimos en el fichero
	SALIDA.output(doc, new FileWriter(fichero));
    }

    /**
     * Elimica la comida con precio mas alto
     *
     * @throws IOException
     */
    public void eliminarComidaMasCara() throws IOException {
	Element raiz = doc.getRootElement();
	float precioMaximo = 0;
	Element comidaMasCara = null;
	List<Element> comidas = raiz.getChildren();
	for (Element e : comidas) {
	    float precioComida = Float.parseFloat(e.getChildText("precio"));
	    // si el precio de la comida es mayor al maximo
	    if (precioComida > precioMaximo) {
		precioMaximo = precioComida; // precio mas alto
		comidaMasCara = e; // comida mas cara
	    }
	}

	// eliminamos la comida mas cara
	raiz.removeContent(comidaMasCara);

	SALIDA.output(doc, new FileWriter(fichero));
    }
}
