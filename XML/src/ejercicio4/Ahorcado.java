/**
 *
 */
package ejercicio4;

import java.io.IOException;

import org.jdom2.JDOMException;

/**
 * @author Iker Garcia Ramirez
 * @date 29/4/2015
 *
 */
public class Ahorcado {
    private String palabraAAdivinar;
    private String respuesta;
    private int totalDeVidas;
    private int vidasRestantes;

    /**
     * Constructor de la clase Ahorcado
     *
     * @param palabraAAdivinar
     * @param respuesta
     * @param totalDeVidas
     * @param vidasRestantes
     */
    public Ahorcado() {
	palabraAAdivinar = "cristalera";
	iniciar();
    }

    /**
     * Constructor de la clase Ahorcado
     *
     * @param n
     * @throws JDOMException
     * @throws IOException
     * @throws AhorcadoException
     */
    public Ahorcado(int n) throws JDOMException, IOException, AhorcadoException {
	GestorXML gx = GestorXML.obtenerInstancia();
	palabraAAdivinar = gx.palabraDeLongitud(n);
	iniciar();

    }

    /**
     * Inicia las variables del juego
     *
     */
    public void iniciar() {
	establecerRespuesta();
	int tVidas = palabraAAdivinar.length() - contarLetrasDistintas();
	totalDeVidas = tVidas / 2;
	if (tVidas % 2 != 0)
	    totalDeVidas++;
	vidasRestantes = totalDeVidas;
    }

    public void establecerRespuesta() {
	respuesta = "";
	for (int i = 0; i < palabraAAdivinar.length(); i++) {
	    respuesta += "-";
	}
    }

    /**
     * Cuenta cuantas veces aparece un caracter
     *
     * @param c
     * @return el numero de ocurrencias del caracter
     */
    private int contarLetrasDistintas() {
	int numLetras = 0;
	for (int i = 0; i < palabraAAdivinar.length(); i++) {
	    for (int j = i + 1; j < palabraAAdivinar.length(); j++) {
		if (palabraAAdivinar.charAt(i) == palabraAAdivinar.charAt(j)) {
		    numLetras++;
		}
	    }
	}
	return numLetras;
    }

    /**
     * @param str
     * @param c
     * @return la cadena con el caracter reemplazado
     */
    private String reemplazarCaracter(String str, char c) {
	StringBuilder sb = new StringBuilder(str);
	int indiceLetraAcertada = palabraAAdivinar.indexOf(c);
	while (indiceLetraAcertada != -1) {
	    sb.deleteCharAt(indiceLetraAcertada);
	    sb.insert(indiceLetraAcertada, c);
	    indiceLetraAcertada = palabraAAdivinar.indexOf(c,
		    indiceLetraAcertada + 1);
	}

	return sb.toString();
    }

    /**
     * @param c
     * @return si se ha acertado o no con la letra
     */
    public boolean tirar(char c) {

	if (c <= 'Z' && c >= 'A') {
	    c = (char) (c - ('A' - 'a'));
	}

	// si no se quiere usar StringBuilder:
	// se deberia realizar el mismo proceso pero concatenando
	// hasta la primera ocurrencia '-', luego el caracter
	// hasta la segunda ocurrencia '-', luego el caracter
	// y asi sucesivamente

	// StringBuilder es una clase de Java que crea una Secuencia de
	// caracteres MUTABLE, recordemos que un String es INMUTABLE
	int indiceLetraAcertada = palabraAAdivinar.indexOf(c);
	if (indiceLetraAcertada == -1) {
	    vidasRestantes--;
	    return false;
	}
	respuesta = reemplazarCaracter(respuesta, c);

	return true;
    }

    /**
     * @return the palabraAAdivinar
     */
    public String getPalabraAAdivinar() {
	return palabraAAdivinar;
    }

    /**
     * @return si quedan vidas o no
     */
    public boolean quedanVidas() {
	if (vidasRestantes > 0)
	    return true;

	return false;
    }

    /**
     * @return si se ha acertado la palabra o no
     */
    public boolean completo() {
	if (quedanVidas() && respuesta.equals(palabraAAdivinar))
	    return true;

	return false;
    }

    /**
     * @return el totalDeVidas
     */
    public int getTotalDeVidas() {
	return totalDeVidas;
    }

    /**
     * @return las vidasRestantes
     */
    public int getVidasRestantes() {
	return vidasRestantes;
    }

    /**
     * @return la respuesta
     */
    public String verRespuesta() {
	String respuestaConEspacios = "";
	for (int i = 0; i < respuesta.length(); i++) {
	    respuestaConEspacios += respuesta.charAt(i) + " ";
	}

	// el método trim() devuelve un String
	// si no lo asignamos no devolveremos la cadena "trimeada"
	respuestaConEspacios = respuestaConEspacios.trim();

	return respuestaConEspacios;
    }
}
