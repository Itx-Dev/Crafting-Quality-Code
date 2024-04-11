package Verifiers;

/**
 * @author Merlin
 *
 */
public interface InputVerifier
{
	/**
	 * This method must check for the verifier's criteria
	 * @param c the character we are checking
	 * @return true if the character meets the criteria
	 */
	boolean meetsCriteria(char c);
}
