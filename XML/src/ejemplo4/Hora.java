/**
 *
 */
package ejemplo4;

/**
 * @author Iker Garcia Ramirez
 * @date 22/4/2015
 *
 */
public class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    /**
     * Constructor de la clase Hora
     *
     * @param horas
     * @param minutos
     * @param segundos
     * @throws HoraException
     */
    public Hora(int horas, int minutos, int segundos) throws HoraException {
	if (horas > 23 || horas < 0)
	    throw new HoraException("Horas no validas");
	else if (minutos > 60 || minutos < 0)
	    throw new HoraException("Minutos no validos");
	else if (segundos > 60 || segundos < 0)
	    throw new HoraException("Segundos no validos");

	this.horas = horas;
	this.minutos = minutos;
	this.segundos = segundos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return horas + ":" + minutos + ":" + segundos;
    }

}
