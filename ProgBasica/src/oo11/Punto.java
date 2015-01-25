package oo11;

/**
 * @author ikk
 *
 */
/**
 * @author ikk
 *
 */
public class Punto {
	private double x,y;

	/**
	 * @param x
	 * @param y
	 */
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Punto (x=" + x + ", y=" + y + ")";
	}
	
	/**
	 * @return double
	 */
	public double distanciaOrigen(){
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}
	
	/**
	 * @param p2
	 * @return double
	 */
	public double calcularDistancia(Punto p2){
		return Math.sqrt(Math.pow(this.x-p2.x, 2)+Math.pow(this.y-p2.y, 2));
	}
	
	/**
	 * @param x
	 * @param y
	 * @return double
	 */
	public double calcularDistancia(double x, double y){
		return Math.sqrt(Math.pow(this.x-x, 2)+Math.pow(this.y-y, 2));
	}
	
	/**
	 * @return int
	 */
	public int calcularCuadrante(){
		if(x==0 && y==0){
			return 1;
		}
		else{
			if(x>0 && y>0){
				return 1;
			}
			else{
				if(x<0 && y>0){
					return 2;
				}
				else{
					if(x<0 && y<0){
						return 3;
					}
					else{
						return 4;
					}
				}
			}
		}
	}
	
	/**
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return Punto
	 */
	public Punto calcularMasCercano(Punto p1, Punto p2, Punto p3){
		double d1 = this.calcularDistancia(p1.x, p1.y);
		double d2 = this.calcularDistancia(p2.x, p2.y);
		double d3 = this.calcularDistancia(p3.x, p3.y);
		
		if(d1==d2 && d2==d3){
			return null;
		}
		else{
			if(d1==d2){
				if(d2<d3){
					return p2;
				}
				else{
					return p3;
				}
			}
			else{
				if(d2==d3){
					if(d1<d2){
						return p1;
					}
					else{
						return p2;
					}
				}
				else{
					if(d1<d2 && d1<d3){
						return p1;
					}
					else{
						if(d2<d1 && d2<d3){
							return p2;
						}
						else{
							return p3;
						}
					}
				}
			}
		}
	}

}
