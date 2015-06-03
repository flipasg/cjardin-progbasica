package informacion;

public class Socio {
	private String dni;
	private String nombreCompleto;
	private String telefono;
	
	public Socio(String dni, String nombreCompleto, String telefono) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return nombreCompleto;
	}

	public String getDni() {
		return dni;
	}
	
	

}
