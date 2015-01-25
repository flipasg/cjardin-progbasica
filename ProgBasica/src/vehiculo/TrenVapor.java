package vehiculo;

public class TrenVapor extends Tren{
	
	
	public TrenVapor(String nombre, int numVagones) {
		super(nombre, numVagones);
	}

	@Override
	public void repostar() {
		arrancar();
		setCantCarbon(getCantCarbon()+25);
		parar();
	}

}
