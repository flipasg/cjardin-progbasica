package instru2;

public class InstrumentoCuerda extends InstrumentroMusical{
	private int numeroCuerdas;
	
	
	/**
	 * 
	 */
	public InstrumentoCuerda(String nombre, String registro, int numeroCuerdas) {
		super(nombre, registro);
		this.numeroCuerdas = numeroCuerdas;
	}


	public void sonar(){
		System.out.println("ñiñiñi");
	}
	
}
