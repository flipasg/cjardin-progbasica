package empresa;

class Empresa {
	private String nombre;
	private int beneficio;
	Trabajador gerente;
	Trabajador duenio;
	
	public Empresa(String nombre, int beneficio, Trabajador duenio) {
		this.nombre = nombre;
		this.beneficio = beneficio;
		this.duenio = duenio;
	}
	
	void contratarGerente(Trabajador t){
		gerente = t;
	}
	
	void trabajar(){
		gerente.trabajar();
		duenio.trabajar();
		beneficio+=100;
	}
	
	public String toString(){
		String info = "Empresa "+nombre+" Beneficio: "+beneficio+" DUEÑO -> "+duenio.toString()+" GERENTE -> "+gerente.toString();
		return info;
	}
}
