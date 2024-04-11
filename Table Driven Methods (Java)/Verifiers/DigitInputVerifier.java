package Verifiers;

/**
 * @author Devin
 *
 */
public class DigitInputVerifier implements InputVerifier {

  public boolean meetsCriteria(char c) {
    if (48 <= c && c <= 57) {
      return true;
    } else {
      return false;
    }
  }

}
