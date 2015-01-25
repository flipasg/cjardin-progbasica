/**
 * 
 */
package oo1;

/**
 * @author ikk
 *
 */
public class Vaca {
	private String pelo;
	private int edad;
	protected String nombre;
	static int numVaca = 0;
	
	/**
	 * 
	 */
	public Vaca() {
		numeroVacas();
	}
	
	public Vaca(String pelo, int edad, String nombre) {
		this.pelo = pelo;
		this.edad = edad;
		this.nombre = nombre;
		numeroVacas();
	}
	
	public Vaca(String pelo, String nombre) {
		this.pelo = pelo;
		this.nombre = nombre;
		numeroVacas();
	}
	
	public void setPelo(String pelo){
		this.pelo = pelo;
	}
	
	void numeroVacas(){
		numVaca++;
		System.out.println("Se ha creado la Vaca "+numVaca);
	}
	
	public String getPelo(){
		return pelo;
	}
	
	public void setEdad(int edad){
		this.edad = edad;
	}
	
	public int getEdad(){
		return edad;
	}
	
	protected void muu(){
		System.out.println("Muuu...mi nombre es "+nombre+" y mi color de pelo es "+pelo);
	}
	
	public void compararEdad(Vaca v){
		if(v.edad<edad){
			System.out.println("La vaca "+nombre+" es mas vieja que la vaca "+v.nombre);
		}
		else{
			if(edad<v.edad){
				System.out.println("La vaca "+v.nombre+" es mas vieja que la vaca "+nombre);
			}
			else{
				System.out.println("Las vacas son de la misma edad");
			}
		}
	}
}
