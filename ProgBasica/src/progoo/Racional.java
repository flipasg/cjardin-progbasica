/**
 * 
 */
package progoo;

/**
 * @author ikk
 *
 */
public class Racional {
	int numerador, denominador;
	/**
	 * 
	 */
	public Racional(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}
	public float resultado(){
		return ((float)numerador/denominador);
	}
	public float simplificar(){
		return ((float)numerador/denominador);
	}
}
