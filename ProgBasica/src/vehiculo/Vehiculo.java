package vehiculo;

public abstract class Vehiculo {
	private String nombre;
	private int numRuedas;
	private boolean enMarcha;
	private int lCombustible;

	public int getlCombustible() {
		return lCombustible;
	}

	public void setlCombustible(int lCombustible) {
		this.lCombustible = lCombustible;
	}

	public Vehiculo(String nombre) {
		this.nombre = nombre;
	}
	
	public void arrancar(){
		enMarcha = true;
	}
	
	public void parar(){
		enMarcha = false;
	}
	
	public void ver(){
		System.out.print("El vehiculo "+nombre+" tiene "+numRuedas);
		if(enMarcha){
			System.out.print(" y está en marcha");
		}
		else{
			System.out.print(" y no está en marcha");
		}
	}
	
	public abstract void repostar();

}
