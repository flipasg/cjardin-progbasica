/**
 * 
 */
package arrays;

/**
 * @author ik010137ad
 *
 */
public class UniString{

	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		//declaramos e instanciamos el array
		String arrayString[] = {"1","2","3","4"};
		
		//visualizar el array
		for(int i = 0; i<arrayString.length; i++){
			System.out.print(arrayString[i]+" ");
		}
		System.out.println();
		
		//intercambio de posiciones 1-2 3-4 ... 
		String aux = "";
		if(arrayString.length%2==0){
			for(int i = 0; i<arrayString.length; i+=2){
				aux = arrayString[i];
				arrayString[i] = arrayString[i+1];
				arrayString[i+1] = aux;
			}
		}else{
			for(int i = 0; i<arrayString.length-1; i+=2){
				aux = arrayString[i];
				arrayString[i] = arrayString[i+1];
				arrayString[i+1] = aux;
			}
		}
		
		//visualizar array
		for(int i = 0; i<arrayString.length; i++){
			System.out.print(arrayString[i]+" ");
		}
		System.out.println();
	}

}
