package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Action.StartFraction;
import Main.InterimResult;

public class StartFractionTest {
  @Test
  public void testStartFraction() {
    StartFraction startFraction = new StartFraction();
    InterimResult result = new InterimResult(0, 1, 0);
    
    double resultOfP = startFraction.execute(result, '9').getP();
    
    
    assertEquals(0.1, resultOfP);
    
    
  }

}
