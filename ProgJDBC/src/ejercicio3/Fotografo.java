/**
 *
 */
package ejercicio3;

/**
 * @author Iker Garcia Ramirez
 * @date 28/5/2015
 *
 */
public class Fotografo {
    private int idfotografo;
    private String nombre;
    private boolean premiado;

    /**
     * Constructor de la clase Fotografo
     *
     * @param idfotografo
     * @param nombre
     * @param premiado
     */
    public Fotografo(int idfotografo, String nombre, boolean premiado) {
	super();
	this.idfotografo = idfotografo;
	this.nombre = nombre;
	this.premiado = premiado;
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
     * @return the idfotografo
     */
    public int getIdfotografo() {
	return idfotografo;
    }

}
