package excepciones;
import informacion.Hora;

/**
 *
 */


/**
 * @author Iker Garcia Ramirez
 * @date 27/4/2015
 *
 */
public class HoraConsulta extends Hora {

    /**
     * Constructor de la clase HoraConsulta
     *
     * @param horas
     * @param minutos
     * @throws HoraException
     */
    public HoraConsulta(int horas, int minutos) throws HoraException {
	super(horas, minutos);

	// no se como solucionarlo de otra manera
	// la idea es que el constructor de la superclase compruebe si es una
	// hora valida
	// y el de la subclase si es una hora de consulta valida
	if (horas > 15 || horas < 9)
	    throw new HoraException("Consulta no disponible");
	if (minutos != 0 && minutos != 30)
	    throw new HoraException("Consulta no disponible");
    }

}
