package ej3;

import java.io.Serializable;

public class TelefonoMovil implements Serializable{
	private String numero;
	private int saldo;
	
	/**
	 * @param numero
	 * @param saldo
	 */
	public TelefonoMovil(String numero, int saldo){
		this.numero = numero;
		this.saldo = saldo;
	}

	/**
	 * @return the saldo
	 */
	public int getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	/**
	 * @param incremento
	 */
	public void cargar(int incremento){
		if(incremento>0) saldo+=incremento;
	}
	
	/**
	 * @param minutos
	 */
	public void llamar(int minutos){
		if(minutos>0){
			if(saldo<=(minutos*2)) saldo = 0;
			else saldo-=(minutos*2);
		}
			
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "número de telefono: " + numero + "con un saldo de " + saldo;
	}
	
	
}
