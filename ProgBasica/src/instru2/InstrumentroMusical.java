package instru2;

import instru1.Sonoro;

public class InstrumentroMusical implements Sonoro{
	private String nombre;
	private String registo;
	
	
	/**
	 * @param nombre
	 * @param registo
	 */
	public InstrumentroMusical(String nombre, String registo) {
		this.nombre = nombre;
		this.registo = registo;
	}


	@Override
	public String toString() {
		return "InstrumentroMusical [nombre=" + nombre + ", registo=" + registo
				+ "]";
	}


	/* (non-Javadoc)
	 * @see instru1.Sonoro#sonar()
	 */
	@Override
	public void sonar() {
		System.out.println("lalala");
	}

}
