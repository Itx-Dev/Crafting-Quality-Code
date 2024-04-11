package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Action.ContinuingIntegerAction;
import Main.InterimResult;

public class ContinuingIntegerTest {
  @Test
  public void testContinuingInteger() {
    ContinuingIntegerAction continuingIntegerAction = new ContinuingIntegerAction();
    InterimResult result = new InterimResult(0, 1, 0);
    
    double resultOfV = continuingIntegerAction.execute(result, '9').getV();
    
    assertEquals(9, resultOfV);
  }
}
