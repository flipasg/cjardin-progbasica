package empresa;

class Trabajador extends Persona{
	private int dinero;
	private Telefonomovil movil;
	
	public Trabajador(String dni, int dinero, Telefonomovil movil) {
		super(dni);
		this.dinero = dinero;
		this.movil = movil;
	}
	
	public Trabajador(String dni, String nombre, int altura, int peso, int dinero, Telefonomovil movil) {
		super(dni, nombre, altura, peso);
		this.dinero = dinero;
		this.movil = movil;
	}
	void ganarDinero(int ganancia){
		dinero+=ganancia;
	}
	
	void gastarDinero(int gasto){
		dinero-=gasto;
	}
	
	public String toString(){
		String info = super.toString()+" Dinero: "+dinero+" Bateria: "+movil.getBateria();
		return info;
	}
	
	void trabajar(){
		movil.usar();
		dinero+=10; // o ganarDinero(10);
	}

}
