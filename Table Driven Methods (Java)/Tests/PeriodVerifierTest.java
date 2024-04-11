package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Verifiers.PeriodInputVerifier;

/**
 * @author Devin
 *
 */
public class PeriodVerifierTest {
  /**
   * Test that period symbol asserts True.
   */
  @Test
  public void testPeriod() {
    PeriodInputVerifier periodInputVerifier = new PeriodInputVerifier();
    
    boolean truePeriod = periodInputVerifier.meetsCriteria('.');
    
    assertTrue(truePeriod);
  }
  /**
   * Test that non period symbol asserts false.
   */
  @Test
  public void testNonPeriod() {
    PeriodInputVerifier periodInputVerifier = new PeriodInputVerifier();
    
    // Test that all digits return false.
    char[] digitCharArray = "1234567890".toCharArray();
    
    for (int i = 0; i < digitCharArray.length; i++) {
      char notPeriod = digitCharArray[i];
      
      boolean falseVariable = periodInputVerifier.meetsCriteria(notPeriod);
      
      assertFalse(falseVariable);
    }
    
    // Test that all alphabetical characters return false.
    char[] alphabetCharArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
    for (int i = 0; i < alphabetCharArray.length; i++) {
      char notPeriod = alphabetCharArray[i];
      
      boolean falseVariable = periodInputVerifier.meetsCriteria(notPeriod);
      
      assertFalse(falseVariable);
    }
  }

}
