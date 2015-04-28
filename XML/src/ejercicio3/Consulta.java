/**
 *
 */
package ejercicio3;

/**
 * @author Iker Garcia Ramirez
 * @date 27/4/2015
 *
 */
public class Consulta {
    private HoraConsulta hora;
    private Paciente paciente;

    /**
     * Constructor de la clase Consulta
     *
     * @param hora
     * @param paciente
     */
    public Consulta(HoraConsulta hora, Paciente paciente) {
	this.hora = hora;
	this.paciente = paciente;
    }

    /**
     * @return ls hora
     */
    public HoraConsulta getHora() {
	return hora;
    }

    /**
     * @return el paciente
     */
    public Paciente getPaciente() {
	return paciente;
    }

}
