package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Verifiers.PlusInputVerifier;

/**
 * @author Devin
 *
 */
public class PlusVerifierTest {

  /**
   * Test that plus sign asserts True.
   */
  @Test
  public void testPlusSign() {
    PlusInputVerifier plusInputVerifier = new PlusInputVerifier();
    
    boolean truePlusSign = plusInputVerifier.meetsCriteria('+');
    
    assertTrue(truePlusSign);
  }
  
  /**
   * Test that non plus sign asserts false.
   */
  @Test
  public void testNonPlusSign() {
    PlusInputVerifier plusInputVerifier = new PlusInputVerifier();
    
    // Test that all digits return false.
    char[] digitCharArray = "1234567890".toCharArray();
    
    for (int i = 0; i < digitCharArray.length; i++) {
      char notPlusSign = digitCharArray[i];
      
      boolean falseVariable = plusInputVerifier.meetsCriteria(notPlusSign);
      
      assertFalse(falseVariable);
    }
    
    // Test that all alphabetical characters return false.
    char[] alphabetCharArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
    for (int i = 0; i < alphabetCharArray.length; i++) {
      char notPlusSign = alphabetCharArray[i];
      
      boolean falseVariable = plusInputVerifier.meetsCriteria(notPlusSign);
      
      assertFalse(falseVariable);
    }
  }
}
