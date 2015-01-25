package oo10;

public class Cuadrado extends Figura{
	private static double areaTotal;
	
	public Cuadrado(double lado) {
		this.setArea(Math.pow(lado, 2));
		System.out.println("El area del cuadrado es "+this.getArea());
		this.setPerimetro((lado*4));
		areaTotal+=this.getArea();
		Figura.setAreaTotal(Figura.getAreaTotal()+areaTotal);
	}

	public static double getAreaTotal() {
		return areaTotal;
	}

	public static void setAreaTotal(double areaTotal) {
		Cuadrado.areaTotal = areaTotal;
	}

}
