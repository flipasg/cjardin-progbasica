/**
 *
 */
package ejercicio3;

/**
 * @author Iker Garcia Ramirez
 * @date 27/4/2015
 *
 */
public class Persona {
    private String nombre;

    /**
     * Constructor de la clase Persona
     *
     * @param nombre
     */
    public Persona(String nombre) {
	this.nombre = nombre;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return nombre;
    }

    /**
     * @return el nombre
     */
    public String getNombre() {
	return nombre;
    }
}
