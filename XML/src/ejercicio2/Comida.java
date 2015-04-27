/**
 *
 */
package ejercicio2;

/**
 * Clase con la informacion sobre una comida
 *
 * @author Iker Garcia Ramirez
 * @date 27/4/2015
 *
 */
public class Comida {
    private String nombre; // nombre de la comida
    private float precio; // precio de la comida
    private String descripcion; // descripcion de la comida
    private int calorias; // calorias de la comida

    /**
     * Constructor de la clase Comida
     *
     * @param nombre
     * @param precio
     * @param descripcion
     * @param calorias
     */
    public Comida(String nombre, float precio, String descripcion, int calorias) {
	this.nombre = nombre;
	this.precio = precio;
	this.descripcion = descripcion;
	this.calorias = calorias;
    }

    /**
     * @return el nombre
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * @return el precio
     */
    public float getPrecio() {
	return precio;
    }

    /**
     * @return el descripcion
     */
    public String getDescripcion() {
	return descripcion;
    }

    /**
     * @return las calorias
     */
    public int getCalorias() {
	return calorias;
    }

}
