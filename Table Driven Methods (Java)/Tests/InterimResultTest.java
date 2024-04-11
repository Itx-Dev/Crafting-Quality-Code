package Tests;
import static org.junit.Assert.*;
import Main.InterimResult;

import org.junit.Test;

/**
 * Most of this class is generated code (I didn't write the getters and setters
 * - I had Eclipse generate them). Therefore, I don't feel the need to
 * explicitly test that code. However, I did create a copy constructor since
 * each subsequent result is built from the preceeding one. Also, I had eclipse
 * generate an equals method so that comparisons of results would be easy. We
 * can test that with the copy constructor test.
 * 
 * @author merlin
 *
 */
public class InterimResultTest
{

	/**
	 * Test the copy constructor (has the side effect of testing the equals
	 * method, too
	 */
	@Test
	public void copyConstructor()
	{
		InterimResult x = new InterimResult(1, 2, 3.4);
		InterimResult y = new InterimResult(x);
		assertEquals(y, x);

	}

}
