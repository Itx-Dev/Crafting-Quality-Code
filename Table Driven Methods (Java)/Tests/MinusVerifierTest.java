package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Verifiers.MinusInputVerifier;

/**
 * @author Devin
 *
 */
public class MinusVerifierTest {
  
  /**
   * Test that minus sign asserts True.
   */
  @Test
  public void testMinusSign() {
    MinusInputVerifier minusInputVerifer = new MinusInputVerifier();
    
    boolean trueMinusSign = minusInputVerifer.meetsCriteria('-');
    
    assertTrue(trueMinusSign);
  }
  
  /**
   * Test that non minus sign asserts false.
   */
  @Test
  public void testNonMinusSign() {
    MinusInputVerifier minusInputVerifer = new MinusInputVerifier();
    
    // Test that all digits return false.
    char[] digitCharArray = "1234567890".toCharArray();
    
    for (int i = 0; i < digitCharArray.length; i++) {
      char notMinusSign = digitCharArray[i];
      
      boolean falseVariable = minusInputVerifer.meetsCriteria(notMinusSign);
      
      assertFalse(falseVariable);
    }
    
    // Test that all alphabetical characters return false.
    char[] alphabetCharArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
    for (int i = 0; i < alphabetCharArray.length; i++) {
      char notMinusSign = alphabetCharArray[i];
      
      boolean falseVariable = minusInputVerifer.meetsCriteria(notMinusSign);
      
      assertFalse(falseVariable);
    }
  }

}
