package Verifiers;

/**
 * @author Devin
 *
 */
public class PeriodInputVerifier implements InputVerifier {

  @Override
  public boolean meetsCriteria(char c) {
    if (c == 46) {
      return true;
    } else {
      return false;
    }
  }
  

}
