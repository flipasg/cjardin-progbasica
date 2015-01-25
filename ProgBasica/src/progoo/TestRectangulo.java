/**
 * 
 */
package progoo;

/**
 * @author ikk
 *
 */
public class TestRectangulo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Punto p1 = new Punto(2, 3);
		
		Rectangulo r1 = new Rectangulo();
		r1.altura = 12;
		r1.anchura = 3.2f;
		
		Rectangulo r2 = new Rectangulo(1.2f,4.5f);
		Rectangulo r3 = new Rectangulo(5f,5f);
		Rectangulo r4 = new Rectangulo(1.2f,5f,p1);
		
		if(r3.esCuadrado()){
			System.out.println("Es cuadrado");
		}
		else{
			System.out.println("NO es cuadrado");
		}
		
		if(r4.esCuadrado()){
			System.out.println("Es cuadrado");
		}
		else{
			System.out.println("NO es cuadrado");
		}
		
		r2.visualizar();
	}

}
