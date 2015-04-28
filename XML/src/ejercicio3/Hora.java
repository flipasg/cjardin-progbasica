/**
 *
 */
package ejercicio3;

/**
 * @author Iker Garcia Ramirez
 * @date 22/4/2015
 *
 */
public class Hora {
    private int horas;
    private int minutos;

    /**
     * Constructor de la clase Hora
     *
     * @param horas
     * @param minutos
     * @param segundos
     * @throws HoraException
     */
    public Hora(int horas, int minutos) throws HoraException {
	if (horas > 23 || horas < 0)
	    throw new HoraException("Horas no validas");
	else if (minutos > 60 || minutos < 0)
	    throw new HoraException("Minutos no validos");
	this.horas = horas;
	this.minutos = minutos;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	String horaCompleta = horas + ":";
	if (minutos < 10)
	    horaCompleta += 0 + "" + minutos;
	else
	    horaCompleta += minutos;
	return horaCompleta;
    }

}
