package herencia;

public class Libro extends Material{
	int paginas;
	
	Libro(int codigo, String nombre, String autor, int paginas){
		super(codigo, nombre, autor);
		this.paginas = paginas;
	}
	
	public void ver(){
		super.ver();
		System.out.print(" Páginas: "+paginas);
	}
	
	
}
