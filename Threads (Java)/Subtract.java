public class Subtract extends MathBehavior {
    @Override
    protected int delegateMath(int x) {
        // Calculate the original answer
        double recalculate = ((x * 3) - 6) / 3.0;
        int recalculatedInt = (int) Math.floor(recalculate);
        return (x - recalculatedInt);
    }
}
