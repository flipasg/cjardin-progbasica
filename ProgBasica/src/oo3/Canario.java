/**
 * 
 */
package oo3;

/**
 * @author ikk
 *
 */
public class Canario extends Ave{
	private float tamanio;
	

	public Canario(char sexo, int edad, float tamanio) {
		super(sexo, edad);
		this.tamanio = tamanio;
	}
	
	public Canario(char sexo, int edad) {
		super(sexo, edad);
	}
	
	private void altura(){
		if(tamanio>30){
			System.out.println("Alto");
		}
		else{
			if(tamanio>15){
				System.out.println("Mediano");
			}
			else{
				System.out.println("Bajo");
			}
		}
	}

}
