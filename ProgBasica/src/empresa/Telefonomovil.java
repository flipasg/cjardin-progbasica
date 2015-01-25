package empresa;

class Telefonomovil {
	private String numero;
	private int bateria;
	
	Telefonomovil(String numero, int bateria) {
		this.numero = numero;
		this.bateria = bateria;
	}
	
	void usar(){
		bateria--;
	}
	
	int getBateria(){
		return bateria;
	}
}
