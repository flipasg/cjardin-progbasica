package vehiculo;

public abstract class Tren extends Vehiculo{
	private int numVagones;
	private int cantCarbon;
	
	public int getCantCarbon() {
		return cantCarbon;
	}

	public void setCantCarbon(int cantCarbon) {
		this.cantCarbon = cantCarbon;
	}

	public Tren(String nombre, int numVagones) {
		super(nombre);
		this.numVagones = numVagones;
	}
	
	public abstract void repostar();

}
