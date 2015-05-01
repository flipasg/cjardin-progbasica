/**
 *
 */
package ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Iker Garcia Ramirez
 * @date 28/4/2015
 *
 */
public class GestorDeConsultas {
    private static final Medico[] MEDICOS = { new Medico("Dr. Saez"),
	new Medico("Dra. Artea"), new Medico("Dr. Cabeza"),
	new Medico("Dra. Kholn") };
    // mejor si fuera una constante pero al lanzar una excepcion no me deja
    private HoraConsulta[] horasDisponibles;
    // HashMap para llevar el control de las consultas de cada medico
    private HashMap<Medico, ArrayList<Consulta>> consultas;
    // para llevar el control de si ya hay un GestorDeConsultas instanciado
    private static GestorDeConsultas instancia; // patron Singleton

    /**
     * Constructor de la clase GestorDeConsultas (privado)
     *
     * @throws HoraException
     */
    private GestorDeConsultas() throws HoraException {
	// establecemos las horas disponibles
	horasDisponibles = new HoraConsulta[14];
	int hora = 9;
	int minuto = 0;
	for (int i = 0; i < horasDisponibles.length; i++) {
	    if (i % 2 != 0) {
		minuto = 30;
	    } else {
		minuto = 0;
	    }
	    horasDisponibles[i] = new HoraConsulta(hora, minuto);

	    if (i % 2 != 0) {
		hora++;
	    }

	}
	// iniciamos el HashMap de las consultas con las claves de los medicos
	// los medicos inicialmente no tienen consultas
	consultas = new HashMap<Medico, ArrayList<Consulta>>();
	for (int i = 0; i < MEDICOS.length; i++) {
	    consultas.put(MEDICOS[i], new ArrayList<Consulta>());
	}
    }

    /**
     * @param consultas
     *            the consultas to set
     */
    public void setConsultas(HashMap<Medico, ArrayList<Consulta>> consultas) {
	this.consultas = consultas;
    }

    /**
     * Devuelve la instancia del GestorDeConsultas Para instanciar un Gestor hay
     * que llamar a este metodo
     *
     * @return la instancia
     * @throws HoraException
     */
    public static GestorDeConsultas obtenerInstancia() throws HoraException {
	if (instancia == null)
	    instancia = new GestorDeConsultas();

	return instancia;
    }

    /**
     * @return los medicos
     */
    public static Medico[] getMedicos() {
	return MEDICOS;
    }

    /**
     * @return las horasDisponibles
     */
    public HoraConsulta[] getHorasDisponibles() {
	return horasDisponibles;
    }

    /**
     * @return las consultas
     */
    public HashMap<Medico, ArrayList<Consulta>> getConsultas() {
	return consultas;
    }

    /**
     * Se encarga de aniadir una consulta al HashMap
     *
     * @param m
     * @param p
     * @param h
     * @throws ConsultaException
     */
    public void aniadirConsulta(Medico m, Paciente p, HoraConsulta h)
	    throws ConsultaException {
	if (m == null)
	    throw new ConsultaException("Medico erroneo");
	if (p == null)
	    throw new ConsultaException("Paciente erroneo");
	if (h == null)
	    throw new ConsultaException("Hora erroneo");
	consultas.get(m).add(new Consulta(h, p));
    }

    /**
     * Devuelve si el medico tiene o no una consultas en una hora determinada
     *
     * @param m
     * @param h
     * @return si hay una consulta (o no)
     */
    public boolean hayConsulta(Medico m, HoraConsulta h) {
	ArrayList<Consulta> consultasMedico = consultas.get(m);
	for (Iterator<Consulta> it = consultasMedico.iterator(); it.hasNext();) {
	    Consulta c = it.next();
	    System.out.println(c.getHora());
	}
	for (Consulta c : consultasMedico) {
	    if (c.getHora().toString().equals(h.toString()))
		return true;
	}

	return false;
    }

}
