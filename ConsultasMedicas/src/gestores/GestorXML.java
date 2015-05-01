package gestores;
/**
 *
 */


import informacion.Consulta;
import informacion.Medico;
import informacion.Paciente;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import excepciones.HoraConsulta;
import excepciones.HoraException;

/**
 * @author Iker Garcia Ramirez
 * @date 28/4/2015
 *
 */
public class GestorXML {
    private static final String FICHERO = "consultas.xml"; // nombre del fichero
    private static final XMLOutputter SALIDA = new XMLOutputter(
	    Format.getPrettyFormat()); // clase encargada de mostrar la
    // informacion xml
    private GestorDeConsultas gdc; // gestor de consultas
    private Document doc; // documento xml parseado por SAXBuilder
    // para llevar el control de si ya hay un GestorXML instanciado
    private static GestorXML instancia; // patron Singleton

    /**
     * Constructor de la clase GestorXML
     *
     * @throws IOException
     * @throws JDOMException
     * @throws HoraException
     */
    private GestorXML() throws JDOMException, IOException, HoraException {
	gdc = GestorDeConsultas.obtenerInstancia();
    }

    /**
     * Devuelve la instancia del GestorXML Para instanciar un Gestor hay que
     * llamar a este metodo
     *
     * @return la instancia
     * @throws HoraException
     * @throws IOException
     * @throws JDOMException
     */
    public static GestorXML obtenerInstancia() throws JDOMException,
	    IOException, HoraException {
	if (instancia == null)
	    instancia = new GestorXML();

	return instancia;
    }

    /**
     * @throws JDOMException
     * @throws IOException
     */
    public void parsear() throws JDOMException, IOException {
	SAXBuilder sb = new SAXBuilder();
	doc = sb.build(FICHERO);
    }

    /**
     * Se encarga de iniciar el documento XML unicamente con los medicos
     *
     * @throws IOException
     */
    public void iniciar() throws IOException {
	// obtenemos el HashMap de las consultas, tendrá solo las claves
	// (Medicos)
	HashMap<Medico, ArrayList<Consulta>> consultas = gdc.getConsultas();
	Element raiz = new Element("consultas"); // creamos el elemento raiz
	Document doc = new Document(raiz); // creamos el documento a partir del
	// elemento raiz

	// iteramos sobre el HashMap para aniadir los elementos medico al XML
	for (Iterator<Medico> it = consultas.keySet().iterator(); it.hasNext();) {
	    Medico m = it.next();
	    Element medicoTag = new Element("medico").setAttribute("nombre",
		    m.getNombre());
	    raiz.addContent(medicoTag);
	}

	// escribimos sobre el fichero
	SALIDA.output(doc, new FileWriter(FICHERO));
    }

    /**
     * Se encarga de cargar el HashMap con la informacion contenida en el
     * fichero XML
     *
     * @throws NumberFormatException
     * @throws HoraException
     * @throws JDOMException
     * @throws IOException
     */
    public void cargarHash() throws NumberFormatException, HoraException,
	    JDOMException, IOException {
	parsear(); // parseamos la informacion del fichero

	// obtenemos el HashMap con la informacion
	HashMap<Medico, ArrayList<Consulta>> consultas = gdc.getConsultas();

	// listamos los medicos del fichero
	List<Element> listaMedicos = doc.getRootElement().getChildren();
	for (Element e : listaMedicos) { // iteramos sobre los medicos
	    // instanciamos un medico a partir de su nombre
	    Medico m = new Medico(e.getAttributeValue("nombre"));
	    // listamos sus hijos, unicamente para saber si ya tiene consultas
	    List<Element> listaConsultas = e.getChildren();
	    if (listaConsultas.size() > 0) { // si tiene consultas
		// creamos la consulta partiendo de la informacion que tenemos
		// en el xml
		for (Element e1 : listaConsultas) {
		    Consulta c = new Consulta(
			    new HoraConsulta(Integer.parseInt(e1.getChildText(
				    "hora").split(":")[0]), Integer.parseInt(e1
					    .getChildText("hora").split(":")[1])),
					    new Paciente(e1.getChildText("paciente")));
		    // iteramos sobre las claves del HashMap para añadir la
		    // informacion a este
		    for (Iterator<Medico> it = consultas.keySet().iterator(); it
			    .hasNext();) {
			Medico mHash = it.next();
			if (mHash.getNombre().equals(m.getNombre()))
			    consultas.get(mHash).add(c);
		    }
		}

	    }

	}

	gdc.setConsultas(consultas);

    }

    /**
     * Se encarga de aniadir las consultas de un medico al XML
     *
     * @throws IOException
     * @throws JDOMException
     *
     */
    public void aniadir(Medico m) throws IOException, JDOMException {
	parsear(); // parseamos para obtener la informacion guardada en el
	// fichero
	Element medicoTag = null; // creamos un elemento para el tag del medico

	// obtenemos la lista de los medicos del fichero
	List<Element> listaMedicos = doc.getRootElement().getChildren();
	for (Element e : listaMedicos) { // iteramos sobre los medicos
	    // si el medico pasado como parametro es igual a uno de ellos
	    if (e.getAttributeValue("nombre").equals(m.getNombre()))
		medicoTag = e; // instanciamos el elemento
	}

	// obtenemos el HashMap
	HashMap<Medico, ArrayList<Consulta>> consultas = gdc.getConsultas();
	// obtenemos las consultas del medico partiendo del HashMap
	ArrayList<Consulta> consultasMedico = consultas.get(m);
	for (Consulta c : consultasMedico) { // iteramos sobre las consultas
	    Element co = new Element("consulta");
	    // creamos los elementos a partir de la informacion del HashMap
	    Element h = new Element("hora").setText(c.getHora().toString());
	    Element p = new Element("paciente").setText(c.getPaciente()
		    .getNombre());

	    // aniadimos los elementos al medico (hora y paciente)
	    co.addContent(h);
	    co.addContent(p);
	    medicoTag.addContent(co);
	}

	// escribimos en el documento
	SALIDA.output(doc, new FileWriter(FICHERO));
    }
}
