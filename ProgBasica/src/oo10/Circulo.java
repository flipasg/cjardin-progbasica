package oo10;

public class Circulo extends Figura{
	private static double areaTotal;

	public Circulo(double radio) {
		this.setArea(Math.pow(radio,2)*Math.PI);
		System.out.println("El area del circulo es "+this.getArea());
		this.setPerimetro(2*Math.PI*radio);
		areaTotal+=this.getArea();
		Figura.setAreaTotal(Figura.getAreaTotal()+areaTotal);
	}

	public static double getAreaTotal() {
		return areaTotal;
	}

	public static void setAreaTotal(double areaTotal) {
		Circulo.areaTotal = areaTotal;
	}

}
