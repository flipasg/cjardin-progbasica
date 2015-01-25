package vehiculo;

public class Coche extends Vehiculo{
	private String tipoMarcha;
	private String motor;
	
	public Coche(String nombre, String tipoMarcha, String motor) {
		super(nombre);
		this.tipoMarcha = tipoMarcha;
		this.motor = motor;
	}

	@Override
	public void repostar() {
		parar();
		setlCombustible(getlCombustible()+25);
		arrancar();
		
	}
	
	
}
