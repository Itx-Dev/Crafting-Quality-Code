import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Reads from an input buffer, increments and writes to an output buffer unless
 * it is number 0. In that case, it just writes increasing integers to the
 * output buffer
 * 
 * @author Merlin
 *
 */
public class Modifier extends Thread
{
	private Buffer inBuffer;
	private Buffer outBuffer;
	private MathBehavior mathBehavior;

	/**
	 * Create an incrementer
	 *
	 *            ignored unless it is zero
	 * @param inBuffer
	 *            the buffer to read from
	 * @param outBuffer
	 *            the buffer to write to
	 */
	public Modifier(Buffer inBuffer, Buffer outBuffer, MathBehavior mathBehavior)
	{
		this.inBuffer = inBuffer;
		this.outBuffer = outBuffer;
		this.mathBehavior = mathBehavior;
	}

	/**
	 * @see Thread#run()
	 */
	@Override
	public void run()
	{
		try {
			for (int i = 0; i < Starter.NUMBER_OF_TRIALS; i++) {
				mathBehavior.doTheMath(inBuffer, outBuffer);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
