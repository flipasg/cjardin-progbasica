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

    /**
     * @return the codCiclo
     */
    public int getCodCiclo() {
	return codCiclo;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Ciclo other = (Ciclo) obj;
	if (codCiclo != other.codCiclo)
	    return false;
	return true;
    }

}
