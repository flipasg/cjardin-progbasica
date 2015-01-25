/**
 * 
 */
package oo3;

/**
 * @author ikk
 *
 */
public class Ave {
	private char sexo;
	private int edad;
	private static int numAves = 0;
	private DatosPersonales nombres;
	/**
	 * 
	 */

	public Ave(char sexo, int edad) {
		this.sexo = sexo;
		this.edad = edad;
		nombres=new DatosPersonales();
		numAves++;
	}
	
	private static void numeroDeAves(){
		System.out.println("Se han creado "+numAves+" aves");
	}
	private void quienSoy(){
		System.out.println("Sexo: "+sexo+" Edad: "+edad);
	}
	
	void cantar(){
		System.out.print("Mi nombre es "+nombres.getNombreAve());
	}

	public DatosPersonales getNombres() {
		return nombres;
	}
	
	
}
