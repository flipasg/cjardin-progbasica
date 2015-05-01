/**
 *
 */
package ejercicio5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @author Iker Garcia Ramirez
 * @date 1/5/2015
 *
 */
public class GestorXML {
    private static final String FICHERO_RESTAURANTE = "restaurante.xml";
    private static final String FICHERO_PEDIDOS = "pedidos.xml";
    private Document docRestaurante;
    private Document docPedido;

    /**
     * Constructor de la clase GestorXML
     *
     * @throws IOException
     * @throws JDOMException
     */
    public GestorXML() throws JDOMException, IOException {
	parsear();
    }

    /**
     * Parsea el documento XML
     *
     * @throws JDOMException
     * @throws IOException
     */
    public void parsear() throws JDOMException, IOException {
	SAXBuilder sb = new SAXBuilder();
	docRestaurante = sb.build(FICHERO_RESTAURANTE);
	docPedido = sb.build(FICHERO_PEDIDOS);
    }

    /**
     * @param tipoPlato
     * @return la lista de platos
     */
    public Plato[] damePlato(String tipoPlato) {
	ArrayList<Plato> platosADevolver = new ArrayList<Plato>();
	Element raiz = docRestaurante.getRootElement();
	List<Element> platos = raiz.getChildren();
	for (Element e : platos) {
	    if (e.getAttributeValue("tipo").equals(tipoPlato)) {
		Plato p;
		String nombrePlato = e.getAttributeValue("nombre");
		double precioPlato = Double.parseDouble(e
			.getChildText("precio"));
		if (tipoPlato == "adicional") {
		    p = new Plato(tipoPlato, nombrePlato, precioPlato);
		} else {
		    String imagenPlato = e.getChildText("imagen");
		    p = new Plato(tipoPlato, nombrePlato, precioPlato,
			    imagenPlato);
		}
		platosADevolver.add(p);
	    }
	}
	Plato[] aPlatos = new Plato[platosADevolver.size()];
	int i = 0;
	for (Iterator<Plato> it = platosADevolver.iterator(); it.hasNext();) {
	    Plato p = it.next();
	    aPlatos[i] = p;
	    i++;
	}

	return aPlatos;
    }

    private boolean hayPedidos(String fecha) {
	List<Element> pedidos = docPedido.getRootElement().getChildren();
	for (Element e : pedidos) {
	    if (e.getAttributeValue("fecha").equals(fecha))
		return true;
	}

	return false;
    }

    /**
     * @param pedido
     * @throws JDOMException
     * @throws IOException
     */
    public void escribirPedido(ArrayList<Plato> pedido) throws JDOMException,
    IOException {
	GregorianCalendar calendario = new GregorianCalendar();
	int dia = calendario.get(GregorianCalendar.DAY_OF_MONTH);
	int mes = calendario.get(GregorianCalendar.MONTH);

	String diaDeHoy = dia + "-" + mes;
	Element pedidoHoy = new Element("pedido");
	Element adicionales = new Element("adicionales");
	Element primerPlato = new Element("primero");
	Element segundoPlato = new Element("principal");
	for (Plato p : pedido) {
	    if (p.getTipo().equals("primero")) {
		primerPlato.setText(p.getNombre());
	    } else if (p.getTipo().equals("principal")) {
		segundoPlato.setText(p.getNombre());
	    } else {
		Element adicional = new Element("adicional").setText(p
			.getNombre());
		adicionales.addContent(adicional);
	    }
	}
	pedidoHoy.addContent(primerPlato);
	pedidoHoy.addContent(segundoPlato);

	if (adicionales.getChildren().size() > 0) {
	    pedidoHoy.addContent(adicionales);
	}

	if (!hayPedidos(diaDeHoy)) {
	    Element pedidosHoy = new Element("pedidos").setAttribute("fecha",
		    diaDeHoy);
	    pedidosHoy.addContent(pedidoHoy);
	    docPedido.getRootElement().addContent(pedidosHoy);
	} else {
	    List<Element> pedidos = docPedido.getRootElement().getChildren();
	    for (Element e : pedidos) {
		if (e.getAttributeValue("fecha").equals(diaDeHoy))
		    e.addContent(pedidoHoy);
	    }
	}

	XMLOutputter salida = new XMLOutputter(Format.getPrettyFormat());
	salida.output(docPedido, new FileWriter(FICHERO_PEDIDOS));
    }
}
