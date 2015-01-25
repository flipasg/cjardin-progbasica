package oo11;

public class Cuadrado extends Figura{
	private Punto vertice1;
	private Punto vertice2;
	private Punto vertice3;
	private Punto vertice4;
	
	/**
	 * @param nombre
	 * @param diagonalVertice1
	 * @param diagonalVertice3
	 */
	public Cuadrado(String nombre, Punto diagonalVertice1, Punto diagonalVertice3) {
		super(nombre);
		this.vertice1 = diagonalVertice1;
		this.vertice3 = diagonalVertice3;
		calcularOtraDiagonal(diagonalVertice1, diagonalVertice3);
	}
	
	/**
	 * @param vertice1
	 * @param vertice3
	 */
	private void calcularOtraDiagonal(Punto vertice1, Punto vertice3){
		vertice2 = new Punto(vertice3.getX(), vertice1.getY());
		vertice4 = new Punto(vertice1.getX(), vertice3.getY());
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
		return "CUADRADO [NOMBRE="+getY()+"]["+reg+"]:VERTICES("+vertice1.getX()+","+vertice1.getY()+"),("+vertice2.getX()+","+vertice2.getY()+"),("+vertice3.getX()+","+vertice3.getY()+")"+"),("+vertice4.getX()+","+vertice4.getY()+")";
	}

	/* (non-Javadoc)
	 * @see oo11.Figura#calcularArea()
	 */
	@Override
	public double calcularArea() {
		return vertice1.calcularDistancia(vertice2)*vertice2.calcularDistancia(vertice3);
	}

	/* (non-Javadoc)
	 * @see oo11.Figura#esRegular()
	 */
	@Override
	public boolean esRegular() {
		if(vertice1.calcularDistancia(vertice2)==vertice2.calcularDistancia(vertice3) && vertice3.calcularDistancia(vertice4)==vertice4.calcularDistancia(vertice1)){
			return true;
		}
		else{
			return false;
		}
	}

}
