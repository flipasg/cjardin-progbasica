
public class Calculadora {
	int num1, num2;
	
	public Calculadora(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int resta(){
		if(compruebaOrden()) return num1-num2;
		else return num2-num1;
		
	}
	
	public boolean compruebaOrden(){
		if(num1>=num2) return true;
		return false;
	}
	
	public int divide(){
		if(num2==0) throw new java.lang.ArithmeticException("No vale");
		return num1/num2;
	}
	
	//hola pc de casa
	
}