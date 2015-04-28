/**
 * 
 */
package progoo;

/**
 * @author ikk
 *
 */
public class Tortuga {
	float x,y,ang,totalDistancia;
	/**
	 * 
	 */
	public Tortuga(float x, float y, float ang) {
		this.x = x;
		this.y = y;
		this.ang = ang;
	}
	public Tortuga(float x, float y) {
		this.x = x;
		this.y = y;
		ang = 0f;
	}
	public Tortuga(float ang) {
		x = 0f;
		y = 0f;
		this.ang = ang;
	}
	public void mirarDerecha(){
		ang = 0f;
	}
	public void mirarArriba(){
		ang = 90f;
	}
	public void mirarIzquierda(){
		ang = 180f;
	}
	public void mirarAbajo(){
		ang = -270f;
	}
	public void girarDerecha(float angd){
		ang+=angd;
		while(ang>360){
			ang-=360;
		}
	}
	public void girarIzquierda(float angi){
		ang-=angi;
		while(ang>360){
			ang-=360;
		}
	}
	public void irAdelante(float dist){
		float angrad = (float)((ang*Math.PI)/180);
		x+=(dist*Math.cos(angrad));
		y+=(dist*Math.sin(angrad));
		totalDistancia+=(dist*Math.cos(angrad));
	}
	public void irAtras(float dist){
		float angrad = (float)((ang*Math.PI)/180);
		x-=(dist*Math.cos(angrad));
		y-=(dist*Math.sin(angrad));
		totalDistancia+=(dist*Math.cos(angrad));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tortuga t1 = new Tortuga(5f,7.8f,45f);
		Tortuga t2 = new Tortuga(5f,-7.8f);
		Tortuga t3 = new Tortuga(-345f);
		
		
	}

}
