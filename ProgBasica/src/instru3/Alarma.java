/**
 * 
 */
package instru3;

import instru1.Sonoro;

/**
 * @author ikk
 *
 */
public class Alarma implements Sonoro{
	private Hora hora;
	
	
	/**
	 * @param hora
	 */
	public Alarma(Hora hora) {
		this.hora = hora;
	}
	/*
	 * @param 
	 */
	public Alarma(int hora, int minutos) {
		this.hora = new Hora(hora, minutos);
	}

	/* (non-Javadoc)
	 * @see instru1.Sonoro#sonar()
	 */
	@Override
	public void sonar() {
		System.out.println("riingg");
		
	}

}
