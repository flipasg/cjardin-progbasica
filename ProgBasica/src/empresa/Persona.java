package empresa;

class Persona {
	private String nombre;
	private String dni;
	private int altura;
	private int peso;
	
	public Persona(String dni) {
		this.dni = dni;
		nombre = "";
		altura = 0;
		peso = 0;
	}
	
	public Persona(String dni, String nombre, int altura, int peso) {
		this.dni = dni;
		this.nombre = nombre;
		this.altura = altura;
		this.peso = peso;
	}
	
	public String toString(){
		String info = "Nombre: "+nombre+" Peso: "+peso;
		return info;
	}
}
