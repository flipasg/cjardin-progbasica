/**
 * 
 */
package EjerInicio2;


/**
 * @author dw1_alum9
 *
 */
public class SumProdImp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int suma, producto, cont;
		
		cont = 20;
		suma = 0;
		producto = 1;
		
		while(cont<=40){
			if(cont%2!=0){
				suma+=cont;
				producto*=cont;
			}
			cont++;
		}
		System.out.println("La suma es "+suma);
		System.out.println("El producto es "+producto);
	}

}
