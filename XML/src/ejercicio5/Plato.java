/**
 *
 */
package ejercicio5;

/**
 * @author Iker Garcia Ramirez
 * @date 1/5/2015
 *
 */
public class Plato {
    private String tipo;
    private String nombre;
    private String imagen;
    private double precio;

    /**
     * Constructor de la clase Plato
     *
     * @param tipo
     * @param nombre
     * @param precio
     */
    public Plato(String tipo, String nombre, double precio) {
	super();
	this.tipo = tipo;
	this.nombre = nombre;
	this.precio = precio;
    }

    /**
     * Constructor de la clase Plato
     *
     * @param tipo
     * @param nombre
     * @param imagen
     * @param precio
     */
    public Plato(String tipo, String nombre, double precio, String imagen) {
	this.tipo = tipo;
	this.nombre = nombre;
	this.imagen = imagen;
	this.precio = precio;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
	return tipo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
	return imagen;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
	return precio;
    }

}
