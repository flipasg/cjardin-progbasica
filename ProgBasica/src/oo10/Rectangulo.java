package oo10;

public class Rectangulo extends Figura{
	private static double areaTotal;
	
	public Rectangulo(double base, double altura) {
		this.setArea(base*altura);
		System.out.println("El area rectangulo es "+this.getArea());
		this.setPerimetro((base*2)+(altura*2));
		areaTotal+=this.getArea();
		Figura.setAreaTotal(Figura.getAreaTotal()+areaTotal);
	}

	public static double getAreaTotal() {
		return areaTotal;
	}

	public static void setAreaTotal(double areaTotal) {
		Rectangulo.areaTotal = areaTotal;
	}
	
}
