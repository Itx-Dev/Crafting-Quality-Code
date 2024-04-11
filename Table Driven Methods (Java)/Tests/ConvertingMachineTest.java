package Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Main.ConvertingMachine;

/**
 * @author Merlin
 *
 */
public class ConvertingMachineTest
{

	private ConvertingMachine m;

	/**
	 * A negative number with multiple digits in both the integer and fraction portions
	 */
	@Test
	public void fullNegative()
	{
		assertEquals(-42.16, m.parse("-42.16"), 0.001);
	}

	/**
	 * A positive number with multiple digits in both the integer and fraction portions
	 */
	@Test
	public void fullPositive()
	{
		assertEquals(42.16, m.parse("42.16"), 0.001);
	}

	/**
	 * if it isn't a number, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacter()
	{
		m.parse("a");
	}
	
	/**
	 * if there are illegal characters in the integer portion, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacterInInteger()
	{
		m.parse("4-");
	}

	/**
	 * if there are illegal characters in the decimal portion, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacterInDecimal()
	{
		m.parse("4.+");
	}
	/**
	 * integers with multiple digits 
	 */
	@Test
	public void multipleDigitInteger()
	{
		assertEquals(42, m.parse("42"), 0.001);
	}

	/**
	 * Negative integer with multiple digits
	 */
	@Test
	public void negativeInteger()
	{
		assertEquals(-42, m.parse("-42"), 0.001);
	}

	/**
	 * We can have a negative sign followed by the decimal point (no integer portion)
	 */
	@Test
	public void negativeNoInteger()
	{
		assertEquals(-0.16, m.parse("-.16"), 0.001);
	}

	/**
	 * Numbers can start with the decimal point
	 */
	@Test
	public void noInteger()
	{
		assertEquals(0.16, m.parse(".16"), 0.001);
	}

	/**
	 * Just create the machine
	 */
	@Before
	public void setUp()
	{
		m = new ConvertingMachine();
	}

	/**
	 * Zero is legal
	 */
	@Test
	public void zero()
	{
		assertEquals(0, m.parse("0"), 0.001);
	}
}
