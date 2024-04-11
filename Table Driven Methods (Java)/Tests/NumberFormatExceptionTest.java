package Tests;

import org.junit.Test;

import Main.ConvertingMachine;

public class NumberFormatExceptionTest {
  @Test(expected = NumberFormatException.class)
  public void testNumberFormatException() {
    ConvertingMachine machine = new ConvertingMachine();
    
    machine.parse("54.32-");
  }
  
  @Test(expected = NumberFormatException.class)
  public void testNumberFormatException2() {
    ConvertingMachine machine = new ConvertingMachine();
    
    machine.parse("54-23");
  }
  
  @Test(expected = NumberFormatException.class)
  public void testNumberFormatException3() {
    ConvertingMachine machine = new ConvertingMachine();
    
    machine.parse("6+32.23");
  }
  
  @Test(expected = NumberFormatException.class)
  public void testNumberFormatException4() {
    ConvertingMachine machine = new ConvertingMachine();
    
    machine.parse("54.32.23");
  }
  
  @Test(expected = NumberFormatException.class)
  public void testNumberFormatException5() {
    ConvertingMachine machine = new ConvertingMachine();
    
    machine.parse("12..32");
  }

}
