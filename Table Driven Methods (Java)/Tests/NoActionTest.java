package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Action.NoAction;
import Main.InterimResult;

public class NoActionTest {
  @Test
  public void testNoAction() {
    NoAction noAction = new NoAction();
    InterimResult result = new InterimResult(0, 1, 0);
    
    InterimResult answerResult = noAction.execute(result, '+');
    
    assertEquals(result, answerResult);
  }


 
  

}
