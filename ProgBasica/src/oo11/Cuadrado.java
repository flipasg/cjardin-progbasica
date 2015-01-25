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
		double diagonal;
		double lado;
		double ang;
		double ca,sa;
		double x2,y2,x4,y4;
		
		diagonal = Math.sqrt(Math.pow((vertice3.getX()-vertice1.getX()), 2)+Math.pow((vertice3.getY()-vertice1.getY()), 2));
		lado = diagonal/(Math.sqrt(2));
		
		ang = (Math.PI/4)-Math.asin((vertice3.getY()-vertice1.getY())/diagonal);
		sa = lado*Math.sin(ang);
		ca = lado*Math.cos(ang);
		
		
		x2 = vertice3.getX()-ca;
		y2 = vertice3.getY()+sa;
		x4 = vertice1.getX()+ca;
		y4 = vertice1.getY()-sa; 
		
		vertice2 = new Punto(x2, y2);
		vertice4 = new Punto(x4, y4);
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
