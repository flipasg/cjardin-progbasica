package herencia;

public class Disco extends Material{
	String discografica;
	
	Disco(int codigo, String titulo, String autor, String discografica){
		super(codigo, titulo, autor);
		this.discografica = discografica;
	}
	
	public void ver(){
		super.ver();
		System.out.print(" Discografica: "+discografica);
	}
	
	
}
