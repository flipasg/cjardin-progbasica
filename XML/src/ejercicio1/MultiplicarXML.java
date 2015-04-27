/**
 *
 */
package ejercicio1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @author Iker Garcia Ramirez
 * @date 27/4/2015
 *
 */
public class MultiplicarXML {

    /**
     * @param args
     */
    public static void main(String[] args) {
	try {
	    BufferedReader b = new BufferedReader(new InputStreamReader(
		    System.in)); // creamos el buffer para leer la entrada
	    System.out
	    .println("¿De que numero desea crear la tabla de multiplicar?");
	    String numeroTexto = b.readLine(); // leemos la entrada
	    int numero = Integer.parseInt(numeroTexto); // parseamos a int

	    // creamos el elemento raiz del documento XML y le aniadimos el
	    // atributo num
	    Element raiz = new Element("tabla")
	    .setAttribute("num", numeroTexto);

	    // creamos un documento a partir de la raiz
	    Document doc = new Document(raiz);

	    for (int i = 1; i < 11; i++) {
		int resultado = numero * i; // operamos
		// creamos el elemento factor y le aniadimos el atributo f
		Element factor = new Element("factor").setAttribute("f",
			Integer.toString(i));
		// creamos el elemento resultadoTag y establecemos su texto al
		// resultado obtenido
		Element resultadoTag = new Element("resultado").setText(Integer
			.toString(resultado));

		// aniadimos el elemento resultadoTag al factor
		factor.addContent(resultadoTag);
		// aniadimos el factor a la raiz del documento
		raiz.addContent(factor);
	    }

	    // creamos la salida con formato XML
	    XMLOutputter salida = new XMLOutputter(Format.getPrettyFormat());
	    salida.output(doc, System.out); // mostramos por pantalla (consola)
	    salida.output(doc, new FileWriter("tabladel " + numeroTexto
		    + ".xml")); // guardamos en fichero
	    b.close();
	} catch (NumberFormatException e) {
	    System.err.println("Error de formato de numero");
	    e.printStackTrace();
	} catch (IOException e) {
	    System.err.println("Error de entrada/salida");
	    e.printStackTrace();
	}
    }

}
