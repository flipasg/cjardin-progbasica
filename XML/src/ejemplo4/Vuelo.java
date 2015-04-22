/**
 *
 */
package ejemplo4;

/**
 * @author Iker Garcia Ramirez
 * @date 22/4/2015
 *
 */
public class Vuelo {
    private int id;
    private String origen;
    private String destino;
    private Dia diaSalida, diaLlegada;
    private Hora horaSalida, horaLlegada;

    /**
     * Constructor de la clase Vuelo
     * 
     * @param id
     * @param origen
     * @param destino
     * @param diaSalida
     * @param diaLlegada
     * @param horaSalida
     * @param horaLlegada
     */
    public Vuelo(int id, String origen, String destino, Dia diaSalida,
	    Dia diaLlegada, Hora horaSalida, Hora horaLlegada) {
	this.id = id;
	this.origen = origen;
	this.destino = destino;
	this.diaSalida = diaSalida;
	this.diaLlegada = diaLlegada;
	this.horaSalida = horaSalida;
	this.horaLlegada = horaLlegada;
    }

}
