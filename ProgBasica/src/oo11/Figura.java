package oo11;

public abstract class Figura {
	private String y;
	
	public Figura(String y) {
		this.y = y;
	}
	
	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public abstract double calcularArea();
	
	public abstract boolean esRegular();

}
