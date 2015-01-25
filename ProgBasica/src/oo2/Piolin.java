/**
 * 
 */
package oo2;


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
	
	public static void main(String[] args) {
		Piolin p1 = new Piolin('M', 7, 40, 5);
		Loro l1 = new Loro('H', 9, 'N', "Rojo");
		
		p1.quienSoy();
		l1.quienSoy();
		
		p1.altura();
		
		l1.deDondeEres();
		
		
		
		numeroDeAves();
	}

}
