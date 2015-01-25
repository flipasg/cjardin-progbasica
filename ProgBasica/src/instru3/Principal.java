/**
 * 
 */
package instru3;

import instru1.Sonoro;
import instru2.InstrumentoCuerda;
import instru2.InstrumentroMusical;

import java.net.Socket;

/**
 * @author ikk
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Alarma a1 = new Alarma(16, 34);
		Hora h1 = new Hora(9, 10);
		Alarma a2 = new Alarma(h1);
		Alarma a3 = new Alarma(new Hora(6, 9));
		
		a1.sonar();
		a2.sonar();
		a3.sonar();
		
		InstrumentroMusical im1 = new InstrumentroMusical("MiNOMBRE", "Reg2");
		
		im1.sonar();
		System.out.println(im1.toString());
		
		InstrumentoCuerda ic1 = new InstrumentoCuerda("Minom2", "reg3", 5);
		ic1.sonar();
		System.out.println(ic1.toString());
	}

}
