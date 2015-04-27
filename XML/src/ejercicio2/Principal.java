/**
 *
 */
package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Clase para comprobar el funcionamiento de las clase GestionMenu y Comida
 *
 * @author Iker Garcia Ramirez
 * @date 27/4/2015
 *
 */
public class Principal {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
	try {
	    BufferedReader b = new BufferedReader(new InputStreamReader(
		    System.in));

	    // comidas sacadas del enunciado del ejercicio
	    Comida ensaldaCesar = new Comida("Ensalada Cesar", 4.50f,
		    "Ensalada con lechuga y croutons", 650);
	    Comida fabada = new Comida("Fabada", 7.80f,
		    "Cocido de alubias blancas con embutido", 520);
	    Comida chickenBurger = new Comida("Chicken Burger", 3.50f,
		    "Hamburguesa de pollo", 400);

	    // obtenemos el nombre del fichero que tiene la informacion
	    System.out.println("Dime el nombre del fichero");
	    String fichero = b.readLine();

	    // creamos el gestor de menus
	    GestionMenu g = new GestionMenu(fichero);

	    // creamos el menu con la informacion del enunciado (solo una vez)
	    // el fichero debe tener el elemento raiz y la cabecera xml
	    // g.nuevaComida(ensaldaCesar);
	    // g.nuevaComida(fabada);
	    // g.nuevaComida(chickenBurger);

	    g.ver(); // visualizamos el menu

	    // buscamos el plato Fabada
	    Element plato = g.consultaPlato("Fabada");
	    System.out.println(plato.getChildText("nombre"));

	    // la comida mas cara es la fabada (de primeras)
	    // g.eliminarComidaMasCara(); // eliminamos la comida mas cara
	    // g.ver(); // visualizamos el documento

	    // listaremos los platos con menos de 600 calorias
	    // fabada y chicken burger
	    List<Element> listaMenosCalorias = g.consultaPorCalorias(600);
	    for (Element e : listaMenosCalorias) {
		System.out.println(e.getChildText("nombre"));
	    }

	    // vamos a crear un fichero de platos economicos con precio entre
	    // 3.50 y 5 - Fabada y Chicken Burger
	    System.out.println("Dime el nombre del fichero economico");
	    String ficheroEconomico = b.readLine();
	    g.platosEconomicos(ficheroEconomico, 3.50f, 5f);

	    // visualizamos el fichero por consola
	    // parseamos para poder trabajar con el
	    SAXBuilder sb = new SAXBuilder();
	    Document doc = sb.build(ficheroEconomico); // creamos el documento

	    // creamos la salida y mostramos
	    XMLOutputter salida = new XMLOutputter(Format.getPrettyFormat());
	    salida.output(doc, System.out);
	} catch (JDOMException e) {
	    System.err.println("Documento XML no valido");
	    e.printStackTrace();
	} catch (IOException e) {
	    System.err.println("Error de entrada/salida");
	    e.printStackTrace();
	}

    }
}
