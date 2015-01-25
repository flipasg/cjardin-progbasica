/**
 * 
 */
package progoo;

/**
 * @author ikk
 *
 */
public class Rectangulo {
	Punto p;
	float anchura;
	float altura;
	
	/**
	 * 
	 */
	public Rectangulo() {
		
	}
	
	public Rectangulo(float anchura, float altura) {
		this.anchura = anchura;
		this.altura = altura;
		p = new Punto(0,0);
		
	}
	
	public Rectangulo(float anchura, float altura, Punto p) {
		this.anchura = anchura;
		this.altura = altura;
		this.p = p;
	}
	
	float area(){
		return anchura*altura;
	}
	boolean esCuadrado(){
		if(anchura==altura){
			return true;
		}
		else{
			return false;
		}
	}
	void visualizar(){
		System.out.println("Altura: "+altura+"\tAnchura: "+anchura+"\tPunto: x:"+p.x+" y:"+p.y);
	}
}
