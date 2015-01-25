package oo11;

public class Triangulo extends Figura{
	private Punto v1;
	private Punto v2;
	private Punto v3;
	
	/**
	 * @param nombre
	 * @param v1
	 * @param v2
	 * @param v3
	 */
	public Triangulo(String nombre, Punto v1, Punto v2, Punto v3) {
		super(nombre);
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String reg;
		if(esRegular()){
			reg = "REGULAR";
		}
		else{
			reg = "NO REGULAR";
		}
		return "TRIANGULO [NOMBRE="+getY()+"]["+reg+"]:VERTICES("+v1.getX()+","+v1.getY()+"),("+v2.getX()+","+v2.getY()+"),("+v3.getX()+","+v3.getY()+")";
	}

	/* (non-Javadoc)
	 * @see oo11.Figura#calcularArea()
	 */
	@Override
	public double calcularArea() {
		return ((v3.calcularDistancia(v2)*Math.sqrt(((v3.calcularDistancia(v2)/2)*(v3.calcularDistancia(v2)/2))+(v1.calcularDistancia(v2)*v1.calcularDistancia(v2))))/2);
	}

	/* (non-Javadoc)
	 * @see oo11.Figura#esRegular()
	 */
	@Override
	public boolean esRegular() {
		if(v1.calcularDistancia(v2)==v2.calcularDistancia(v3) && v2.calcularDistancia(v3)==v3.calcularDistancia(v1)){
			return true;
		}
		else{
			return false;
		}
	}

}
