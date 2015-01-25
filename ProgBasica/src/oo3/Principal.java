package oo3;

public class Principal {

	public static void main(String[] args) {
		Piolin p1 = new Piolin('M', 7, 78, 5);
		Piolin p2 = new Piolin('H', 9, 90, 9);
		Piolin p3 = new Piolin('M', 4, 55, 2);
		
		p1.getNombres().setNombreAve("Ori");
		p1.getNombres().setNombreDuenio("Ik");
		
		Loro l1 = new Loro('H', 18, 'N', "Rojo");
		
		p1.cantar();
		System.out.println();
		p2.cantar();
		System.out.println();
		p3.cantar();
		System.out.println();
		l1.cantar();
		System.out.println();
		
		System.out.println(p1.getNombres().getNombreAve());
		System.out.println(p1.getNombres().getNombreDuenio());
	}

}
