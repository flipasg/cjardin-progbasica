package oo8;

public class FuncionMatem {
	private double x;	
	
	public FuncionMatem(double x) {
		this.x = x;
	}
	
	public double evaluar(){
		return Math.sqrt(Math.sin(Math.pow(x, 3)+((2*x)/9))+Math.cos((6*Math.PI)+Math.tan(Math.pow(Math.E, Math.pow(x, 3)))));
		
	}
	
	public static double evaluarX(double x){
		return Math.sqrt(Math.sin(Math.pow(x, 3)+((2*x)/9))+Math.cos((6*Math.PI)+Math.tan(Math.pow(Math.E, Math.pow(x, 3)))));
		
	}
	
	public static void main(String[] args) {
		FuncionMatem fm1 = new FuncionMatem(0.0);
		
		System.out.println(fm1.evaluar());
		
		System.out.println(fm1.evaluarX(1.0));

	}

}
