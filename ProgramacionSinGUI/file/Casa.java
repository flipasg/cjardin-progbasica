/**
 * 
 */
package EjerOO1;

/**
 * @author ikk
 *
 */
public class Casa {
	String direccion;
	float superficie;
	char tipo;
	static int n = 0;
	Casa(char tipo, String direccion, float superficie){
		this.tipo = tipo;
		this.direccion = direccion;
		this.superficie = superficie;
		n++;
		System.out.println("INSTANCIADA LA CASA "+n);
	}
	void mostrar(){
		if(this.tipo=='p'){
			System.out.print("Piso");
		}
		else{
			System.out.print("Unifamiliar");
		}
		System.out.print(" en "+this.direccion+", Superficie: "+this.superficie+"m2");
	}
	float dameImpuesto(){
		if(this.superficie<60){
			return 0;
		}
		else{
			if(this.superficie>=60 && this.superficie<80){
				return (float)(superficie*4.5);
			}
			else{
				return (float)(superficie*5.5);
			}
		}
	}
	boolean esVendible(){
		if(this.tipo=='u' || this.superficie>=100){
			return true;
		}
		else{
			return false;
		}
	}
	boolean esSimilar(Casa c){
		if(c.tipo==this.tipo && (c.superficie<=(this.superficie+10) && c.superficie>=this.superficie-10)){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Casa casa1 = new Casa('p',"C/Rioja, 18",65);
		/*casa1.tipo = 'p';
		casa1.direccion = "C/Rioja, 18";
		casa1.superficie = 65;*/
		
		Casa casa2 = new Casa('u',"C/Alava, 5",150);
		/*casa2.tipo = 'u';
		casa2.direccion = "C/Alava, 5";
		casa2.superficie = 150;*/
		
		Casa casa3 = new Casa('p',"C/Gorbea, 23",105.5f);
		/*casa3.tipo = 'p';
		casa3.direccion = "C/Gorbea, 23";
		casa3.superficie = 105.5f;*/
		System.out.println();
		
		casa1.mostrar();
		System.out.println();
		casa2.mostrar();
		System.out.println();
		casa3.mostrar();
		System.out.println();
		System.out.println();
		
		casa2.superficie-=5;
		casa1.mostrar();
		System.out.println();
		casa2.mostrar();
		System.out.println();
		casa3.mostrar();
		System.out.println();
		
		System.out.println();
		System.out.println("El impuesto a pagar por la casa1 es "+casa1.dameImpuesto());
		System.out.println("El impuesto a pagar por la casa2 es "+casa2.dameImpuesto());
		System.out.println("El impuesto a pagar por la casa3 es "+casa3.dameImpuesto());
		System.out.println();
		
		if(casa1.esVendible()){
			casa1.mostrar();
			System.out.print(" es vendible");
			System.out.println();
		}
		if(casa2.esVendible()){
			casa2.mostrar();
			System.out.print(" es vendible");
			System.out.println();
		}
		if(casa3.esVendible()){
			casa3.mostrar();
			System.out.print(" es vendible");
			System.out.println();
		}
		System.out.println();
		
		if(casa2.esSimilar(casa3)){
			casa2.mostrar();
			System.out.print(" es similar a ");
			casa3.mostrar();
			System.out.println();
		}
		else{
			casa2.mostrar();
			System.out.print(" no es similar a ");
			casa3.mostrar();
			System.out.println();
		}
		
		if(casa1.esSimilar(casa3)){
			casa1.mostrar();
			System.out.print(" es similar a ");
			casa3.mostrar();
			System.out.println();
		}
		else{
			casa1.mostrar();
			System.out.print(" no es similar a ");
			casa3.mostrar();
			System.out.println();
		}
		System.out.println();
		
		casa1.superficie+=35;
		if(casa1.esSimilar(casa3)){
			casa1.mostrar();
			System.out.print(" es similar a ");
			casa3.mostrar();
			System.out.println();
		}
		else{
			casa1.mostrar();
			System.out.print(" no es similar a ");
			casa3.mostrar();
			System.out.println();
		}
	}

}
