/**
 * 
 */
package oo1;

/**
 * @author ikk
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Vaca miVaca1 = new Vaca("negro", 21, "Pring");
		
		Vaca miVaca2 = new Vaca("marron", "Prang");
		miVaca2.setEdad(45);
		
		Vaca miVaca3 = new Vaca();
		miVaca3.nombre = "Prung";
		miVaca3.setEdad(37);
		miVaca3.setPelo("rojo");
		
		//cambiamos la visibilidd del metodo de private a protected
		miVaca1.muu();
		miVaca2.muu();
		miVaca3.muu();
		
		miVaca1.compararEdad(miVaca2);
		
		System.out.println("El nombre de la primera vaca es "+miVaca1.nombre);
		
		miVaca1.setEdad(miVaca1.getEdad()+1);
		
	}

}
