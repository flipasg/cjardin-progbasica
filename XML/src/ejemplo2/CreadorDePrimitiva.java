/**
 * XML - ejemplo2 : CreadorDePrimitiva.java
 * @author Ikk
 * @date 21/4/2015 2015
 */
package ejemplo2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

//Comienza la clase CreadorDePrimitiva
public class CreadorDePrimitiva {
    
    public static void main(String[] args) {
	Element raiz = new Element("primitiva");
	raiz.setAttribute("fecha", "21/04/2015");
	
	Document doc = new Document(raiz);
	Element tocados = new Element("tocados");
	
	Random rnd = new Random();
	for (int i = 0; i < 7; i++) {
	    tocados.addContent(new Element("num").setText(Integer.toString(rnd.nextInt(49)+1)));
	}
	
	Element reintegro = new Element("reintegro");
	reintegro.addContent(new Element("num").setText(Integer.toString(rnd.nextInt(10))));
	
	raiz.addContent(tocados);
	raiz.addContent(reintegro);
	
	XMLOutputter salida = new XMLOutputter(Format.getPrettyFormat());
	try {
	    salida.output(doc, System.out);
	    salida.output(doc, new FileWriter("primitiva.xml"));
	} catch (IOException e) {
	    
	    e.printStackTrace();
	}
    }
}
