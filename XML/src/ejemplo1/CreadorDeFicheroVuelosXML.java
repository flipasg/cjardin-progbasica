/**
 * XML - ejemplo1 : CreadorDeFicheroVuelosXML.java
 * @author Ikk
 * @date 21/4/2015 2015
 */
package ejemplo1;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


//Comienza la clase CreadorDeFicheroVuelosXML
public class CreadorDeFicheroVuelosXML {

    /**
     * Metodo : main
     * @param args
     */
    public static void main(String[] args) {
	Element raiz = new Element("vuelos");
	Document doc = new Document(raiz);
	
	Element vuelo = new Element("vuelo");
	vuelo.setAttribute("id", "0098");
	
	Element origen = new Element("origen");
	origen.setText("Bilbao");
	
	Element destino = new Element("destino");
	destino.setText("Madrid");
	
	Element vuelo2 = new Element("vuelo");
	
	vuelo2.addContent(origen);
	vuelo2.addContent(destino);
	vuelo.addContent(origen);
	vuelo.addContent(destino);
	raiz.addContent(vuelo);
	raiz.addContent(vuelo2);
	
	XMLOutputter salida = new XMLOutputter(Format.getPrettyFormat());
	try {
	    salida.output(doc, System.out);
	    salida.output(doc, new FileWriter("vuelos.xml"));
	} catch (IOException e) {
	    
	    e.printStackTrace();
	}
	
    }

}
