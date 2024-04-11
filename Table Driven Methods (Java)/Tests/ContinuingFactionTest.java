package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Action.ContinuingFactionAction;
import Main.InterimResult;

public class ContinuingFactionTest {
  @Test
  public void testContinuingFaction() {
    ContinuingFactionAction continuingFactionAction = new ContinuingFactionAction();
    InterimResult result = new InterimResult(0.1, 1, 0);
    
    double resultOfV = continuingFactionAction.execute(result, '9').getV();
    
    assertEquals(0.9, resultOfV);
  }
  

}
