import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 */

/**
 * @author ikk
 *
 */
public class CalculadoraTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link Calculadora#divide()}.
	 */
	@Test(expected = java.lang.ArithmeticException.class)
	public void testDividePorCero(){
		Calculadora c = new Calculadora(2,0);
		int num = c.divide();
	}

}
