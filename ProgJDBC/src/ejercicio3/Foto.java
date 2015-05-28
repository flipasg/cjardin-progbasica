/**
 *
 */
package ejercicio3;

import java.util.Date;

/**
 * @author Iker Garcia Ramirez
 * @date 28/5/2015
 *
 */
public class Foto {
    private int idfoto;
    private String titulo;
    private java.util.Date fecha;
    private String archivo;
    private int visualizaciones;
    private int idfotografo;

    /**
     * Constructor de la clase Foto
     *
     * @param idfoto
     * @param titulo
     * @param fecha
     * @param archivo
     * @param visualizaciones
     * @param idfotografo
     */
    public Foto(int idfoto, String titulo, Date fecha, String archivo,
	    int visualizaciones, int idfotografo) {
	super();
	this.idfoto = idfoto;
	this.titulo = titulo;
	this.fecha = fecha;
	this.archivo = archivo;
	this.visualizaciones = visualizaciones;
	this.idfotografo = idfotografo;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return titulo;
    }

    /**
     * @return the archivo
     */
    public String getArchivo() {
	return archivo;
    }

    public void incrementarVisualizaciones() {
	visualizaciones++;
    }

    /**
     * @return the visualizaciones
     */
    public int getVisualizaciones() {
	return visualizaciones;
    }

    /**
     * @return the idfoto
     */
    public int getIdfoto() {
	return idfoto;
    }

}
