/**
 * 
 */
package oo3;

/**
 * @author ikk
 *
 */
public class Loro  extends Ave{
	private char region;
	private String color;
	
	public Loro(char sexo,int edad,char region,String color){
		super(sexo,edad);
		this.region = region;
		this.color = color;
	}
	
	public Loro(char sexo, int edad, char region, String color, String nombreAve, String nombreDuenio) {
		super(sexo, edad, nombreAve, nombreDuenio);
		this.region = region;
		this.color = color;
	}
	
	private void deDondeEres(){
		if(region=='N' || region=='n'){
			System.out.println("Norte");
		}
		else{
			if(region=='S' || region=='s'){
				System.out.println("Sur");
			}
			else{
				if(region=='E' || region=='e'){
					System.out.println("Este");
				}
				else{
					System.out.println("Oeste");
				}
			}
		}
	}
	
	public void cantar(){
		super.cantar();
		System.out.print(", Piiio-piiio loro bonito");
	}

}
