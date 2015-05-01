package informacion;
/**
 *
 */


import gestor.GestorXML;

import java.io.IOException;

import org.jdom2.JDOMException;

/**
 * @author Iker Garcia Ramirez
 * @date 29/4/2015
 *
 */
public class Ahorcado {
    private String palabraAAdivinar; // palabra que se debe adivinar
    private String respuesta; // String con el avance del jugador
    private int totalDeVidas; // total de vidas del jugador
    private int vidasRestantes; // vidas restantes del jugador

    /**
     * Constructor de la clase Ahorcado
     *
     * @param palabraAAdivinar
     * @param respuesta
     * @param totalDeVidas
     * @param vidasRestantes
     */
    public Ahorcado() {
	palabraAAdivinar = "cristalera"; // palabra por defecto
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
	// obtenemos la instancia del GestorXML
	GestorXML gx = GestorXML.obtenerInstancia();
	// obtenemos una palabra de la longitud especificada
	palabraAAdivinar = gx.palabraDeLongitud(n);
	iniciar();

    }

    /**
     * Inicia las variables del juego
     *
     */
    public void iniciar() {
	establecerRespuesta(); // establecemos la respuesta
	// el totalDeVidas es igual a la mitad de los caracteres distintos
	int tVidas = palabraAAdivinar.length() - contarLetrasDistintas();
	totalDeVidas = tVidas / 2;
	// si los caracteres distintos son impares sumamos uno al numero de
	// fallos posibles
	if (tVidas % 2 != 0)
	    totalDeVidas++;

	// las vidas restantes empiezan con el total de vidas posibles
	vidasRestantes = totalDeVidas;
    }

    /**
     * Establece la respuesta por defecto ('-' con longitud de la palabra a
     * adivinar)
     *
     */
    public void establecerRespuesta() {
	respuesta = "";
	for (int i = 0; i < palabraAAdivinar.length(); i++) {
	    respuesta += "-";
	}
    }

    /**
     * Cuenta cuantas veces aparece un caracter repetido
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
     * Se encarga de reemplazar un caracter concreto en una cadena de caracteres
     *
     * @param str
     * @param c
     * @return la cadena con el caracter reemplazado
     */
    private String reemplazarCaracter(String str, char c) {
	// si no se quiere usar StringBuilder:
	// se deberia realizar el mismo proceso pero concatenando
	// hasta la primera ocurrencia '-', luego el caracter
	// hasta la segunda ocurrencia '-', luego el caracter
	// y asi sucesivamente

	// StringBuilder es una clase de Java que crea una Secuencia de
	// caracteres MUTABLE, recordemos que un String es INMUTABLE
	StringBuilder sb = new StringBuilder(str);
	// obtenemos el primer indicie del caracter que nos pasan como parametro
	// el metodo indexOf devuelve -1 si no existe
	int indiceLetraAcertada = palabraAAdivinar.indexOf(c);
	while (indiceLetraAcertada != -1) { // mientras exista
	    // borramos el caracter(-)
	    sb.deleteCharAt(indiceLetraAcertada);
	    // insteramoc el caracter (el que nos pasan como parametro)
	    sb.insert(indiceLetraAcertada, c);
	    // obtenemos el indice de la siguiente ocurrencia del caracter
	    indiceLetraAcertada = palabraAAdivinar.indexOf(c,
		    indiceLetraAcertada + 1);
	}

	// devolvemos el String resultante
	return sb.toString();
    }

    /**
     * Se encarga de realizar la tirada de un caracter
     *
     * @param c
     * @return si se ha acertado o no con la letra
     */
    public boolean tirar(char c) {

	// si la letra es mayuscula la pasamos a minuscula
	// los char son tratados como numeros ascii
	// la resta A - a, da el numero de posiciones que hay entre una
	// mayuscula y una minuscula cualquiera

	if (c <= 'Z' && c >= 'A') {
	    c = (char) (c - ('A' - 'a'));
	}

	// obtenemos el primer indice del caracter
	int indiceLetraAcertada = palabraAAdivinar.indexOf(c);
	if (indiceLetraAcertada == -1) { // si no existe en la cadena
	    vidasRestantes--; // restamos una vida
	    return false; // devolvemos falso
	}

	// si existe reemplazamos el caracter
	respuesta = reemplazarCaracter(respuesta, c);

	// devolvemos verdadero
	return true;
    }

    /**
     * Veremos la respuesta con un espacio entre caracteres
     *
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

    /**
     * @return la palabraAAdivinar
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

}
