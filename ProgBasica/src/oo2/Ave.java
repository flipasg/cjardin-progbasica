/**
 * 
 */
package oo2;

/**
 * @author ikk
 *
 */
public class Ave {
	char sexo;
	int edad;
	static int numAves = 0;
	
	/**
	 * 
	 */

	
	public Ave(char sexo, int edad) {
		this.sexo = sexo;
		this.edad = edad;
		numAves++;
	}
	
	protected static void numeroDeAves(){
		System.out.println("Se han creado "+numAves+" aves");
	}
	void quienSoy(){
		System.out.println("Sexo: "+sexo+" Edad: "+edad);
	}

}
