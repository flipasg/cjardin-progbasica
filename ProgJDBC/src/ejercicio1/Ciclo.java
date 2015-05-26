/**
 *
 */
package ejercicio1;

/**
 * @author Iker Garcia Ramirez
 * @date 25/5/2015
 *
 */
public class Ciclo {
    private int codCiclo;
    private String titulo;
    private int horas;

    /**
     * Constructor de la clase Ciclo
     *
     * @param codCiclo
     * @param titulo
     * @param horas
     */
    public Ciclo(int codCiclo, String titulo, int horas) {
	this.codCiclo = codCiclo;
	this.titulo = titulo;
	this.horas = horas;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Ciclo: " + codCiclo + "\n\t Titulo: " + titulo + "\n\t Horas: "
		+ horas + "]";
    }

}
