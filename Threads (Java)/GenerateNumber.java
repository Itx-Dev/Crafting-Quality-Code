public class GenerateNumber extends MathBehavior {
    private int min = 1;
    private int max = 10000;
    @Override
    protected int delegateMath(int x) {
        double num = (Math.random() * max) + min;
        int originalNumber = (int) (Math.floor(num));
        return originalNumber;
    }
}
