/**
 * 
 */
package herencia;

/**
 * @author ikk
 *
 */
public class Material {
	int codigo;
	String titulo,autor;
	/**
	 * 
	 */
	public Material(int codigo, String titulo, String autor) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
	}
	public void ver(){
		System.out.print("Codigo: "+codigo+" Titulo: "+titulo+" Autor: "+autor);
	}
}
