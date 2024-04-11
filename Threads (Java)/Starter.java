import java.lang.reflect.InvocationTargetException;

/**
 * @author Merlin
 *
 * 
 */
public class Starter
{

	/**
	 * The number of iterations each behavior should do
	 */
	public static final int NUMBER_OF_TRIALS = 10000;
	private String[] behaviors =
	{ "GenerateNumber", "Multiply", "Add", "Divide", "Subtract", "VerifyNumber"};
	protected Buffer bufferIn, bufferOut, step1Buffer, step2Buffer, step3Buffer;

	/**
	 * spawn off all of the behaviors giving them appropriate input and output
	 * buffers
	 * 
	 * 
	 * @throws ClassNotFoundException
	 *             shouldn't
	 * @throws NoSuchMethodException
	 *             shouldn't
	 * @throws SecurityException
	 *             shouldn't
	 * @throws InstantiationException
	 *             shouldn't
	 * @throws IllegalAccessException
	 *             shouldn't
	 * @throws IllegalArgumentException
	 *             shouldn't
	 * @throws InvocationTargetException
	 *             shouldn't
	 * @throws InterruptedException
	 *             shouldn't
	 */
	public Starter() throws ClassNotFoundException, NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InterruptedException
	{
		Thread threads[] = new Thread[behaviors.length];
		bufferIn = new Buffer();
		step1Buffer = new Buffer();
		step2Buffer = new Buffer();
		step3Buffer = new Buffer();
		bufferOut = new Buffer();

		Buffer[] buffers = {bufferIn, bufferIn, step1Buffer, step2Buffer, step3Buffer, bufferOut, bufferOut};


		for (int i = 0; i < behaviors.length; i++)
		{

			Class<?> behavior = Class.forName(behaviors[i]);
			Class<?> modifierClass = Class.forName("Modifier");

			// i = index of buffer in this expression
			threads[i] = (Thread) modifierClass.getConstructor(Buffer.class, Buffer.class, MathBehavior.class).newInstance(buffers[i], buffers[i+1], behavior.newInstance());
			threads[i].start();
			threads[i].join();
		}

	}

	/**
	 * @throws InvocationTargetException shouldn't
	 * @throws IllegalArgumentException  shouldn't
	 * @throws IllegalAccessException    shouldn't
	 * @throws InstantiationException    shouldn't
	 * @throws SecurityException         shouldn't
	 * @throws NoSuchMethodException     shouldn't
	 * @throws ClassNotFoundException    shouldn't
	 * @throws InterruptedException      shouldn't
	 */
	public static void main() throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InterruptedException
	{

		new Starter();

	}

}
