import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StarterTest {
    @Test
    public void testMultiply() {
        Multiply multiply = new Multiply();
        int answer = multiply.delegateMath(2);
        assertEquals(6, answer);
    }

    @Test
    public void testAdd() {
        Add add = new Add();
        int answer = add.delegateMath(2);
        assertEquals(8, answer);
    }

    @Test
    public void testDivide() {
        Divide divide = new Divide();
        int answer = divide.delegateMath(21);
        assertEquals(7, answer);
    }

    @Test
    public void Subtract() {
        Subtract subtract = new Subtract();
        int answer = subtract.delegateMath(5);
        // Beginning input is 5
        assertEquals(2, answer);
    }

    @Test
    public void testLargeAmountOfTrials() throws ClassNotFoundException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < Starter.NUMBER_OF_TRIALS; i++) {
            Starter starter = new Starter();
            assertEquals(2, starter.bufferOut.read());
        }

    }
}
