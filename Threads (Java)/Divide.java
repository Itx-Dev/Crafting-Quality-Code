public class Divide extends MathBehavior {

    @Override
    protected int delegateMath(int x) {
        double temp = x / 3;
        x = (int) Math.floor(temp);
        return (x);
    }
}
