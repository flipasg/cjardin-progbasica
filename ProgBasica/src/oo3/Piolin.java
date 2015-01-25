/**
 * 
 */
package oo3;


/**
 * @author ikk
 *
 */
public class Piolin  extends Canario{
	int numPelis;
	
	/**
	 * 
	 */
	public Piolin(char sexo, int edad, float tamanio, int numPelis) {
		super(sexo,edad,tamanio);
		this.numPelis = numPelis;
	}
	
	public void cantar(){
		super.cantar();
		System.out.print(", Pio-pio soy un Piolin");
	}

}
