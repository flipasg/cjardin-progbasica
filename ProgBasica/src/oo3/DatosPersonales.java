package oo3;

public class DatosPersonales {
	private String nombreAve;
	private String nombreDuenio;
	
	public DatosPersonales(String nombreAve, String nombreDuenio) {
		this.nombreAve = nombreAve;
		this.nombreDuenio = nombreDuenio;
	}
	public DatosPersonales(){
		
	}
	public String getNombreAve(){
		return nombreAve;
	}
	
	public String getNombreDuenio(){
		return nombreDuenio;
	}
	
	public void setNombreAve(String nombreAve){
		this.nombreAve = nombreAve;
	}
	
	public void setNombreDuenio(String nombreDuenio){
		this.nombreDuenio = nombreDuenio;
	}

}
